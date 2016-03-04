package com.sjq.smart4k.bean;

import java.lang.reflect.Method;

/**
 * Encapsulation information of Action
 *
 * Created by sjq on 2016/3/4.
 */
public class Handler {

    /**
     * Class of Controller
     */
    private Class<?> controllerClass;

    /**
     * Method of Action
     */
    private Method actionMethod;

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
