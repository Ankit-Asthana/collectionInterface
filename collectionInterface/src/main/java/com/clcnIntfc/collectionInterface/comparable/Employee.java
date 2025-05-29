package com.clcnIntfc.collectionInterface.comparable;

import lombok.Data;

@Data
class Employee implements Comparable<Employee> {

    private String name;
    private int id;
    private String address;

    public Employee(String name, int id, String address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", address='" + address + '\'' +
                '}';
    }

    /*
        employee1.id.compareTo(empleyee2.id)
        4.compareTo(3);
     */
    @Override
    public int compareTo(Employee o) {
        return o.getId() - this.getId(); //returns negative, so it will be descending order sorting of Employees (Id basis)
                                            //here, o.getId is 4 and this.getId is 3
    }
}
