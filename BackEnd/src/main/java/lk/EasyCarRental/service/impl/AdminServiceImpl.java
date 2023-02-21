package lk.EasyCarRental.service.impl;

import lk.EasyCarRental.dto.AdminDto;
import lk.EasyCarRental.dto.CarDto;
import lk.EasyCarRental.dto.CustomerDto;
import lk.EasyCarRental.entity.Admin;
import lk.EasyCarRental.entity.Customer;
import lk.EasyCarRental.repo.AdminRepo;
import lk.EasyCarRental.service.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Transactional
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo repo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public void AdminSave(AdminDto dto) {
        if (repo.existsById(dto.getEmailaddress())){
            throw new RuntimeException();
        }
        Admin admin=mapper.map(dto, Admin.class);
        repo.save(admin);
    }

    @Override
    public AdminDto findAdminByemail(String emailaddres) {
        if(!repo.existsById(emailaddres)){
            throw new RuntimeException("Invalid Id");
        }
        Admin admin=repo.findAdminByEmailaddress(emailaddres);
        AdminDto map=mapper.map(admin,AdminDto.class);
        System.out.println(admin);
        return map;
    }
}
