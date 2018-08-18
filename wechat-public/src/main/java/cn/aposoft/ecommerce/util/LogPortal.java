package cn.aposoft.ecommerce.util;

import ch.qos.logback.classic.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * slf4j日志,配合logback.xml进行使用
 * @author yuijnshui
 * @Title: LogPortal
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/7/27上午10:10
 */
public class LogPortal {


    private static Logger logger = LoggerFactory.getLogger(LogPortal.class);

    public static void debug(String msg, Object... objs){

        logger.debug(appendClassName2Msg(msg), objs);
    }

    public static void info(String msg, Object... objs){

        logger.info(appendClassName2Msg(msg), objs);
    }

    private static String appendClassName2Msg(String msg) {
        StackTraceElement[] strackArr = Thread.currentThread().getStackTrace();

        StackTraceElement lastStrack = strackArr[strackArr.length - 1];

        return lastStrack.getClassName() + "." + lastStrack.getMethodName() + " - " + msg;
    }

    public static void error(String msg, Object... objs){
        logger.error(appendClassName2Msg(msg), objs);
    }

    public static void error(String msg, Throwable t){
        logger.error(appendClassName2Msg(msg),t);
    }

    public static void setLogModule(String logModule){
        MDC.put("logModule", logModule);
    }

    public static void setLogLevel(LogLevel logLevel){
        ((ch.qos.logback.classic.Logger)logger).setLevel(logLevel.getLevel());
    }

    public static enum LogLevel{
        ALL(Level.ALL),

        DEBUG(Level.DEBUG),

        INFO(Level.INFO),

        ERROR(Level.ERROR);

        private Level level;

        private LogLevel(Level level){
            this.level = level;
        }

        public Level getLevel(){
            return this.level;
        }
    }
}


