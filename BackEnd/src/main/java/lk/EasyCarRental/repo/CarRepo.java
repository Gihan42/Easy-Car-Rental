package lk.EasyCarRental.repo;

import lk.EasyCarRental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface CarRepo extends JpaRepository<Car,String> {
    Car findCarsByvehicleNum(String vehicleNum);
    long countCarByavailable( boolean available);
    ArrayList<Car> findCarsByVehicleType(String Premium);


}
