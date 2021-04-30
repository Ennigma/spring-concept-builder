package com.ennigma.application;

import com.ennigma.annotations.InjectByType;
import com.ennigma.announcer.Announcer;
import com.ennigma.policeman.Hero;

import lombok.extern.log4j.Log4j;

/* ennigma created on 02/19/2021 */
@Log4j
@Deprecated
public class CoronaDisinfector {

    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Hero hero;

    public void start(){
        log.info("=================Start=========================");

        announcer.announce("Disinfection starts soon, please leave the room");
        hero.makePeopleLeaveRoom();
        disinfectRoom();
        announcer.announce("Disinfection successfully completed. You are now allow to enter the room!");

        log.info("=================End=========================");
    }

    private void disinfectRoom() {
        log.info("Disinfection successfully completed!");
    }
}
