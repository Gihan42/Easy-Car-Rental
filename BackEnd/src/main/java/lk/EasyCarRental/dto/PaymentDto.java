package lk.EasyCarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentDto {
    String accountNo;
    String beneficiaryName;
    String date;
    String paymentMethod;
    String deduction;
    String lossDamageViewer;
    String rent;
    String time;
}
