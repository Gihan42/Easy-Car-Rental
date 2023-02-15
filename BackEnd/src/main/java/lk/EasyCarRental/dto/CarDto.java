package lk.EasyCarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDto {
    String vehicleNum;
    String Color;
    String CarMonthlyprice;
    String CarDailyprice;
    boolean available;
    int CarpricePerKm;
    String CarTransmitionType;
    String CarFuelType;
    boolean checkboxGeneral;
    boolean checkboxPremium;
    boolean checkboxLuxury;
}
