package com.ennigma.announcer;

import com.ennigma.annotations.InjectByType;

import lombok.extern.log4j.Log4j;

/* ennigma created on 02/19/2021 */
@Log4j
public class ConsoleAnnouncer implements Announcer {
    @InjectByType
    private Advisor advisor;

    @Override
    public void announce(String message) {
        log.info("ConsoleAnnouncer: " + message);
        advisor.advise();
    }
}
