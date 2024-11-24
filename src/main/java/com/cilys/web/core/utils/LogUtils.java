package com.cilys.web.core.utils;

import org.slf4j.Logger;

/**
 * Created by Administrator on 2024/11/21.
 */
public class LogUtils {

    public static void debug(Logger logger, String msg, Object...params) {
        debug(logger, msg, null, params);
    }

    public static void debug(Logger logger, String msg, Throwable e, Object...params) {
        logger.info(msg, params, e);
    }

}
