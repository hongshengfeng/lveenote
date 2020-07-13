package com.keduw.filter;

import com.keduw.common.Errno;
import com.keduw.common.R;
import com.keduw.model.UrlAccess;
import com.keduw.service.UrlService;
import com.keduw.util.JsonUtils;
import com.keduw.util.PathUtils;
import com.keduw.util.TokenUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 拦截业务接口，验证token
 *
 * @author hongshengfeng
 * @date 2020/07/12
 */
@Component
public class JwtAuthPreFilter extends ZuulFilter {

    @Autowired
    private UrlService urlService;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_FORWARD_FILTER_ORDER + 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        String uri = context.getRequest().getRequestURI();
        List<UrlAccess> accesses = urlService.getAuthUrl();
        if(accesses == null || accesses.isEmpty()){
            return true;
        }
        for (UrlAccess access : accesses) {
            if (PathUtils.match(access.getUrl(), uri)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getHeader("token");
        Claims claims;
        try {
            //解析没有异常则表示token验证通过
            claims = TokenUtils.parseToken(token);
            //对请求进行路由
            context.setSendZuulResponse(true);
            //请求头加入aid，传给业务服务
            context.addZuulRequestHeader("aid", claims.get("aid").toString());
        } catch (ExpiredJwtException expiredJwtEx) {
            //token无效
            context.setSendZuulResponse(false);
            responseError(context, Errno.TOKEN_EXPIRE, "token expired");
        } catch (Exception ex) {
            //不对请求进行路由
            context.setSendZuulResponse(false);
            responseError(context, Errno.TOKEN_ILLEGAL, "invalid token");
        }
        return null;
    }

    private void responseError(RequestContext ctx, int code, String message) {
        HttpServletResponse response = ctx.getResponse();
        R r = R.info(code, message);
        ctx.setResponseBody(JsonUtils.objectToJson(r));
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType("application/json;charset=utf-8");
    }
}
