package lk.EasyCarRental.service;

import lk.EasyCarRental.dto.AdminDto;
import lk.EasyCarRental.dto.CustomerDto;

import java.util.ArrayList;

public interface AdminService {

    void AdminSave(AdminDto dto);
     AdminDto findAdminByemail(String emailaddres);


}
