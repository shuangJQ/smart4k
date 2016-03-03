package com.sjq.smart4k.helper;

import com.sjq.smart4k.annotation.Controller;
import com.sjq.smart4k.annotation.Service;
import com.sjq.smart4k.utils.ClassUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * The Class Helper
 * <p>
 * Created by sjq on 16/3/3.
 */
public final class ClassHelper {
    /**
     * Define the Class Set
     */
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getProjectBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /**
     * Get all classes under the project path
     */
    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    /**
     * Get all Service class under the project path
     */
    public static Set<Class<?>> getServiceClassSet() {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : classSet) {
            if (cls.isAnnotationPresent(Service.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * Get all Controller class under the project path
     */
    public static Set<Class<?>> getControllerClassSet() {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : classSet) {
            if (cls.isAnnotationPresent(Controller.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * Get all beans(include Service and Controller...) under the project path
     */
    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> beadnClassSet = new HashSet<Class<?>>();
        beadnClassSet.addAll(getServiceClassSet());
        beadnClassSet.addAll(getControllerClassSet());
        return beadnClassSet;
    }

}
