package com.ennigma.announcer;

import javax.annotation.PostConstruct;

import com.ennigma.annotations.InjectProperty;
import com.ennigma.annotations.Singleton;

import lombok.extern.log4j.Log4j;

/* ennigma created on 02/26/2021 */
@Singleton
@Log4j
@Deprecated
public class DrinkAdvisor implements Advisor {

    @InjectProperty()
    private String alcohol;

    public DrinkAdvisor(){
        log.info("Advisor was created");
    }

    @PostConstruct
    public void init(){
        log.info("PostConstruct concept: INIT method invoked in class: " + getClass());
    }

    @Override
    public void advise() {
        log.info("DrinkAdvisor: For your protection we recommend drinking: " + alcohol);
    }
}
