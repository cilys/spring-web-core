package com.cilys.web.core.utils;

import java.util.UUID;

/**
 * Created by Administrator on 2024/11/22.
 */
public class UUIDUtils {
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }
}
