package lk.EasyCarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverDto {
    String driverID;
    String drivername;
    String driveraddress;
    String driverContact;
    String password;
    String available;
    private String date;

}
