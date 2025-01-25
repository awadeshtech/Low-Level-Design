package com.lld.designproject.patterns.ProxyPattern;

public class EmployeeDaoProxy implements EmployeeDao{
    EmployeeDao employeeDao;

    public EmployeeDaoProxy(){
        employeeDao = new EmployeeDaoImpl();
    }
    @Override
    public void create(String client, Employee employeeDao) {
        if(client.equals("ADMIN")){
            System.out.println("created");
        }else{
            System.out.println("not allowed");
        }
    }

    @Override
    public void delete(String client, String employeeId) {

    }

    @Override
    public Employee get(String client, String employeeId) {
        return null;
    }
}
