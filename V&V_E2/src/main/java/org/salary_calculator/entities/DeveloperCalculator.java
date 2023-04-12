package main.java.org.salary_calculator.entities;

public class DeveloperCalculator implements Calculator {
    @Override
    public double calculateSalary(double salary) {
        return (salary >= 3000) ? 0.8 * salary : 0.9 * salary;
    }
}
