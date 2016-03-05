package com.sjq.smart4k.bean;

import com.sjq.smart4k.utils.CastUtil;

import java.util.Map;

/**
 * Request param object
 * <p>
 * Created by sjq on 16/3/5.
 */
public class Param {
    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    /**
     * Get value of long type
     *
     * @param name
     * @return
     */
    public long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }

    /**
     * Get all field value
     *
     * @return
     */
    public Map<String, Object> getMap() {
        return paramMap;
    }
}
