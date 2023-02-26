package lk.EasyCarRental.repo;
import lk.EasyCarRental.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver,String>{

    Driver findDriverBydriverID(String driverID );
    Driver findDriverByAvailable(String available);
}
