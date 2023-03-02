package lk.EasyCarRental.repo;

import lk.EasyCarRental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface CarRepo extends JpaRepository<Car,String> {
//    @Query(value = "SELECT  * FROM  Car WHERE vehicleNum=?", nativeQuery = true)
    Car findCarByVehicleNum(String vehicleNum);

   long countCarsByAvailable(String Available);
    ArrayList<Car> findCarsByVehicleType(String Premium);


}
