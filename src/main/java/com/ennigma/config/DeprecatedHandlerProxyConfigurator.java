package com.ennigma.config;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import lombok.extern.log4j.Log4j;
import net.sf.cglib.proxy.Enhancer;

/* ennigma created on 04/19/2021 */
@Log4j
public class DeprecatedHandlerProxyConfigurator implements ProxyConfigurator {

    @Override
    public Object replaceWithProxyIfRequired(Object t, Class implClass) {
        if (implClass.isAnnotationPresent(Deprecated.class)) {
            if (implClass.getInterfaces().length == 0){
                return Enhancer.create(implClass, (net.sf.cglib.proxy.InvocationHandler) (proxy, method, args) -> invokeProxyMethod(t, implClass, method, args));
            }
            return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), (proxy, method, args) -> invokeProxyMethod(t, implClass, method, args));
        }
        else {
            return t;
        }
    }

    private Object invokeProxyMethod(Object t, Class implClass, Method method, Object[] args)
            throws IllegalAccessException, InvocationTargetException {
        log.warn("***ACHTUNG!!! " + implClass.getSimpleName() + "#" + method.getName().toUpperCase() + " is DEPRICATED");
        return method.invoke(t, args);
    }
}
