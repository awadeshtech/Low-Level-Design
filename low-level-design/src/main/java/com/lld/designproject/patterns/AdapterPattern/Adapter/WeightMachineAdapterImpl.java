package com.lld.designproject.patterns.AdapterPattern.Adapter;

import com.lld.designproject.patterns.AdapterPattern.Adaptee.WeightMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdapter {
    WeightMachine weightMachine;

    public WeightMachineAdapterImpl(WeightMachine weightMachine) {
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKg() {
        return weightMachine.getWeight() * .45;
    }
}
