package com.sjq.smart4k;

import com.sjq.smart4k.bean.Data;
import com.sjq.smart4k.bean.Handler;
import com.sjq.smart4k.bean.Param;
import com.sjq.smart4k.bean.View;
import com.sjq.smart4k.helper.BeanHelper;
import com.sjq.smart4k.helper.ConfigHelper;
import com.sjq.smart4k.helper.ControllerHelper;
import com.sjq.smart4k.utils.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * The dispatcher servlet
 *
 * Created by sjq on 2016/3/7.
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        // Initialize helpers
        HelperLoader.init();
        // Get ServletContext object(use for register Servlet)
        ServletContext servletContext = config.getServletContext();
        // Register Servlet to handle JSP
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getProjectJspPath() + "*");
        // Register default Servlet to handle static resources
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getProjectAssetPath() + "*");
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get request path and method
        String requestMethod = req.getMethod().toLowerCase();
        String requestPath = req.getPathInfo();
        // Get Action handler
        Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
        if (handler != null) {
            // Get Controller and it's bean instance
            Class<?> controllerClass = handler.getControllerClass();
            Object controllerBean = BeanHelper.getBean(controllerClass);
            // Create request param
            Map<String, Object> paramMap = new HashMap<String, Object>();
            Enumeration<String> paramNames = req.getParameterNames();
            while (paramNames.hasMoreElements()) {
                String paramName = paramNames.nextElement();
                String paramValue = req.getParameter(paramName);
                paramMap.put(paramName, paramValue);
            }
            String body = CodeUtil.decodeURL(StreamUtil.getString(req.getInputStream()));
            if (StringUtil.isNotEmpty(body)) {
                String[] params = StringUtil.splitString(body, "&");
                if (ArrayUtil.isNotEmpty(params)) {
                    for (String param : params) {
                        String[] array = StringUtil.splitString(param, "=");
                        if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
                            String paramName = array[0];
                            String paramValue = array[1];
                            paramMap.put(paramName, paramValue);
                        }
                    }
                }
            }
            Param param = new Param(paramMap);
            // Invoke Action method
            Method actionMethod = handler.getActionMethod();
            Object result = ReflectionUtil.invokeMethod(controllerBean, actionMethod, param);
            // Deal with return value
            if (result instanceof View) {
                View view = (View) result;
                String path = view.getPath();
                if (StringUtil.isNotEmpty(path)) {
                    if (path.startsWith("/")) {
                        resp.sendRedirect(req.getContextPath() + path);
                    } else {
                        Map<String, Object> model = view.getModel();
                        for (Map.Entry<String, Object> entry : model.entrySet()) {
                            req.setAttribute(entry.getKey(), entry.getValue());
                        }
                        req.getRequestDispatcher(ConfigHelper.getProjectJspPath() + path).forward(req, resp);
                    }
                }
            } else if (result instanceof Data) {
                Data data = (Data) result;
                Object model = data.getModel();
                if (model != null) {
                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");
                    PrintWriter writer = resp.getWriter();
                    String json = JsonUtil.toJson(model);
                    writer.write(json);
                    writer.flush();
                    writer.close();
                }
            }
        }

    }
}

