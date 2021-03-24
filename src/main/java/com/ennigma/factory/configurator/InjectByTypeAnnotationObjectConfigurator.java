package com.ennigma.factory.configurator;

import java.lang.reflect.Field;

import com.ennigma.annotations.InjectByType;
import com.ennigma.application.ApplicationContext;

import lombok.SneakyThrows;

/* eserbaniuc created on 03/19/2021 */
public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator {

    @SneakyThrows
    @Override
    public void configure(ApplicationContext context, Object t) {
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectByType.class)){
                field.setAccessible(true);
                Object object = context.getObject(field.getType());
                field.set(t, object);
            }
        }
    }
}
