package org.example.entities;

public class DBACalculator implements Calculator {
    @Override
    public double calculateSalary(double salary) {
        return (salary >= 2000) ? 0.75 * salary : 0.85 * salary;
    }
}
