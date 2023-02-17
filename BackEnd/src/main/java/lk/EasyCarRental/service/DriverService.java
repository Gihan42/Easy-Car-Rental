package lk.EasyCarRental.service;

import lk.EasyCarRental.dto.CustomerDto;
import lk.EasyCarRental.dto.DriverDto;

import java.util.ArrayList;

public interface DriverService {
    void saveDriver(DriverDto dto);
    DriverDto findDriverBydriverID(String driverID);
    ArrayList<DriverDto> getDriver();
    void deleteDriver(String driverID);
    void updateDriver(DriverDto dto);
}
