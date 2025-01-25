package com.lld.designproject.patterns.DecoratorPattern;

public class ExtraMushroomDecorator extends ToppingDecorator{
    BasePizza basePizza;

    public ExtraMushroomDecorator(BasePizza basePizza){
        this.basePizza = basePizza;
    }
    @Override
    public int cost() {
        return basePizza.cost()+50;
    }
}
