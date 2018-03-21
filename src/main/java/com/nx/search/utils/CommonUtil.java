package com.nx.search.utils;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 公共工具类
 * Created by dell on 2017/4/11.
 */
@Slf4j
public class CommonUtil {

    private static final String DATE_PATTERN = "yyyy-MM-dd" ;

    /**
     * 获取当前登录IP
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 获取当前时间的前一天时间
     * @param pattern 格式：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getBeforeDay(String pattern) {
        return getBeforeDay(pattern, -1) ;
    }

    public static String getBeforeDay(String pattern,int beforeDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, beforeDay); //得到前一天
        Date date = calendar.getTime();
        DateFormat df = new SimpleDateFormat(pattern);
        System.out.println(df.format(date));

        return df.format(date) ;
    }

    public static Date str2Date(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);

        try {
            return formatter.parse(dateStr) ;
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
        return null ;
    }

    public static double str2Double(String doubleStr) {
        if(doubleStr == null || doubleStr.equals("")) return 0d;
        return Double.parseDouble(doubleStr) ;
    }

    /**
     * 生成10~100之间的随机数
     * @return
     */
    public static int randomNum(long seed) {

        int max=10;
        int min=0;
        java.util.Random r=new java.util.Random(seed);

        return r.nextInt(max)%(max-min+1) + min ;
    }

    /**
     * excel2003扩展名
     */
    public static final String EXCEL03_EXTENSION = "xls";

    /**
     * excel2007扩展名
     */
    public static final String EXCEL07_EXTENSION = "xlsx";

    /**
     * zip扩展名
     */
    public static final String ZIP_EXTENSION = "zip";
}
