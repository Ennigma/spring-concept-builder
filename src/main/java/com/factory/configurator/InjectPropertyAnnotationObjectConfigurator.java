package com.factory.configurator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.stream.Collectors;

import com.annotations.InjectProperty;

import lombok.SneakyThrows;

/* eserbaniuc created on 03/08/2021 */
public class InjectPropertyAnnotationObjectConfigurator implements ObjectConfigurator {

    private final Map<String, String> propertiesMap;

    @SneakyThrows
    //used via reflection
    public InjectPropertyAnnotationObjectConfigurator() {
        String path = ClassLoader.getSystemClassLoader().getResource("application.properties").toURI().getPath();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        propertiesMap = bufferedReader.lines()
                .map(line -> line.split("="))
                .collect(Collectors.toMap(array -> array[0], array -> array[1]));
        bufferedReader.close();
    }

    @SneakyThrows
    @Override
    public void configure(Object t) {
        Class<?> implClass = t.getClass();
        for (Field field : implClass.getDeclaredFields()) {
            InjectProperty annotation = field.getAnnotation(InjectProperty.class);
            if (annotation != null){
                String value = annotation.value().isEmpty() ? propertiesMap.get(field.getName()) : propertiesMap.get(annotation.value());
                field.setAccessible(true);
                field.set(t, value);
            }
        }
    }
}
