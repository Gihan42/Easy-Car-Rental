package lk.EasyCarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

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
    String carPasanger;
    String carFuelType;
    String vehicleType;
    double pricePerExtraKm;
    double lossDamageWaiver;
    MultipartFile img;
}
