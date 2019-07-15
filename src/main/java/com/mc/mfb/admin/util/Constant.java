package com.mc.mfb.admin.util;

/**
 * @author machao
 * @date 2019/7/12
 * @time 15:15
 * @description
 **/
public class Constant {
    /**
     * 成功状态码
     */
    public static final Integer OK = 200;

    /**
     * 账号
     */
    public static final String ACCOUNT = "account";

    /**
     * redis过期时间，以秒为单位，一分钟
     */
    public final static int EXRP_MINUTE = 60*60;

    /**
     * redis过期时间，以秒为单位，一小时
     */
    public final static int EXRP_HOUR = 60 * 60;

    /**
     * redis过期时间，以秒为单位，一天
     */
    public final static int EXRP_DAY = 60 * 60 * 24;

    /**
     * redis-key-前缀-shiro:cache:
     */
    public final static String PREFIX_SHIRO_CACHE = "shiro:cache:";

    /**
     * redis-key-前缀-shiro:access_token:
     */
    public final static String PREFIX_SHIRO_ACCESS_TOKEN = "shiro:access_token:";

    /**
     * redis-key-前缀-shiro:refresh_token:
     */
    public final static String PREFIX_SHIRO_REFRESH_TOKEN = "shiro:account:token:";

    public final static String CURRENT_TIME_MILLIS = "currentTimeMillis";

}
