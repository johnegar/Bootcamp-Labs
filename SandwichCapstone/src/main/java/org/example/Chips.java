package org.example;

import java.util.EnumMap;
import java.util.Map;

public enum Chips {
    //types of chips, doritos, lays, kettleCooked
    doritos(1.50),
    lays(1.50),
    kettle(1.50);

    private final double basePrice;

    Chips(double basePrice){
        this.basePrice = basePrice;
    }
    public double getBasePrice(){
        return basePrice;

    }
            
}
