package lk.EasyCarRental.repo;

import lk.EasyCarRental.entity.Booking;
import lk.EasyCarRental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepo extends JpaRepository<Booking,String> {
    long countAllBy();


}
