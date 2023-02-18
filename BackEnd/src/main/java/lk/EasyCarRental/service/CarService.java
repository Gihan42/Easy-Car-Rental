package lk.EasyCarRental.service;

import lk.EasyCarRental.dto.AdminDto;
import lk.EasyCarRental.dto.CarDto;

public interface CarService {
    void saveCar(CarDto dto);
    CarDto findCarByvehicleNum(String vehicleNum);
}
