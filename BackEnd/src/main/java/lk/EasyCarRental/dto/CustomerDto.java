package lk.EasyCarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomerDto {
    String nic;
    String name;
    String address;
    String password;
    int contactNum;
    String licence;
//    MultipartFile nicImage;
}
