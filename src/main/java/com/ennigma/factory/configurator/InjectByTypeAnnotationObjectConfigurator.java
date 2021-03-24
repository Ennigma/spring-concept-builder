package com.ennigma.factory.configurator;

import java.lang.reflect.Field;

import com.ennigma.annotations.InjectByType;
import com.ennigma.factory.ObjectFactory;

import lombok.SneakyThrows;

/* eserbaniuc created on 03/19/2021 */
public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator {

    @SneakyThrows
    @Override
    public void configure(Object t) {
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectByType.class)){
                field.setAccessible(true);
                Object object = ObjectFactory.getInstance().createObject(field.getType());
                field.set(t, object);
            }
        }
    }
}
