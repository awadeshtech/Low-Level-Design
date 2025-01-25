package com.lld.designproject.patterns.Factory;

public class Orchestrator {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape("CIRCLE");
        shape.draw();

    }
}
