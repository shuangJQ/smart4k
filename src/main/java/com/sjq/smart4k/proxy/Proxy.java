package com.sjq.smart4k.proxy;

/**
 * Proxy interface
 * <p>
 * Created by sjq on 16/3/9.
 */
public interface Proxy {
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
