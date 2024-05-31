package org.example;

import java.util.EnumMap;
import java.util.Map;

public enum Meat {
    Steak(new EnumMap<>(Map.of(
            SandwichSize.Four_Inch,1.00,
            SandwichSize.Eight_Inch,2.00,
            SandwichSize.Twelve_Inch,3.00))),
    Ham(new EnumMap<>(Map.of(
            SandwichSize.Four_Inch,1.00,
            SandwichSize.Eight_Inch,2.00,
            SandwichSize.Twelve_Inch,3.00))),
    Salami(new EnumMap<>(Map.of(
            SandwichSize.Four_Inch,1.00,
            SandwichSize.Eight_Inch,2.00,
            SandwichSize.Twelve_Inch,3.00))),
    RoastBeef(new EnumMap<>(Map.of(
            SandwichSize.Four_Inch,1.00,
            SandwichSize.Eight_Inch,2.00,
            SandwichSize.Twelve_Inch,3.00))),
    Chicken(new EnumMap<>(Map.of(
            SandwichSize.Four_Inch,1.00,
            SandwichSize.Eight_Inch,2.00,
            SandwichSize.Twelve_Inch,3.00))),
    Bacon(new EnumMap<>(Map.of(
            SandwichSize.Four_Inch,1.00,
            SandwichSize.Eight_Inch,2.00,
            SandwichSize.Twelve_Inch,3.00)));

    private final Map<SandwichSize, Double> prices;
    Meat(Map<SandwichSize,Double> prices){
        this.prices = prices;
    }
    public double getPrice(SandwichSize size){
        return prices.get(size);
    }
            //Ham,Salami,Roast_Beef,Chicken,Bacon;
}
