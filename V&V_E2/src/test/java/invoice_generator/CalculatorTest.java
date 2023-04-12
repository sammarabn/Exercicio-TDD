package test.java.invoice_generator;

import main.java.org.invoice_generator.enums.ServiceType;
import main.java.org.invoice_generator.model.Address;
import main.java.org.invoice_generator.model.Invoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Invoice invoiceConsulting;
    Invoice invoiceTraining;
    Invoice invoiceOther;

    @BeforeEach
    public void setup(){
        Address genericAddress = new Address("Rua dos cabelos", "1380", "De frente ao estadio",
                "Bairro das Flores", "Campina grande", "58426985", "Paraiba",
                "Brasil");
        invoiceConsulting = new Invoice("Solucoes Softwares", genericAddress, ServiceType.CONSULTING, 10000.0);
        invoiceTraining = new Invoice("Dev Training", genericAddress, ServiceType.TRAINING, 5000.0);
        invoiceOther = new Invoice("Sammara Nunes", genericAddress, ServiceType.OTHER,1000.0);
    }

    @Test
    void consultingTaxTest() {
        assertEquals(this.invoiceConsulting.getAmount(), 12500.0);
    }

    @Test
    void trainingTaxTest() {
        assertEquals(this.invoiceTraining.getAmount(), 5750.0);
    }

    @Test
    void otherTaxTest() {
        assertEquals(this.invoiceOther.getAmount(), 1060.0);
    }
}
