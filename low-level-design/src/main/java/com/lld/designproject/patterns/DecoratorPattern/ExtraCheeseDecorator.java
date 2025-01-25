package com.lld.designproject.patterns.DecoratorPattern;

public class ExtraCheeseDecorator extends ToppingDecorator {
    BasePizza basePizza;

    public ExtraCheeseDecorator(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return basePizza.cost() + 10;
    }
}
