package com.sjq.smart4k.helper;

import com.sjq.smart4k.annotation.Inject;
import com.sjq.smart4k.utils.ArrayUtil;
import com.sjq.smart4k.utils.CollectionUtil;
import com.sjq.smart4k.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * A Inversion of Control Class
 *
 * Created by sjq on 2016/3/4.
 */
public final class IocHelper {
    static {
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            for (Map.Entry<Class<?>,Object> beanEntry : beanMap.entrySet()) {
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();

                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(beanFields)) {
                    for (Field beandField : beanFields) {
                        if (beandField.isAnnotationPresent(Inject.class)) {
                            Class<?> beanFieldClass = beandField.getType();
                            Object beadnFiedInstance = beanMap.get(beanFieldClass);
                            if (beadnFiedInstance != null) {
                                // Initialize the value of Beanfield
                                ReflectionUtil.setField(beanInstance, beandField, beadnFiedInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
