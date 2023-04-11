import org.example.entities.Employee;
import org.example.enums.Office;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeveloperCalculatorTest {
    Employee e1;
    Employee e2;
    Employee e3;

    @BeforeEach
    public void setup(){
        e1 = new Employee("John Chicago", "jonhch@gmail.com", 4000.0, Office.DEVELOPER);
        e2 = new Employee("Dayvid Killer", "dayv1@gmail.com", 3000.0, Office.DEVELOPER);
        e3 = new Employee("Jack Travolta", "jackzin@gmail.com", 1000.0, Office.DEVELOPER);
    }

    @Test
    void lessThan3000() {
        double salary = this.e3.getSalary();
        assertEquals(salary, 900.0);
    }

    @Test
    void moreThan3000() {
        double salary = this.e1.getSalary();
        assertEquals(salary, 3200.0);
    }

    @Test
    void equalTo3000() {
        double salary = this.e2.getSalary();
        assertEquals(salary, 2400.0);
    }
}
