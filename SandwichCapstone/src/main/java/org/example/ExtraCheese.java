package org.example;

import java.util.EnumMap;
import java.util.Map;

public enum ExtraCheese {
    //cheeses american,provolone,cheddar,swiss
    Extra_American(new EnumMap<>(Map.of(
            SandwichSize.Four_Inch,.30,
            SandwichSize.Eight_Inch,.60,
            SandwichSize.Twelve_Inch,.90))),
    Extra_Provolone(new EnumMap<>(Map.of(
            SandwichSize.Four_Inch,.30,
            SandwichSize.Eight_Inch,.60,
            SandwichSize.Twelve_Inch,.90))),
    Extra_Cheddar(new EnumMap<>(Map.of(
            SandwichSize.Four_Inch,.30,
            SandwichSize.Eight_Inch,.60,
            SandwichSize.Twelve_Inch,.90))),
    Extra_Swiss(new EnumMap<>(Map.of(
            SandwichSize.Four_Inch,.30,
            SandwichSize.Eight_Inch,.60,
            SandwichSize.Twelve_Inch,.90)));

    private final Map<SandwichSize, Double> prices;
    ExtraCheese(Map<SandwichSize,Double> prices){
        this.prices = prices;
    }
    public double getPrice(SandwichSize size){
        return prices.get(size);
    }

    }
