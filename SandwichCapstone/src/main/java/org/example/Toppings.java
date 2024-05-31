package org.example;

public enum Toppings {
    Lettuce(0),
    Peppers(0),
    Onions(0),
    Tomatoes(0),
    Jalapenos(0),
    Cucumbers(0),
    Pickles(0),
    Guacamole(0),
    Mushrooms(0);
    private final double basePrice;

    Toppings(double basePrice){
        this.basePrice = basePrice;
    }
    public double getBasePrice(){
        return basePrice;

    }
}
