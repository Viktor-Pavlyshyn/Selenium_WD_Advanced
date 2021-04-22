package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeliveryAddressInformation {
    private String fullName;
    private String deliveryCountry;
    private String addressLineOne;
    private String addressLineTwo;
    private String townCity;
    private String countyState;
    private String postcode;
}
