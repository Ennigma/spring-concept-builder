package com.ennigma.policeman;

import javax.annotation.PostConstruct;

import com.ennigma.annotations.InjectByType;
import com.ennigma.annotations.Primary;
import com.ennigma.annotations.Singleton;
import com.ennigma.announcer.Advisor;

import lombok.extern.log4j.Log4j;

/* ennigma created on 02/19/2021 */
@Singleton
@Primary
@Log4j
public class Robocop implements Hero {

    @InjectByType
    private Advisor advisor;

    @PostConstruct
    public void init(){
        log.info("PostConstruct concept: INIT method invoked in class: " + getClass());
    }

    @Override
    public void makePeopleLeaveRoom() {
        log.info("Robocop: Pif Paf!!! Leave the room like NOW!!!");
    }
}
