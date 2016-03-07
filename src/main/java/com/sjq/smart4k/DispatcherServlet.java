package com.sjq.smart4k;

import com.sjq.smart4k.bean.Handler;
import com.sjq.smart4k.helper.ConfigHelper;
import com.sjq.smart4k.helper.ControllerHelper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
            // TODO:
        }

    }
}

