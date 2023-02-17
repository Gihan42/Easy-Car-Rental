package lk.EasyCarRental.service.impl;

import lk.EasyCarRental.dto.DriverDto;
import lk.EasyCarRental.entity.Driver;
import lk.EasyCarRental.repo.DriverRepo;
import lk.EasyCarRental.service.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepo repo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveDriver(DriverDto dto) {
        if (repo.existsById(dto.getDriverID())){
            throw new RuntimeException("invalid driver id");
        }
        Driver driver=mapper.map(dto,Driver.class);
        repo.save(driver);
    }
}
