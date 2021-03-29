package com.ennigma;

import com.ennigma.application.Application;
import com.ennigma.application.ApplicationContext;
import com.ennigma.application.CoronaDisinfector;
import com.ennigma.application.Room;

/* eserbaniuc created on 02/19/2021 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = Application.run(Main.class.getPackageName());
        CoronaDisinfector disinfector = context.getObject(CoronaDisinfector.class);
        disinfector.start(new Room());
    }
}
