package com.sjq.smart4k.helper;

import com.sjq.smart4k.annotation.Action;
import com.sjq.smart4k.bean.Handler;
import com.sjq.smart4k.bean.Request;
import com.sjq.smart4k.utils.ArrayUtil;
import com.sjq.smart4k.utils.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Controller Helper
 *
 * Created by sjq on 2016/3/4.
 */
public final class ControllerHelper {
    /**
     * Define the mapping relation between Request and Handler
     */
    private static final Map<Request, Handler> ACTINO_MAP = new HashMap<Request, Handler>();

    static {
        // Get all Controller Class
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtil.isNotEmpty(controllerClassSet)) {
            for (Class<?> controllerClass : controllerClassSet) {
                // Get methods in controllerClass
                Method[] methods = controllerClass.getDeclaredMethods();
                if (ArrayUtil.isNotEmpty(methods)) {
                    for (Method method : methods) {
                        // Check is the method has Action annotation
                        if (method.isAnnotationPresent(Action.class)) {
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();
                            // Validate URL mapping rule
                            if (mapping.matches("\\w+:/\\w*")) {
                                String[] array = mapping.split(":");
                                if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
                                    // Get request method and request path
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod, requestPath);
                                    Handler handler = new Handler(controllerClass, method);
                                    // Initialize Action Map
                                    ACTINO_MAP.put(request, handler);
                                }

                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Get Handler
     */
    public static Handler getHandler(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return ACTINO_MAP.get(request);
    }
}
