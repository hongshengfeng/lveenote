package com.keduw.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @author hongshengfeng
 * @date 2020/07/12
 */
public class TokenUtils {

    private static final String SIGNING_KEY = "xian@123";

    /**
     * 生成token
     * @param exp
     * @param claims
     * @return
     */
    public static String createToken(Date exp, Map<String, Object> claims) {
        Date now = new Date(System.currentTimeMillis());
        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now).setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, SIGNING_KEY);
        return builder.compact();
    }

    /**
     * 解析token，获取到有效载荷中的内容
     * @param token
     * @return
     */
    public static Claims parseToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(SIGNING_KEY)
                .parseClaimsJws(token).getBody();
        return claims;
    }
}
