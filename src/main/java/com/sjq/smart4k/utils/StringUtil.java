package com.sjq.smart4k.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by sjq on 16/3/3.
 */
public final class StringUtil {
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
