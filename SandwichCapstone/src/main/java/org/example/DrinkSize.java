package org.example;

import java.util.EnumMap;
import java.util.Map;
//drink sizes small, medium, large

public enum DrinkSize {
    Small(2.00),
    Medium(2.50),
    Large(3.00);
    private final double basePrice;

    DrinkSize(double basePrice){
        this.basePrice = basePrice;
    }
    public double getBasePrice(){
        return basePrice;

    }


}
