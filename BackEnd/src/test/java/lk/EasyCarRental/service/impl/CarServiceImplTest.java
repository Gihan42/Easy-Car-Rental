package lk.EasyCarRental.service.impl;

import lk.EasyCarRental.config.WebRootConfig;
import lk.EasyCarRental.dto.CarDto;
import lk.EasyCarRental.entity.Car;
import lk.EasyCarRental.repo.CustomerRepo;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration  //create  testing conterx
@ContextConfiguration(classes = {WebRootConfig.class}) //configuration add krnwa context ekata
@ExtendWith(SpringExtension.class) //junit ekk intrigarate kranne meke
@Transactional
class CarServiceImplTest {
    @Autowired
    CustomerRepo repo;
    @Test
    void saveCar() {
    }
}