package lk.EasyCarRental.service.impl;

import lk.EasyCarRental.dto.AdminDto;
import lk.EasyCarRental.entity.Admin;
import lk.EasyCarRental.entity.Customer;
import lk.EasyCarRental.repo.AdminRepo;
import lk.EasyCarRental.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
