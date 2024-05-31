package org.example;

enum Sauce {
    MAYO(0),
    MUSTARD(0),
    KETCHUP(0),
    THOUSAND_ISLANDS(0),
    VINAIGRETTE(0);

    private final double basePrice;

    Sauce(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getBasePrice() {
        return basePrice;
    }
}

