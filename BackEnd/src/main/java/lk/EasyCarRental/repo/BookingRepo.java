package lk.EasyCarRental.repo;

import lk.EasyCarRental.entity.Booking;
import lk.EasyCarRental.entity.Car;
import lk.EasyCarRental.entity.Customer;
import lk.EasyCarRental.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepo extends JpaRepository<Booking,String> {
    long countAllBy();
    long count();
    Booking searchBookingByDriver_DriverID(String driverID);
    Booking findBookingByBookingID(String bookingID);
    Booking searchBookingByCar_VehicleNum(String vehicleNum);

}
