package org.example;

import java.util.EnumMap;
import java.util.Map;
//drink types pepsi, coke, sprite, rootBeer

public enum Drinks {
    pepsi(new EnumMap<>(Map.of(
            DrinkSize.Small,2.00,
            DrinkSize.Medium,2.50,
            DrinkSize.Large,3.00))),
    coke(new EnumMap<>(Map.of(
            DrinkSize.Small,2.00,
            DrinkSize.Medium,2.50,
            DrinkSize.Large,3.00))),
    sprite(new EnumMap<>(Map.of(
            DrinkSize.Small,2.00,
            DrinkSize.Medium,2.50,
            DrinkSize.Large,3.00))),
    rootBeer(new EnumMap<>(Map.of(
            DrinkSize.Small,2.00,
            DrinkSize.Medium,2.50,
            DrinkSize.Large,3.00)));

    private final Map<DrinkSize, Double> prices;
    Drinks(Map<DrinkSize,Double> prices){
        this.prices = prices;
    }
    public double getPrice(DrinkSize drinkSize){
        return prices.get(drinkSize);
    }

    public Map<DrinkSize, Double> getPrices() {
        return prices;
    }

}
