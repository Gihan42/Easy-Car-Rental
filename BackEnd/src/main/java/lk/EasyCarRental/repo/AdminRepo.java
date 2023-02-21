package lk.EasyCarRental.repo;

import lk.EasyCarRental.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin,String> {

    Admin findAdminByEmailaddress(String emailaddress);
}
