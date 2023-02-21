package lk.EasyCarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdminDto {
    String emailaddress;
    String password;
    String name;

    public AdminDto(String emailaddress, String password) {
        this.emailaddress = emailaddress;
        this.password = password;
    }
}

