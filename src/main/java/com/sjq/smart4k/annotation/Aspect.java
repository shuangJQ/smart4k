package com.sjq.smart4k.annotation;

import java.lang.annotation.*;

/**
 * AOP annotation
 * <p>
 * Created by sjq on 16/3/9.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    Class<? extends Annotation> value();
}
