package com.factory;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.config.Config;
import com.config.JavaConfig;
import com.factory.configurator.ObjectConfigurator;
import com.policeman.Policeman;
import com.policeman.Robocop;

import lombok.SneakyThrows;

/* eserbaniuc created on 02/19/2021 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private List<ObjectConfigurator> configurators = new ArrayList<>();
    private Config config;

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private ObjectFactory() {
        config = new JavaConfig("com", new HashMap<>(Map.of(Policeman.class, Robocop.class)));
        for (Class<? extends ObjectConfigurator> aclass : config.getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            if (Modifier.isAbstract(aclass.getModifiers())){
                return;
            }
            configurators.add(aclass.getDeclaredConstructor().newInstance());
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> implClass = type;
        if (type.isInterface()){
            implClass = config.getImplClass(type);
        }

        T t = implClass.getDeclaredConstructor().newInstance();

        configurators.forEach(configuration -> configuration.configure(t));
        return t;
    }
}
