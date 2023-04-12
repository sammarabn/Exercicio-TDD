package main.java.org.invoice_generator.model;

import main.java.org.invoice_generator.utils.CalculateTax;

public class TrainingCalculator implements CalculateTax {
    @Override
    public double calculateTax(double value) {
        return value + (value * 0.15);
    }
}
