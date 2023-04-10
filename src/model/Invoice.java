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
    private Double amount;
}
