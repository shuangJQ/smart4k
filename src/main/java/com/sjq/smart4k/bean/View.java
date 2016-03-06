package com.sjq.smart4k.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Return model object
 * <p>
 * Created by sjq on 16/3/6.
 */
public class View {
    /**
     * View path
     */
    private String path;

    /**
     * Model data
     */
    private Map<String, Object> model;

    public View(String path) {
        this.path = path;
        model = new HashMap<String, Object>();
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
