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
