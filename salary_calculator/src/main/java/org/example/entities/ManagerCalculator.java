package org.example.entities;

public class ManagerCalculator implements Calculator {
    @Override
    public double calculateSalary(double salary) {
        return (salary >= 5000) ? 0.7 * salary : 0.8 * salary;
    }
}
