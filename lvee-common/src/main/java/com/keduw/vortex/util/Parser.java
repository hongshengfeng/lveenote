package com.keduw.vortex.util;

/**
 * 数据格式化工具
 *
 * @author 柏渡人
 * @date 2020.01.23
 */
public class Parser {

    /**
     * 将string类型转化成int类型
     * @param value 输入的值
     * @param dValue 默认值
     * @return
     */
    public static int parserInt(String value, int dValue){
        try{
            int num = Integer.parseInt(value);
            return num;
        }catch (Exception e){
            return dValue;
        }
    }

    /**
     * 将String类型转化成Long类型
     * @param value 输入的值
     * @param dValue 默认值
     * @return
     */
    public static Long parserLong(String value, Long dValue){
        try{
            Long num = Long.parseLong(value);
            return num;
        }catch (Exception e){
            return dValue;
        }
    }

    /**
     * 将String类型转化成Boolena类型
     * @param value
     * @param dValue
     * @return
     */
    public static Boolean parserBoolean(String value, boolean dValue){
        try{
            Boolean result = Boolean.parseBoolean(value);
            return result;
        }catch (Exception e){
            return dValue;
        }
    }

}
