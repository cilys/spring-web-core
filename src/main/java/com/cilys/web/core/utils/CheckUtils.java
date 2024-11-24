package com.cilys.web.core.utils;

import com.cilys.web.core.exception.EmptyException;

import java.util.Collection;

/**
 * Created by Administrator on 2024/11/21.
 */
public class CheckUtils {

    public static void validNull(Object obj, String err) {
        if (obj == null) {
            throw new EmptyException(err);
        }
    }

    public static void validEmpty(Object obj, String err) {
        validNull(obj, err);
        if (obj instanceof String) {
            if ("".equals((String) obj)) {
                throw new EmptyException(err);
            }
        } else if (obj instanceof Collection) {
            if (((Collection) obj).isEmpty()) {
                throw new EmptyException(err);
            }
        }
    }
}
