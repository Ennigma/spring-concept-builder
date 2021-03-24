package com.ennigma.application;

import java.util.Map;

import com.ennigma.config.JavaConfig;
import com.ennigma.factory.ObjectFactory;

/* eserbaniuc created on 03/24/2021 */
public class Application {

    public static ApplicationContext run(String packageToScan, Map<Class, Class> ifc2ImplClass){
        JavaConfig config = new JavaConfig(packageToScan, ifc2ImplClass);
        ApplicationContext context = new ApplicationContext(config);
        ObjectFactory objectFactory = new ObjectFactory(context);
        //ToDo homework - init all singletons which are not lazy
        context.setFactory(objectFactory);

        return context;
    }

}
