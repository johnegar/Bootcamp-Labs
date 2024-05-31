package org.example;

public enum SandwichSize {
    Four_Inch(5.50),
    Eight_Inch(7.00),
    Twelve_Inch(8.50);
    private final double basePrice;

    SandwichSize(double basePrice){
        this.basePrice = basePrice;

    }
    public double getBasePrice(){
        return basePrice;
    }
}
