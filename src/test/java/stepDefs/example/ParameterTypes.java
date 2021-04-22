package stepDefs.example;

import dto.DeliveryAddressInformation;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class ParameterTypes {
    @DataTableType
    public DeliveryAddressInformation authorEntry(Map<String, String> entry) {
        return new DeliveryAddressInformation (
                entry.get("Full name"),
                entry.get("Delivery country"),
                entry.get("Address line 1"),
                entry.get("Address line 2"),
                entry.get("Town/City"),
                entry.get("County/State"),
                entry.get("Postcode")
        );
    }

}
