package lk.EasyCarRental.service;

import lk.EasyCarRental.dto.AdminDto;
import lk.EasyCarRental.dto.CarDto;
import lk.EasyCarRental.dto.CarNewDto;
import lk.EasyCarRental.dto.DriverDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public interface CarService {
    void saveCar(CarDto dto, MultipartFile img);
    CarDto findCarByvehicleNum(String vehicleNum);
    ArrayList<CarNewDto> getCars();
    void updateCar(CarDto dto);
    void deleteCar(String vehicleNum);
    long countAvailableCars(String Available);
    ArrayList<CarNewDto> indCarsByVehicleType(String Premium ,String Available);
    ArrayList<CarNewDto> findCarsByGeneralType(String General,String Available);
    ArrayList<CarNewDto>   findCarsByLuxuryType(String Luxury,String Available);
}
