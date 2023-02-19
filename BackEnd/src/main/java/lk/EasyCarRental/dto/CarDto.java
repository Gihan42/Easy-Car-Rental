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
    String vehicleModel;
    String Color;
    double carMonthlyprice;
    double carDailyprice;
    boolean available;
    int carpriceperkmaday;
    int carpricePerKmMonth;
    String carTransmitionType;
    String carFuelType;
    String vehicleType;
    double pricePerExtraKm;
}
