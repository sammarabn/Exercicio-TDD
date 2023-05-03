package test.java.functionalTests.invoice_generator;

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
        invoiceConsulting = new Invoice("Solucoes Softwares", genericAddress, ServiceType.CONSULTING, 100.0);
        invoiceTraining = new Invoice("Dev Training", genericAddress, ServiceType.TRAINING, 100.0);
        invoiceOther = new Invoice("Sammara Nunes", genericAddress, ServiceType.OTHER,100.0);
    }

    // TIPO CONSULTORIA
    @Test
    void consultingTaxTestWith100() {
        assertEquals(this.invoiceConsulting.getAmount(), 125);
    }

    @Test
    void consultingTaxTestWith1500() {
        invoiceConsulting.setValue(1500.0);
        assertEquals(this.invoiceConsulting.getAmount(), 1875);
    }

    @Test
    void consultingTaxTestWith0() {
        invoiceConsulting.setValue(0.0);
        assertEquals(this.invoiceConsulting.getAmount(), 0);
    }

    // TIPO TREINAMENTO
    @Test
    void trainingTaxTestWith100() {
        assertEquals(this.invoiceTraining.getAmount(), 115);
    }

    @Test
    void trainingTaxTestWith1500() {
        invoiceTraining.setValue(1500.0);
        assertEquals(this.invoiceTraining.getAmount(), 1725);
    }

    @Test
    void trainingTaxTestWith0() {
        invoiceTraining.setValue(0.0);
        assertEquals(this.invoiceTraining.getAmount(), 0);
    }

    //TIPO OUTRO
    @Test
    void otherTaxTestWith100() {
        assertEquals(this.invoiceOther.getAmount(), 106);
    }

    @Test
    void otherTaxTestWith1500() {
        invoiceOther.setValue(1500.0);
        assertEquals(this.invoiceOther.getAmount(), 1590);
    }

    @Test
    void otherTaxTestWith0() {
        invoiceOther.setValue(0.0);
        assertEquals(this.invoiceOther.getAmount(), 0);
    }
}
