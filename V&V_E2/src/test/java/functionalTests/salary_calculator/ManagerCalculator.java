package test.java.functionalTests.salary_calculator;

import org.example.entities.Employee;
import org.example.enums.Office;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagerCalculator {
    Employee e1;
    Employee e2;
    Employee e3;
    Employee e4;
    Employee e5;

    @BeforeEach
    public void setup(){
        e1 = new Employee("John Chicago", "jonhch@gmail.com", 2000.0, Office.MANAGER);
        e2 = new Employee("Dayvid Killer", "dayv1@gmail.com", 5000.0, Office.MANAGER);
        e3 = new Employee("Jack Travolta", "jackzin@gmail.com", 7000.0, Office.MANAGER);
        e4 = new Employee("Jack Travolta", "jackzin@gmail.com", 4999.0, Office.MANAGER);
        e5 = new Employee("Jack Travolta", "jackzin@gmail.com", 5001.0, Office.MANAGER);
    }

    @Test
    void lessThan5000() {
        double salary = this.e1.getSalary();
        assertEquals(salary, 1600.0);
    }

    @Test
    void moreThan5000() {
        double salary = this.e3.getSalary();
        assertEquals(salary, 4900.0);
    }

    @Test
    void equalTo5000() {
        double salary = this.e2.getSalary();
        assertEquals(salary, 3500.0);
    }

    @Test
    void equalTo4999() {
        double salary = this.e4.getSalary();
        assertEquals(salary, 3999.2000000000003);
    }

    @Test
    void equalTo5001() {
        double salary = this.e5.getSalary();
        assertEquals(salary, 3500.70);
    }
}

