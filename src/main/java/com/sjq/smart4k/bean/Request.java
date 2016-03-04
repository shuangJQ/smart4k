package com.sjq.smart4k.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Encapsulation information of request
 *
 * Created by user on 2016/3/4.
 */
public class Request {

    /**
     * The request method
     */
    private String requestMethod;

    /**
     * The request path
     */
    private String requestPath;

    public Request(String requestMethod, String requestPath) {
        this.requestMethod =  requestMethod;
        this.requestPath = requestPath;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }
}
