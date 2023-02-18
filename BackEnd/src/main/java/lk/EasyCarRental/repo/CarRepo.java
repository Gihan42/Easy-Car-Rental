package lk.EasyCarRental.repo;

import lk.EasyCarRental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car,String> {
    Car findCarsByvehicleNum(String vehicleNum);
}
