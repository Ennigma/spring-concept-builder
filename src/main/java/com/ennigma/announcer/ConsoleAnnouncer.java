package com.ennigma.announcer;

import com.ennigma.factory.ObjectFactory;

/* eserbaniuc created on 02/19/2021 */
public class ConsoleAnnouncer implements Announcer {
    private Advisor advisor = ObjectFactory.getInstance().createObject(Advisor.class);

    @Override
    public void announce(String message) {
        System.out.println("Announcer:" + message);
        advisor.advise();
    }
}
