package lk.EasyCarRental.repo;

import lk.EasyCarRental.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,String> {
}
