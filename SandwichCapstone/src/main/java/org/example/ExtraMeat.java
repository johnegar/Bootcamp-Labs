package org.example;

import java.util.EnumMap;
import java.util.Map;

public enum ExtraMeat {
    Extra_Steak(new EnumMap<>(Map.of(
            SandwichSize.Four_Inch,1.00,
            SandwichSize.Eight_Inch,2.00,
            SandwichSize.Twelve_Inch,3.00))),
    Extra_Ham(new EnumMap<>(Map.of(
            SandwichSize.Four_Inch,1.00,
            SandwichSize.Eight_Inch,2.00,
            SandwichSize.Twelve_Inch,3.00))),
    Extra_RoastBeef(new EnumMap<>(Map.of(
            SandwichSize.Four_Inch,1.00,
            SandwichSize.Eight_Inch,2.00,
            SandwichSize.Twelve_Inch,3.00))),
    Extra_Chicken(new EnumMap<>(Map.of(
            SandwichSize.Four_Inch,1.00,
            SandwichSize.Eight_Inch,2.00,
            SandwichSize.Twelve_Inch,3.00))),
    Extra_Bacon(new EnumMap<>(Map.of(
            SandwichSize.Four_Inch,1.00,
            SandwichSize.Eight_Inch,2.00,
            SandwichSize.Twelve_Inch,3.00)));

    private final Map<SandwichSize, Double> prices;
    ExtraMeat(Map<SandwichSize,Double> prices){
        this.prices = prices;
    }
    public double getPrice(SandwichSize size){
        return prices.get(size);
    }
    //Extra_Ham,Extra_Salami,Extra_Roast_Beef,Extra_Chicken,Extra_Bacon;
}
