package com.ennigma.config;

/* ennigma created on 04/09/2021 */
public interface ProxyConfigurator {

    Object replaceWithProxyIfRequired(Object object,  Class implClass);

}
