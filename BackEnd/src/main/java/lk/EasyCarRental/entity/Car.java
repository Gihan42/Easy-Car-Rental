package lk.EasyCarRental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Car {
    @Id
    String vehicleNum;
    String vehicleModel;
    String Color;
    double carMonthlyprice;
    double carDailyprice;
    boolean available;
    int carpriceperkmaday;
    int carpricePerKmMonth;
    String carPasanger;
    String carFuelType;
    String vehicleType;
    double pricePerExtraKm;
    double lossDamageWaiver;


}
