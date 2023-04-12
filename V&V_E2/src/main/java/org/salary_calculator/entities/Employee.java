package main.java.org.salary_calculator.entities;


import main.java.org.salary_calculator.enums.Office;

public class Employee {

    private String nome;
    private String email;
    private double baseSalary;
    private Office office;
    private Calculator calculator;

    public Employee(String nome, String email, double baseSalary, Office office) {
        this.nome = nome;
        this.email = email;
        this.baseSalary = baseSalary;
        this.office = office;
        this.calculator = this.defineCalculator(office);
    }

    private Calculator defineCalculator(Office office) {
        if (this.office.equals(Office.DBA)){
            return new DBACalculator();
        } else if (this.office.equals(Office.DEVELOPER)) {
            return new DeveloperCalculator();
        } else if (this.office.equals(Office.MANAGER)) {
            return new ManagerCalculator();
        } else {
            return new TesterCalculator();
        }
    }

    public double getSalary() {
        return this.calculator.calculateSalary(this.baseSalary);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
