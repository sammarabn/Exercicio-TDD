package model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Address {
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String zipCode;
    private String federateState;
    private String country;
}
