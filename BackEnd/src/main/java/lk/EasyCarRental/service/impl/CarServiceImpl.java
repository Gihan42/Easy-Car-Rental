package lk.EasyCarRental.service.impl;

import lk.EasyCarRental.dto.CarDto;
import lk.EasyCarRental.dto.CarNewDto;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private CarRepo repo;

    @Override
    public void saveCar(CarDto dto, MultipartFile img) {

        if(repo.existsById(dto.getVehicleNum())){
            throw new RuntimeException("invalid vehicle num ");
        }

        String projectPath = "E:\\GDSE\\2 sem\\Internet Technology\\EasyCarRentalProject\\EasyCarRental\\FrontEnd\\assest\\car";

        try {
            byte[] fileBytes = img.getBytes();
            Path location = Paths.get(projectPath + "\\"+ dto.getVehicleNum() + ".jpeg");

            Files.write(location, fileBytes);

            img.transferTo(location);

//            driver.setLicenseImage("/image/bucket/driver/license_" + driver.getNic() + ".jpeg");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Car car=mapper.map(dto,Car.class);
        car.setImg("/"+ dto.getVehicleNum() + ".jpeg");
        repo.save(car);
        System.out.println(car);
    }

    @Override
    public CarDto findCarByvehicleNum(String vehicleNum) {
        if (!repo.existsById(vehicleNum)){
            throw new RuntimeException("invalid id");
        }
        Car car=repo.findCarByVehicleNum(vehicleNum);
        CarDto map=mapper.map(car,CarDto.class);
        System.out.println(map);
        return map;
    }

    @Override
    public ArrayList<CarNewDto> getCars() {
        return mapper.map(repo.findAll(),new TypeToken<ArrayList<CarNewDto>>(){}.getType());
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
    public long countCarAvailable() {
       int l = (int) repo.countCarsByAvailable();
        System.out.println("count"+ l);
        return  l ;
    }

    @Override
    public ArrayList<CarNewDto> indCarsByVehicleType(String Premium) {
        ArrayList<Car> premium = repo.findCarsByVehicleType("Premium");
        for (Car car:premium) {
            System.out.println(car);
        }
        return mapper.map(repo.findCarsByVehicleType(Premium),new TypeToken<ArrayList<CarNewDto>>(){}.getType());

    }

    @Override
    public ArrayList<CarNewDto> findCarsByGeneralType(String General) {
        ArrayList<Car> general = repo.findCarsByVehicleType("General");
        for (Car car:general) {
            System.out.println(car);
        }
        return mapper.map(repo.findCarsByVehicleType(General),new TypeToken<ArrayList<CarNewDto>>(){}.getType());

    }

    @Override
    public ArrayList<CarNewDto> findCarsByLuxuryType(String Luxury) {
        ArrayList<Car> general = repo.findCarsByVehicleType("Luxury");
        for (Car car:general) {
            System.out.println(car);
        }
        return mapper.map(repo.findCarsByVehicleType(Luxury),new TypeToken<ArrayList<CarNewDto>>(){}.getType());
    }


}
