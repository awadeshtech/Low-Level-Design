package com.lld.designproject.patterns.AdapterPattern.client;

import com.lld.designproject.patterns.AdapterPattern.Adaptee.BabyWeightMachineImpl;
import com.lld.designproject.patterns.AdapterPattern.Adaptee.WeightMachine;
import com.lld.designproject.patterns.AdapterPattern.Adapter.WeightMachineAdapter;
import com.lld.designproject.patterns.AdapterPattern.Adapter.WeightMachineAdapterImpl;

public class Orchestrator {
    public static void main(String[] args) {
        WeightMachine weightMachine = new BabyWeightMachineImpl();
        WeightMachineAdapter adapter = new WeightMachineAdapterImpl(weightMachine);
        System.out.println(adapter.getWeightInKg());
    }
}
