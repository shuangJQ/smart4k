package com.sjq.smart4k.helper;

import com.sjq.smart4k.ConfigConstant;
import com.sjq.smart4k.utils.PropsUtils;

import java.util.Properties;


/**
 * 配置文件帮助类
 * <p>
 * Created by sjq on 16/3/2.
 */
public final class ConfigHelper {
    private static final Properties CONFIG_PROPS = PropsUtils.loadProps(ConfigConstant.CONFIG_FILE);

    public static String getJdbcDriver() {
        return PropsUtils.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
    }

    public static String getJdbcUrl() {
        return PropsUtils.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
    }

    public static String getUserName() {
        return PropsUtils.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
    }

    public static String getJdbcPassword() {
        return PropsUtils.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
    }

    public static String getProjectBasePackage() {
        return PropsUtils.getString(CONFIG_PROPS, ConfigConstant.PROJECT_BASE_PACKAGE);
    }

    public static String getProjectJspPath() {
        return PropsUtils.getString(CONFIG_PROPS, ConfigConstant.PROJECT_JSP_PATH, "/WEB_INF/jsp/");
    }

    public static String getProjectAssetPath() {
        return PropsUtils.getString(CONFIG_PROPS, ConfigConstant.PROJECT_ASSET_PATH, "/resources/");
    }
}
