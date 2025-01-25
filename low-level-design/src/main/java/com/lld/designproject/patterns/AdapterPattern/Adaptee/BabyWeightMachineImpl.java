package com.lld.designproject.patterns.AdapterPattern.Adaptee;

public class BabyWeightMachineImpl implements WeightMachine{
    @Override
    public double getWeight() {
        return 45;
    }
}
