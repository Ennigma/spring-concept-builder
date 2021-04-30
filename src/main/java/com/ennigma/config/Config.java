package com.ennigma.config;

import org.reflections.Reflections;

/* ennigma created on 02/19/2021 */
public interface Config {

    <T> Class<? extends T> getImplClass(Class<T> type);

    Reflections getScanner();
}
