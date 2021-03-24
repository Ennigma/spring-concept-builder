package com.ennigma.announcer;

import com.ennigma.annotations.InjectProperty;

/* eserbaniuc created on 02/26/2021 */
public class DrinkAdvisor implements Advisor {

    @InjectProperty()
    private String alcohol;

    @Override
    public void advise() {
        System.out.println("For your protection we recommend drinking: " + alcohol);
    }
}
