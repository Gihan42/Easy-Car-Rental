package lk.EasyCarRental.service.impl;

import lk.EasyCarRental.dto.CarDto;
import lk.EasyCarRental.dto.CustomerDto;
import lk.EasyCarRental.dto.DriverDto;
import lk.EasyCarRental.entity.Car;
import lk.EasyCarRental.entity.Customer;
import lk.EasyCarRental.entity.Driver;
import lk.EasyCarRental.repo.CarRepo;
import lk.EasyCarRental.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

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
        System.out.println(car);
    }

    @Override
    public CarDto findCarByvehicleNum(String vehicleNum) {
        if (repo.existsById(vehicleNum)){
            throw new RuntimeException("invalid id");
        }
        Car car=repo.findCarsByvehicleNum(vehicleNum);
        CarDto map=mapper.map(car,CarDto.class);
        System.out.println(map);
        return map;
    }

    @Override
    public ArrayList<CarDto> getCars() {
        return mapper.map(repo.findAll(),new TypeToken<ArrayList<CarDto>>(){}.getType());
    }

    @Override
    public void updateCar(CarDto dto) {
        if(!repo.existsById(dto.getVehicleNum())){
            throw new RuntimeException("car not exits");
        }
        repo.save(mapper.map(dto,Car.class));
    }

    @Override
    public void deleteCar(String vehicleNum) {
        if(!repo.existsById(vehicleNum)){
            throw new RuntimeException("invalid id");
        }
        repo.deleteById(vehicleNum);
    }

    @Override
    public long countCarAvailable(boolean available) {
       int l = (int) repo.countCarByavailable(available);
        System.out.println("count"+ l);
        return  l ;
    }

    @Override
    public ArrayList<CarDto> indCarsByVehicleType(String Premium) {
        ArrayList<Car> premium = repo.findCarsByVehicleType("Premium");
        for (Car car:premium) {
            System.out.println(car);
        }
        return mapper.map(repo.findCarsByVehicleType(Premium),new TypeToken<ArrayList<CarDto>>(){}.getType());

    }

    @Override
    public ArrayList<CarDto> findCarsByGeneralType(String General) {
        ArrayList<Car> general = repo.findCarsByVehicleType("General");
        for (Car car:general) {
            System.out.println(car);
        }
        return mapper.map(repo.findCarsByVehicleType(General),new TypeToken<ArrayList<CarDto>>(){}.getType());

    }

    @Override
    public ArrayList<CarDto> findCarsByLuxuryType(String Luxury) {
        ArrayList<Car> general = repo.findCarsByVehicleType("Luxury");
        for (Car car:general) {
            System.out.println(car);
        }
        return mapper.map(repo.findCarsByVehicleType(Luxury),new TypeToken<ArrayList<CarDto>>(){}.getType());
    }


}
