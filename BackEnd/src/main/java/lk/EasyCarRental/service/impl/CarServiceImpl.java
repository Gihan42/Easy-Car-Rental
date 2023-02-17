package lk.EasyCarRental.service.impl;

import lk.EasyCarRental.dto.CarDto;
import lk.EasyCarRental.entity.Car;
import lk.EasyCarRental.repo.CarRepo;
import lk.EasyCarRental.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private CarRepo repo;

    @Override
    public void saveCar(CarDto dto) {
        if(repo.existsById(dto.getVehicleNum())){
            throw new RuntimeException("invalid vehicle num ");
        }
        Car car=mapper.map(dto,Car.class);
        repo.save(car);

    }
}
