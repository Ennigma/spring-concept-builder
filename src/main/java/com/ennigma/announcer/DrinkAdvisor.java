package com.ennigma.announcer;

import com.ennigma.annotations.InjectProperty;
import com.ennigma.annotations.Singleton;

/* eserbaniuc created on 02/26/2021 */
@Singleton
public class DrinkAdvisor implements Advisor {

    @InjectProperty()
    private String alcohol;

    @Override
    public void advise() {
        System.out.println("For your protection we recommend drinking: " + alcohol);
    }
}
