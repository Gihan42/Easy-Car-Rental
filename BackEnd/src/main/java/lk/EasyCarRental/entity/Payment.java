package lk.EasyCarRental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Payment {
    @Id
    String accountNo;
    String beneficiaryName;
    String date;
    String paymentMethod;
    String deduction;
    String lossDamageViewer;
    String rent;
    String time;
}
