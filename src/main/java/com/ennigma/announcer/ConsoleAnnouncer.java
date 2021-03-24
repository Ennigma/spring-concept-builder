package com.ennigma.announcer;

import com.ennigma.annotations.InjectByType;

/* eserbaniuc created on 02/19/2021 */
public class ConsoleAnnouncer implements Announcer {
    @InjectByType
    private Advisor advisor;

    @Override
    public void announce(String message) {
        System.out.println("Announcer:" + message);
        advisor.advise();
    }
}
