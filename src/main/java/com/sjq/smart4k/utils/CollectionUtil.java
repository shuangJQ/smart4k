package com.sjq.smart4k.utils;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.collections4.trie.AbstractBitwiseTrie;

import java.util.Collection;
import java.util.Map;

/**
 * A Collection Util Class
 *
 * Created by sjq on 16/3/3.
 */
public final class CollectionUtil {
    /**
     * Null-safe check if the specified collection is empty.
     *
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection) {
        return CollectionUtils.isEmpty(collection);
    }

    /**
     *  Null-safe check if the specified collection is not empty.
     *
     * @param collection
     * @return
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     *  Null-safe check if the specified map is empty.
     *
     * @param map
     * @return
     */
    public static boolean isEmpty(Map<?,?> map) {
        return MapUtils.isEmpty(map);
    }

    /**
     *  Null-safe check if the specified map is not empty.
     *
     * @param map
     * @return
     */
    public static boolean isNotEmpty(Map<?,?> map) {
        return !isEmpty(map);
    }
}
