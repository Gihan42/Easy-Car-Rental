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
    double CarMonthlyprice;
    double CarDailyprice;
    boolean available;
    int CarpricePerKm;
    String CarTransmitionType;
    String CarFuelType;
    boolean general;
    boolean premium;
    boolean luxury;


}
