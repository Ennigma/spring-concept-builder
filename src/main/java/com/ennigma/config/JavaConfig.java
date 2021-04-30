package com.ennigma.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.reflections.Reflections;

import com.ennigma.annotations.Primary;
import com.ennigma.annotations.Singleton;

import lombok.Getter;

/* ennigma created on 02/19/2021 */
public class JavaConfig implements Config {

    @Getter
    private Reflections scanner;
    private Map<Class, Class> ifc2ImplClass = new HashMap<>();

    public JavaConfig(String packageToScan) {
        scanner = new Reflections(packageToScan);
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {
        return ifc2ImplClass.computeIfAbsent(ifc, aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
            if (classes.isEmpty()) {
                throw new RuntimeException(ifc + " has 0 implementations, please update your config");
            }
            else if (classes.size() == 1) {
                return classes.iterator().next();
            }
            else {
                return getPrimaryClassImplementation(ifc, classes);
            }

        });
    }

    private <T> Class getPrimaryClassImplementation(Class<T> ifc, Set<Class<? extends T>> classes) {
        List<Class<? extends T>> impls = classes.stream()
                .filter(implClass -> implClass.isAnnotationPresent(Primary.class))
                .collect(Collectors.toList());

        if (impls.size() != 1) {
            throw new RuntimeException(ifc + " has multiple Primary implementations, please check your configuration");
        }
        else {
            return impls.iterator().next();
        }
    }

    public Set<Class<?>> getAllSingletons(){
        return scanner.getTypesAnnotatedWith(Singleton.class);
    }
}
