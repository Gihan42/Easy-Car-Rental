package lk.EasyCarRental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Payment {
    @Id
    @Column(name = "booking_id")
    private String bookingID;
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "booking_id",referencedColumnName="bookingID")
    private Booking booking;

    private BigDecimal rent;
    private String account;
    private String paymentMethod;
    private BigDecimal deduction;
}
