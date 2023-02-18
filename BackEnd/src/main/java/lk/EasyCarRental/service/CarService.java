package lk.EasyCarRental.service;

import lk.EasyCarRental.dto.AdminDto;
import lk.EasyCarRental.dto.CarDto;
import lk.EasyCarRental.dto.DriverDto;

import java.util.ArrayList;

public interface CarService {
    void saveCar(CarDto dto);
    CarDto findCarByvehicleNum(String vehicleNum);
    ArrayList<CarDto> getCars();
}
