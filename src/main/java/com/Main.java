package com;

import com.application.CoronaDisinfector;
import com.application.Room;
import com.factory.ObjectFactory;

/* eserbaniuc created on 02/19/2021 */
public class Main {

    public static void main(String[] args) {
        CoronaDisinfector disinfector = ObjectFactory.getInstance().createObject(CoronaDisinfector.class);
        disinfector.start(new Room());
    }
}
