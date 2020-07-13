package com.keduw.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keduw.common.Errno;
import com.keduw.common.R;
import com.keduw.model.UrlAccess;
import com.keduw.service.UrlService;
import com.keduw.util.PathUtils;
import com.keduw.util.TokenUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 登录成功时创建token
 *
 * @author hongshengfeng
 * @date 2020/07/12
 */
@Component
public class JwtAddTokenFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtAddTokenFilter.class);

    @Autowired
    private UrlService urlService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public String filterType() {
        //在路由方法相应之后拦截
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER + 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        String uri = context.getRequest().getRequestURI();
        List<UrlAccess> accesses = urlService.getAccessUrl();
        if(accesses == null || accesses.isEmpty()){
            return true;
        }
        for (UrlAccess access : accesses) {
            if (PathUtils.match(access.getUrl(), uri)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        try {
            InputStream stream = context.getResponseDataStream();
            String body = StreamUtils.copyToString(stream, StandardCharsets.UTF_8);
            if(StringUtils.isBlank(body)){
                return null;
            }
            R data = objectMapper.readValue(body, R.class);
            //登录状态验证通过
            if (data.get("code").equals(Errno.ACCESS)) {
                HashMap<String, Object> claims = new HashMap<>();
                claims.put("aid", data.get("aid"));
                Date expireTime = DateTime.now().plusHours(1).toDate();
                String token = TokenUtils.createToken(expireTime, claims);
                data.put("token", token);
                body = objectMapper.writeValueAsString(data);
                context.setResponseBody(body);
                context.addZuulResponseHeader("token", token);
            }
        } catch (Exception e) {
            logger.error("add token err", e);
        }
        return null;
    }
}
