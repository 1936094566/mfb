package com.mc.mfb.admin.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.mc.mfb.admin.excpetion.MfbException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * JAVA-JWT工具类
 * @author Wang926454
 * @date 2018/8/30 11:45
 */
public class JwtUtil {

    /**
     * jwt过期时间
     */
    private static String accessTokenExpireTime = "10" ;


    /**
     * JWT认证加密私钥(Base64加密)
     */
    private static String encryptJWTKey = "test";

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println( Base64ConvertUtil.encode("test"));
    }

    /**
     * 校验token是否正确
     */
    public static boolean verify(String token) {
        try {
            // 帐号加JWT私钥解密
            String secret = getClaim(token, Constant.ACCOUNT) + Base64ConvertUtil.decode(encryptJWTKey);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            //验证不成功会抛出异常
            verifier.verify(token);
            return true;
        } catch (UnsupportedEncodingException e) {
            return false;
            //throw new MfbException("JWTToken认证解密出现UnsupportedEncodingException异常:" + e.getMessage());
        }
    }

    /**
     * 获得Token中的信息无需secret解密也能获得
     */
    public static String getClaim(String token, String claim) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            // 只能输出String类型，如果是其他类型返回null
            return jwt.getClaim(claim).asString();
        } catch (JWTDecodeException e) {
            throw new MfbException("解密Token中的公共信息出现JWTDecodeException异常:" + e.getMessage());
        }
    }

    /**
     * 生成签名
     */
    public static String sign(String account,String currentMillis) {
        try {
            // 帐号加JWT私钥加密
            String secret = account + Base64ConvertUtil.decode(encryptJWTKey);
            // 此处过期时间是以毫秒为单位，所以乘以1000
            Algorithm algorithm = Algorithm.HMAC256(secret);
            Date date = new Date(System.currentTimeMillis() + Long.parseLong(accessTokenExpireTime) * 1000);

            // 附带account帐号信息
            return JWT.create()
                    .withClaim(Constant.CURRENT_TIME_MILLIS, currentMillis)
                    .withClaim(Constant.ACCOUNT, account)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            throw new MfbException("JWTToken加密出现UnsupportedEncodingException异常:" + e.getMessage());
        }
    }
}
