package com.ennigma;

import java.util.HashMap;
import java.util.Map;

import com.ennigma.application.Application;
import com.ennigma.application.ApplicationContext;
import com.ennigma.application.CoronaDisinfector;
import com.ennigma.application.Room;
import com.ennigma.policeman.Policeman;
import com.ennigma.policeman.Robocop;

/* eserbaniuc created on 02/19/2021 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = Application.run("com.ennigma", new HashMap<>(Map.of(Policeman.class, Robocop.class)));
        CoronaDisinfector disinfector = context.getObject(CoronaDisinfector.class);
        disinfector.start(new Room());
    }
}
