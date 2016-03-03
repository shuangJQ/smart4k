package com.sjq.smart4k.helper;

import com.sjq.smart4k.ConfigConstant;
import com.sjq.smart4k.utils.PropsUtil;

import java.util.Properties;


/**
 * 配置文件帮助类
 * <p>
 * Created by sjq on 16/3/2.
 */
public final class ConfigHelper {
    private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    public static String getJdbcDriver() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
    }

    public static String getJdbcUrl() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
    }

    public static String getUserName() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
    }

    public static String getJdbcPassword() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
    }

    public static String getProjectBasePackage() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.PROJECT_BASE_PACKAGE);
    }

    public static String getProjectJspPath() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.PROJECT_JSP_PATH, "/WEB_INF/jsp/");
    }

    public static String getProjectAssetPath() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.PROJECT_ASSET_PATH, "/resources/");
    }
}
