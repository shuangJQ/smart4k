package com.sjq.smart4k.utils;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by sjq on 2016/3/4.
 */
public final class ArrayUtil {
    /**
     * Checks if an array of Objects is empty or null
     *
     * @param array
     * @return
     */
    public static boolean isEmpty(Object[] array) {
        return ArrayUtils.isEmpty(array);
    }

    /**
     * Checks if an array Objects is not empty or null
     *
     * @param array
     * @return
     */
    public static boolean isNotEmpty(Object[] array) {
        return !isEmpty(array);
    }
}
