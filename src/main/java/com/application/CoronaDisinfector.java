package com.application;

import com.announcer.Announcer;
import com.factory.ObjectFactory;
import com.policeman.Policeman;

/* eserbaniuc created on 02/19/2021 */
public class CoronaDisinfector {

    private Announcer announcer = ObjectFactory.getInstance().createObject(Announcer.class);
    private Policeman policeman = ObjectFactory.getInstance().createObject(Policeman.class);

    public void start(Room room){
        System.out.println("=================Start=========================");

        announcer.announce("Disinfection starts soon, please leave the room");
        policeman.makePeopleLeaveRoom();
        disinfectRoom(room);
        announcer.announce("Disinfection successfully completed. You are now allow to enter the room!");

        System.out.println("=================End=========================");
    }

    private void disinfectRoom(Room room) {
        System.out.println("Disinfection successfully completed!");
    }
}
