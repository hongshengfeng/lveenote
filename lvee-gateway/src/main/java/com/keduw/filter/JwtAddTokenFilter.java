package com.keduw.filter;

import com.keduw.app.URIFilterDef;
import com.keduw.common.Errno;
import com.keduw.util.PathUtils;
import com.netflix.discovery.converters.Auto;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * @author hongshengfeng
 * @date 2020/07/12
 */
@Component
public class JwtAddTokenFilter extends ZuulFilter {

    @Autowired
    private URIFilterDef uriFilter;

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        String uri = context.getRequest().getRequestURI();
        for (String pathPattern : uriFilter.initURI()) {
            if (PathUtils.match(pathPattern, uri)) {
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
            System.out.println(body);
            /*if (result.getCode() == Errno.OK) {
                HashMap<String, Object> jwtClaims = new HashMap<String, Object>() {{
                    put("userId", result.getData().get("userId"));
                }};
                Date expDate = DateTime.now().plusDays(7).toDate(); //过期时间 7 天
                String token = jwtUtil.createJWT(expDate, jwtClaims);
                //body json增加token
                result.getData().put("token", token);
                //序列化body json,设置到响应body中
                body = objectMapper.writeValueAsString(result);
                ctx.setResponseBody(body);

                //响应头设置token
                ctx.addZuulResponseHeader("token", token);
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
