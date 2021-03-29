package com.ennigma.policeman;

import javax.annotation.PostConstruct;

import com.ennigma.annotations.InjectByType;
import com.ennigma.annotations.Singleton;
import com.ennigma.announcer.DrinkAdvisor;

/* eserbaniuc created on 02/19/2021 */
@Singleton
public class Robocop implements Policeman {

    @InjectByType
    private DrinkAdvisor advisor;

    @PostConstruct
    public void init(){
        System.out.println("PostConstruct concept: " + advisor.getClass());
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("Robocop: Pif Paf!!! Leave the room like NOW!!!");
    }
}
