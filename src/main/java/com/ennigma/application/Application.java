package com.ennigma.application;

import java.lang.reflect.Modifier;

import com.ennigma.annotations.Lazy;
import com.ennigma.config.JavaConfig;
import com.ennigma.factory.ObjectFactory;

/* eserbaniuc created on 03/24/2021 */
public class Application {

    public static ApplicationContext run(String packageToScan){
        JavaConfig config = new JavaConfig(packageToScan);
        ApplicationContext context = new ApplicationContext(config);
        ObjectFactory factory = new ObjectFactory(context);
        context.setFactory(factory);

        initializeNotLazySingletons(config, context);

        return context;
    }

    private static void initializeNotLazySingletons(JavaConfig config, ApplicationContext context) {
        config.getAllSingletons().stream()
                .filter(aClass -> !Modifier.isInterface(aClass.getModifiers()))
                .filter(aClass -> !aClass.isAnnotationPresent(Lazy.class))
                .forEach(context::getObject);
    }

}
