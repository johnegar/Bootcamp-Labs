package org.example;

import java.util.EnumMap;
import java.util.Map;
//cheeses american,provolone,cheddar,swiss
public enum Cheese {
    American(new EnumMap<>(Map.of(
            SandwichSize.Four_Inch,.75,
            SandwichSize.Eight_Inch,1.50,
            SandwichSize.Twelve_Inch,2.25))),
    Provolone(new EnumMap<>(Map.of(
            SandwichSize.Four_Inch,1.00,
            SandwichSize.Eight_Inch,2.00,
            SandwichSize.Twelve_Inch,3.00))),
    Cheddar(new EnumMap<>(Map.of(
            SandwichSize.Four_Inch,1.00,
            SandwichSize.Eight_Inch,2.00,
            SandwichSize.Twelve_Inch,3.00))),
    Swiss(new EnumMap<>(Map.of(
            SandwichSize.Four_Inch,1.00,
            SandwichSize.Eight_Inch,2.00,
            SandwichSize.Twelve_Inch,3.00)));

    private final Map<SandwichSize, Double> prices;
    Cheese(Map<SandwichSize, Double> prices){
        this.prices = prices;
    }
    public double getPrice(SandwichSize size){
        return prices.get(size);
    }
}
