package com.sjq.smart4k;

import com.sjq.smart4k.helper.BeanHelper;
import com.sjq.smart4k.helper.ClassHelper;
import com.sjq.smart4k.helper.ControllerHelper;
import com.sjq.smart4k.helper.IocHelper;
import com.sjq.smart4k.utils.ClassUtil;

/**
 * Load helper
 * <p>
 * Created by sjq on 16/3/5.
 */
public final class HelperLoader {
    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(), true);
        }
    }
}
