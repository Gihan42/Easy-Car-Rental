package lk.EasyCarRental.repo;

import lk.EasyCarRental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface CarRepo extends JpaRepository<Car,String> {
//    @Query(value = "SELECT  * FROM  Car WHERE vehicleNum=?", nativeQuery = true)
    Car findCarByVehicleNum(String vehicleNum);

    @Query(value = "Count * FROM Car WHERE available=1", nativeQuery = true)
    long countCarsByAvailable();
    ArrayList<Car> findCarsByVehicleType(String Premium);


}
