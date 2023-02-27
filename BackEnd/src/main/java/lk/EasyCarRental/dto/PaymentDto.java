package lk.EasyCarRental.dto;

import lk.EasyCarRental.entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentDto {
    private String bookingID;
    private Booking booking;
    private BigDecimal rent;
    private String account;
    private String paymentMethod;
    private BigDecimal deduction;
}

