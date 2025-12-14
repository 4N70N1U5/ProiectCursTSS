package org.jsxm;

public class CoffeeMachine {
    // Memory variables
    private boolean isPoweredOn = false;
    private int espressoPrice = 0;
    private int cappuccinoPrice = 0;
    private int credit = 0;

    // Constructor
    public CoffeeMachine() {
    }

    // Power On function
    public void powerOn() {
        if (isPoweredOn) {
            throw new RuntimeException("powerOnAlreadyOnError");
        }
        isPoweredOn = true;
    }

    // Power Off function
    public void powerOff() {
        if (!isPoweredOn) {
            throw new RuntimeException("powerOffAlreadyOffError");
        }
        isPoweredOn = false;
    }

    // Set Price function
    public void setPrice(int espressoPrice, int cappuccinoPrice) {
        if (!isPoweredOn) {
            throw new RuntimeException("setPricePoweredOffError");
        }
        
        if (espressoPrice <= 0 || cappuccinoPrice <= 0) {
            throw new RuntimeException("setPriceInvalidValueError");
        }
        
        this.espressoPrice = espressoPrice;
        this.cappuccinoPrice = cappuccinoPrice;
    }

    // Add Credit function
    public void addCredit(int amount) {
        if (!isPoweredOn) {
            throw new RuntimeException("addCreditPoweredOffError");
        }
        
        if (espressoPrice == 0 || cappuccinoPrice == 0) {
            throw new RuntimeException("addCreditPriceNotSetError");
        }
        
        if (amount != 1 && amount != 5 && amount != 10 && amount != 20) {
            throw new RuntimeException("addCreditInvalidValueError");
        }
        
        credit += amount;
    }

    // Buy Coffee function
    public void buyCoffee(String coffeeType) {
        if (!isPoweredOn) {
            throw new RuntimeException("buyCoffeePoweredOffError");
        }
        
        if (espressoPrice == 0 || cappuccinoPrice == 0) {
            throw new RuntimeException("buyCoffeePriceNotSetError");
        }
        
        if (!coffeeType.equals("espresso") && !coffeeType.equals("cappuccino")) {
            throw new RuntimeException("buyCoffeeInvalidTypeError");
        }
        
        int coffeePrice = coffeeType.equals("espresso") ? espressoPrice : cappuccinoPrice;
        if (credit < coffeePrice) {
            throw new RuntimeException("buyCoffeeInsufficientCreditError");
        }
        
        credit -= coffeePrice;
    }

    // Getters
    public boolean isPoweredOn() {
        return isPoweredOn;
    }

    public int getEspressoPrice() {
        return espressoPrice;
    }

    public int getCappuccinoPrice() {
        return cappuccinoPrice;
    }

    public int getCredit() {
        return credit;
    }

    // Display method for memory state
    public String display() {
        return "Machine is " + (isPoweredOn ? "ON" : "OFF") + 
               ", Espresso Price: " + espressoPrice + 
               ", Cappuccino Price: " + cappuccinoPrice + 
               ", Credit: " + credit;
    }
}
