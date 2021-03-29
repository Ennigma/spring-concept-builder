package com.ennigma.policeman;

import com.ennigma.annotations.Lazy;
import com.ennigma.annotations.Primary;
import com.ennigma.annotations.Singleton;

/* eserbaniuc created on 02/25/2021 */
@Singleton
@Lazy
@Primary
public class Terminator implements Policeman {

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("Hasta la vista, baby");
    }
}
