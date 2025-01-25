package com.lld.designproject.patterns.ProxyPattern;

public interface EmployeeDao {
    public void create(String client, Employee employeeDao);

    public void delete(String client, String employeeId);

    public Employee get(String client, String employeeId);
}
