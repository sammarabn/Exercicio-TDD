package test.java.functionalTests.salary_calculator;

import org.example.entities.Employee;
import org.example.enums.Office;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DBACalculatorTest {

    Employee e1;
    Employee e2;
    Employee e3;
    Employee e4;
    Employee e5;

    @BeforeEach
    public void setup(){
        e1 = new Employee("John Chicago", "jonhch@gmail.com", 2000.0, Office.DBA);
        e2 = new Employee("Dayvid Killer", "dayv1@gmail.com", 3000.0, Office.DBA);
        e3 = new Employee("Jack Travolta", "jackzin@gmail.com", 1000.0, Office.DBA);
        e4 = new Employee("Jack Travolta", "jackzin@gmail.com",  2001.0, Office.DBA);
        e5 = new Employee("Jack Travolta", "jackzin@gmail.com", 1999.0, Office.DBA);
    }

    @Test
    void lessThan2000() {
        double salary = this.e3.getSalary();
        assertEquals(salary, 850.0);
    }

    @Test
    void moreThan2000() {
        double salary = this.e2.getSalary();
        assertEquals(salary, 2250.0);
    }

    @Test
    void equalTo2000() {
        double salary = this.e1.getSalary();
        assertEquals(salary, 1500.0);
    }

    @Test
    void equalTo1999() {
        double salary = this.e5.getSalary();
        assertEquals(salary, 1699.1499999999999);
    }

    @Test
    void equalTo2001() {
        double salary = this.e4.getSalary();
        assertEquals(salary, 1500.75);
    }

}
