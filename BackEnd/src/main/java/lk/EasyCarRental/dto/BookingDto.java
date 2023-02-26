package lk.EasyCarRental.dto;

import lk.EasyCarRental.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Lob;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BookingDto {
    private String bookingID;
    private String currentDate;
    private String dueDate;
    private BigDecimal advancePayment;
    @Lob
    private byte[] paymentConfirmation;
    private BigDecimal total;
    private Car car;
    private DriverDto driver;
    /*private AdminDTO admin;*/
    private CustomerDto customer;
}
