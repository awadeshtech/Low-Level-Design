package com.lld.designproject.patterns.DecoratorPattern;

public class Orchestrator {
    public static void main(String[] args) {
     BasePizza basePizza = new FarmHouse();
     BasePizza extraCheese = new ExtraCheeseDecorator(basePizza);
     BasePizza extraMushroom = new ExtraMushroomDecorator(extraCheese);
        System.out.println(extraMushroom.cost());

     // in one line
        BasePizza finalPizza = new ExtraMushroomDecorator(new ExtraCheeseDecorator(new FarmHouse()));
        System.out.println("in one line: " + finalPizza.cost());
    }
}
