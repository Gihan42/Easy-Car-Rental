package lk.EasyCarRental.service;

import lk.EasyCarRental.dto.AdminDto;
import lk.EasyCarRental.dto.CarDto;
import lk.EasyCarRental.dto.DriverDto;

import java.util.ArrayList;

public interface CarService {
    void saveCar(CarDto dto);
    CarDto findCarByvehicleNum(String vehicleNum);
    ArrayList<CarDto> getCars();
    void updateCar(CarDto dto);
    void deleteCar(String vehicleNum);
   long countCarAvailable();
    ArrayList<CarDto> indCarsByVehicleType(String Premium);
    ArrayList<CarDto> findCarsByGeneralType(String General);
    ArrayList<CarDto> findCarsByLuxuryType(String Luxury);
}
