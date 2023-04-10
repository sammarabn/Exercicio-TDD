package model;

import enums.ServiceType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Invoice {
    private String name;
    private Address address;
    private ServiceType serviceType;
    private Double value;
    private Double amount;

    public void calculateAmount(){
        if(this.serviceType.equals(ServiceType.CONSULTORIA)){
            this.amount = this.value + (this.value * 0.25);
        }else if(this.serviceType.equals(ServiceType.TREINAMENTO)){
            this.amount = this.value + (this.value * 0.15);
        }else{
            this.amount = this.value + (this.value * 0.06);
        }
    }
}
