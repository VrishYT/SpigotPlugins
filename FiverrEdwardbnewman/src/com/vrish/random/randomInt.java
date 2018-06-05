package com.vrish.random;

import java.util.concurrent.ThreadLocalRandom;

public class randomInt {

    public static int randInt(int min, int max) {

        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;

    }
    
}
