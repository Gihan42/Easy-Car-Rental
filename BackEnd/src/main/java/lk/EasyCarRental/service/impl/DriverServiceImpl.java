package lk.EasyCarRental.service.impl;

import lk.EasyCarRental.dto.CustomerDto;
import lk.EasyCarRental.dto.DriverDto;
import lk.EasyCarRental.entity.Driver;
import lk.EasyCarRental.repo.DriverRepo;
import lk.EasyCarRental.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

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

    @Override
    public DriverDto findDriverBydriverID(String driverID) {
        if (!repo.existsById(driverID)){
            throw new RuntimeException("invalid driver id");
        }
        Driver driver=repo.findDriverBydriverID(driverID);
        DriverDto dto=mapper.map(driver,DriverDto.class);
        return dto;
    }

    @Override
    public ArrayList<DriverDto> getDriver() {
        return mapper.map(repo.findAll(),new TypeToken<ArrayList<DriverDto>>(){}.getType());
    }

    @Override
    public void deleteDriver(String driverID) {
        if(!repo.existsById(driverID)){
            throw new RuntimeException("invalid id");
        }
        repo.deleteById(driverID);
    }

    @Override
    public void updateDriver(DriverDto dto) {
        if (!repo.existsById(dto.getDriverID())){
            throw new RuntimeException("Driver not exits ");
        }
        repo.save(mapper.map(dto,Driver.class));
    }

    @Override
    public DriverDto findDriver(String Available) {
        if (!repo.existsById(Available)){
            throw new RuntimeException("invalid driver id");
        }
        Driver driver=repo.findDriverByAvailable(Available);
        DriverDto dto=mapper.map(driver,DriverDto.class);
        return dto;
    }

    @Override
    public long countAvailableDriver(String Available) {
        long r=repo.countDriverByAvailable("Available");
        System.out.println("available"+r);
        return r;
    }
}
