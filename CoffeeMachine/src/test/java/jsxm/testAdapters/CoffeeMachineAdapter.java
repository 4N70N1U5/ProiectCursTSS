package jsxm.testAdapters;

import org.jsxm.CoffeeMachine;

/**
 * @author www.jsxm.org
 *
 */
public class CoffeeMachineAdapter {
    private CoffeeMachine coffeeMachine = new CoffeeMachine();

    public String powerOn() {
        try {
            coffeeMachine.powerOn();
        } catch (Exception e) {
            return e.getMessage();
        }

        return "powerOnOut_true_Coffee Machine powered ON";
    }

    public String powerOff() {
        try {
            coffeeMachine.powerOff();
        } catch (Exception e) {
            return e.getMessage();
        }

        return "powerOffOut_false_Coffee Machine powered OFF";
    }

    public String setPrice(int espressoPrice, int cappuccinoPrice) {
        try {
            coffeeMachine.setPrice(espressoPrice, cappuccinoPrice);
        } catch (Exception e) {
            return e.getMessage();
        }

        return "setPriceOut_" + espressoPrice + "_" + cappuccinoPrice+"_Prices set: Espresso - " + espressoPrice + ", Cappuccino - " + cappuccinoPrice;
    }

    public String addCredit(int amount) {
        try {
            coffeeMachine.addCredit(amount);
        } catch (Exception e) {
            return e.getMessage();
        }

        return "addCreditOut_" + coffeeMachine.getCredit()+"_Credit added: " + amount + ". Total credit: " + coffeeMachine.getCredit();
    }
    public String buyCoffee(String coffeeType) {
        try {
            coffeeMachine.buyCoffee(coffeeType);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "buyCoffeeOut_" + coffeeType + "_" + coffeeMachine.getCredit()+"_Coffee dispensed: " + coffeeType + ". Remaining credit: " + coffeeMachine.getCredit();
    }
}