package main.java.org.salary_calculator.entities;

public class TesterCalculator implements Calculator {
    @Override
    public double calculateSalary(double salary) {
        return (salary >= 2000) ? 0.75 * salary : 0.85 * salary;
    }
}
