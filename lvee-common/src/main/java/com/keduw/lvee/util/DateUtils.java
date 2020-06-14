package com.keduw.lvee.util;

import org.apache.commons.lang.StringUtils;
import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式化工具
 *
 * @author 柏渡人
 * @date 2020.01.23
 */
public class DateUtils {

    public final static String DATE_PATTERN = "yyyy-MM-dd";
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期转化成字符串，格式（yyyy-MM-dd）
     * @param date
     * @return
     */
    public static String simpleFormat(Date date) {
        return format(date, DATE_PATTERN);
    }

    /**
     * 日期转化成字符串，格式（yyyy-MM-dd HH:mm:ss）
     * @param date
     * @return
     */
    public static String simpleDataFormat(Date date) {
        return format(date, DATE_TIME_PATTERN);
    }

    /**
     * 日期转化成字符串
     * @param date 日期
     * @param pattern 转换的格式
     * @return
     */
    public static String format(Date date, String pattern) {
        if(date != null){
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            return dateFormat.format(date);
        }
        return null;
    }

    /**
     * 字符串转换成日期
     * @param date 日期字符串
     * @param pattern 转换的格式
     */
    public static Date strToDate(String date, String pattern) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
        return formatter.parseLocalDateTime(date).toDate();
    }

    /**
     * 对日期的【秒】进行加/减
     * @param date    日期
     * @param seconds 秒数，负数为减
     * @return 加/减几秒后的日期
     */
    public static Date addSeconds(Date date, int seconds) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusSeconds(seconds).toDate();

    }

    /**
     * 对日期的【分钟】进行加/减
     * @param date    日期
     * @param minutes 分钟数，负数为减
     * @return 加/减几分钟后的日期
     */
    public static Date addMinutes(Date date, int minutes) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMinutes(minutes).toDate();
    }

    /**
     * 对日期的【小时】进行加/减
     * @param date  日期
     * @param hours 小时数，负数为减
     * @return 加/减几小时后的日期
     */
    public static Date addHours(Date date, int hours) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusHours(hours).toDate();
    }

    /**
     * 对日期的【天】进行加/减
     * @param date 日期
     * @param days 天数，负数为减
     * @return 加/减几天后的日期
     */
    public static Date addDays(Date date, int days) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusDays(days).toDate();
    }

    /**
     * 对日期的【周】进行加/减
     * @param date  日期
     * @param weeks 周数，负数为减
     * @return 加/减几周后的日期
     */
    public static Date addWeeks(Date date, int weeks) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusWeeks(weeks).toDate();
    }

    /**
     * 对日期的【月】进行加/减
     * @param date   日期
     * @param months 月数，负数为减
     * @return 加/减几月后的日期
     */
    public static Date addMonths(Date date, int months) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMonths(months).toDate();
    }

    /**
     * 对日期的【年】进行加/减
     * @param date  日期
     * @param years 年数，负数为减
     * @return 加/减几年后的日期
     */
    public static Date addYears(Date date, int years) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusYears(years).toDate();
    }

    /**
     * 日期相减得到天数
     * @param beforeDate
     * @param afterDate
     * @return afterDate - beforeDate
     */
    public static int diffDate(Date beforeDate, Date afterDate) {
        DateTime beforeDateTime = new DateTime(beforeDate);
        DateTime afterDateTime = new DateTime(afterDate);
        return Days.daysBetween(beforeDateTime, afterDateTime).getDays();
    }

    /**
     * 两个日期相减小时数
     * @param beforeDate 被减日期
     * @param afterDate 日期
     * @return afterDate - beforeDate
     */
    public static int diffHours(Date beforeDate, Date afterDate) {
        DateTime beforeDateTime = new DateTime(beforeDate);
        DateTime afterDateTime = new DateTime(afterDate);
        return Hours.hoursBetween(beforeDateTime, afterDateTime).getHours();
    }

    /**
     * 两个日期相减分钟数
     * @param beforeDate 被减日期
     * @param afterDate 日期
     * @return afterDate - beforeDate
     */
    public static int diffMinutes(Date beforeDate, Date afterDate) {
        DateTime beforeDateTime = new DateTime(beforeDate);
        DateTime afterDateTime = new DateTime(afterDate);
        return Minutes.minutesBetween(beforeDateTime, afterDateTime).getMinutes();
    }

}
