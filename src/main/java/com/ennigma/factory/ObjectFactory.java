package com.ennigma.factory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.ennigma.application.ApplicationContext;
import com.ennigma.config.Config;
import com.ennigma.factory.configurator.ObjectConfigurator;

import lombok.SneakyThrows;

/* eserbaniuc created on 02/19/2021 */
public class ObjectFactory {
    private final ApplicationContext context;
    private List<ObjectConfigurator> configurators = new ArrayList<>();

    @SneakyThrows
    public ObjectFactory(ApplicationContext context) {
        this.context = context;
        Config config = context.getConfig();
        for (Class<? extends ObjectConfigurator> aclass : config.getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            if (Modifier.isAbstract(aclass.getModifiers())){
                return;
            }
            configurators.add(aclass.getDeclaredConstructor().newInstance());
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> implClass) {
        T t = create(implClass);
        configure(t);

        invokeInit(implClass, t);
        return t;
    }

    private <T> void invokeInit(Class<T> implClass, T t) throws IllegalAccessException, InvocationTargetException {
        for (Method method : implClass.getMethods()) {
            if (method.isAnnotationPresent(PostConstruct.class)){
                method.invoke(t);
            }
        }
    }

    private <T> void configure(T t) {
        configurators.forEach(configuration -> configuration.configure(context, t));
    }

    private <T> T create(Class<T> implClass)
            throws InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException, NoSuchMethodException {
        return implClass.getDeclaredConstructor().newInstance();
    }
}
