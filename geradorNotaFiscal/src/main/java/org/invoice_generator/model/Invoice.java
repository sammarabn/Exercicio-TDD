package main.java.org.invoice_generator.model;

import main.java.org.invoice_generator.enums.ServiceType;
import lombok.Getter;
import lombok.Setter;
import main.java.org.invoice_generator.utils.CalculateTax;

@Setter
@Getter
public class Invoice {
    private String name;
    private Address address;
    private ServiceType serviceType;
    private Double value;
    private CalculateTax calculateTax;

    public Invoice(String name, Address address, ServiceType serviceType, Double value) {
        this.name = name;
        this.address = address;
        this.serviceType = serviceType;
        this.value = value;
        this.calculateTax = this.defineCalculator();
    }

    private CalculateTax defineCalculator() {
        if (this.serviceType.equals(ServiceType.CONSULTING)){
            return new ConsultingCalculator();
        } else if (this.serviceType.equals(ServiceType.TRAINING)) {
            return new TrainingCalculator();
        } else {
            return new OtherCalculator();
        }
    }

    public double getAmount() {
        return this.calculateTax.calculateTax(this.value);
    }
}
