package lk.EasyCarRental.repo;

import lk.EasyCarRental.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,String> {
}
