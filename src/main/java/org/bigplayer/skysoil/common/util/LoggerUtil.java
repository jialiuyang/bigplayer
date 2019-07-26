/**
 * shenmajr.com Inc.
 * Copyright (c) 2015-2015 All Rights Reserved.
 */
package org.bigplayer.skysoil.common.util;

import org.slf4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 打印日志工具类
 * @author Louis Lau
 * @version $Id: LoggerUtil.java, v 0.1 2015年7月16日 下午6:23:15 Louis Lau Exp $
 */
public final class LoggerUtil {

    /** 线程编号修饰符 */
    private static final char THREAD_RIGHT_TAG = ']';

    /** 线程编号修饰符 */
    private static final char THREAD_LEFT_TAG  = '[';

    /** 换行符 */
    public static final char  ENTERSTR         = '\n';

    /** 逗号 */
    public static final char  COMMA            = ',';

    /**
     * 生成<font color="blue">调试</font>级别日志<br>
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     * 
     * @param logger
     * @param obj
     */
    public static void debug(Logger logger, Object... obj) {
        if (logger.isDebugEnabled()) {
            logger.debug(getLogString(obj));
        }
    }

    /**
     * 生成<font color="blue">通知</font>级别日志<br>
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     * 
     * @param logger
     * @param obj
     */
    public static void info(Logger logger, Object... obj) {
        if (logger.isInfoEnabled()) {
            logger.info(getLogString(obj));
        }
    }

    /**
     * 生成<font color="brown">警告</font>级别日志<br>
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     * 
     * @param logger
     * @param obj
     */
    public static void warn(Logger logger, Object... obj) {
        if (logger.isWarnEnabled()) {
            logger.warn(getLogString(obj));
        }
    }

    /**
     * 生成<font color="brown">警告</font>级别日志<br>
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     * 
     * @param logger
     * @param obj
     */
    public static void warn(Logger logger, Throwable t, Object... obj) {
        if (logger.isWarnEnabled()) {
            logger.warn(getLogString(obj), t);
        }
    }

    /**
     * 生成<font color="brown">系统异常</font>级别日志<br>
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     * 
     * @param logger
     * @param obj
     */
    public static void error(Logger logger, Object... obj) {
        if (logger.isErrorEnabled()) {
            logger.error(getLogString(obj));
        }
    }

    /**
     * 生成<font color="brown">系统异常</font>级别日志<br>
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     * 
     * @param logger
     * @param t
     * @param obj
     */
    public static void error(Logger logger, Throwable t, Object... obj) {
        if (logger.isErrorEnabled()) {
            logger.error(getLogString(obj), t);
        }
    }

    /**
     * 生成输出到日志的字符串
     * 
     * @param obj 任意个要输出到日志的参数
     * @return
     */
    public static String getLogString(Object... obj) {
        StringBuilder log = new StringBuilder();
        log.append(THREAD_LEFT_TAG).append(Thread.currentThread().getId()).append(THREAD_RIGHT_TAG);
        log.append(" ");
        for (Object o : obj) {
            log.append(o);
        }
        return log.toString();
    }


    /**
     * 获取堆栈信息
     *
     * @param e
     * @return
     */
    @SuppressWarnings("unused")
    public static String getTrace(Exception e) {
        Throwable t = e.getCause();
        if (null == t) {
            t = e;
        }
        if (null != t) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter writer = new PrintWriter(stringWriter);
            t.printStackTrace(writer);
            StringBuffer buffer = stringWriter.getBuffer();
            return buffer.toString();
        }
        return null;
    }

    public static String getTrace(Throwable e) {
        if (null != e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter writer = new PrintWriter(stringWriter);
            e.printStackTrace(writer);
            StringBuffer buffer = stringWriter.getBuffer();
            return buffer.toString();
        }
        return null;
    }
}
