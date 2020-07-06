package com.keduw.util;

/**
 * 数据格式化工具
 *
 * @author hongshengfeng
 * @date 2020/01/23
 */
public class Parser {

    /**
     * 将string类型转化成int类型
     * @param str
     * @param value
     * @return
     */
    public static int parserInt(String str, int value){
        try{
            return Integer.parseInt(str);
        }catch (Exception e){
            return value;
        }
    }

    /**
     * 将String类型转化成Long类型
     * @param str
     * @param value
     * @return
     */
    public static long parserLong(String str, long value){
        try{
            return Long.parseLong(str);
        }catch (Exception e){
            return value;
        }
    }

    /**
     * 将String类型转化成Boolean类型
     * @param str
     * @param value
     * @return
     */
    public static boolean parserBoolean(String str, boolean value){
        try{
            return Boolean.parseBoolean(str);
        }catch (Exception e){
            return value;
        }
    }

}
