package com.lld.designproject.patterns.ProxyPattern;

public class Orchestrator {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoProxy();
        employeeDao.create("user", new Employee());
        employeeDao.create("ADMIN", new Employee());
    }
}
