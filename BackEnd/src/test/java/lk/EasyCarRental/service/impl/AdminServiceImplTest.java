package lk.EasyCarRental.service.impl;

import lk.EasyCarRental.config.WebRootConfig;
import lk.EasyCarRental.entity.Admin;
import lk.EasyCarRental.repo.AdminRepo;
import lk.EasyCarRental.repo.CarRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@WebAppConfiguration  //create  testing conterx
@ContextConfiguration(classes = {WebRootConfig.class}) //configuration add krnwa context ekata
@ExtendWith(SpringExtension.class) //junit ekk intrigarate kranne meke
@Transactional
class AdminServiceImplTest {
    @Autowired
    AdminRepo repo;

  /*  @Test
    void findAdmin() {
        ArrayList<Admin> adminByEmailaddressAndPassword = repo.findAdminByEmailaddressAndPassword("admin12@gmail.com", "123");
        for (Admin ad:adminByEmailaddressAndPassword
             ) {
            System.out.println(ad);
        }

    }*/
}