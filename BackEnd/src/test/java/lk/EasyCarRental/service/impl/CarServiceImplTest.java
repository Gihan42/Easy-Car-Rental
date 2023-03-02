package lk.EasyCarRental.service.impl;

import lk.EasyCarRental.config.WebRootConfig;
import lk.EasyCarRental.dto.CarDto;
import lk.EasyCarRental.entity.Car;
import lk.EasyCarRental.repo.CarRepo;
import lk.EasyCarRental.repo.CustomerRepo;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration  //create  testing conterx
@ContextConfiguration(classes = {WebRootConfig.class}) //configuration add krnwa context ekata
@ExtendWith(SpringExtension.class) //junit ekk intrigarate kranne meke
@Transactional
class CarServiceImplTest {
    @Autowired
    CarRepo repo;
    @Test
    void searchCar() {
        Car carsByvehicleNum = repo.findCarByVehicleNum("8658");
        System.out.println(carsByvehicleNum);
    }
    @Test
    void count(){
        long aTrue = repo.countCarsByAvailable("Available");
        System.out.println(aTrue);
    }
    @Test
    void countPrimium(){
        ArrayList<Car> premium = repo.findCarsByVehicleType("Premium");
        for (Car car:premium){
            System.out.println(car);
        }
    }
    @Test
    void countGeneral(){
        /*List<Car> General = repo.findCarsByvehicleType("General");
        for (Car car:General){
            System.out.println(car);
        }*/
    }
}