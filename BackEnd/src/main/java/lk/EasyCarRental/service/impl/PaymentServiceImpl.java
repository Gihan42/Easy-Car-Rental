package lk.EasyCarRental.service.impl;

import lk.EasyCarRental.dto.PaymentDto;
import lk.EasyCarRental.entity.Car;
import lk.EasyCarRental.entity.Driver;
import lk.EasyCarRental.entity.Payment;
import lk.EasyCarRental.repo.CarRepo;
import lk.EasyCarRental.repo.DriverRepo;
import lk.EasyCarRental.repo.PaymentRepo;
import lk.EasyCarRental.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepo repo;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    CarRepo carRepo;

    @Autowired
    DriverRepo driverRepo;

    @Override
    public void savePayment(PaymentDto dto) {
        if (repo.existsById(dto.getBookingID())){
            throw new RuntimeException("Already exist id");
        }
        System.out.println(dto);
        Payment payment = mapper.map(dto,Payment.class);
        repo.save(payment);

        Car car = carRepo.findCarByVehicleNum(payment.getBooking().getCar().getVehicleNum());
        Driver driver=driverRepo.findDriverBydriverID(payment.getBooking().getDriver().getDriverID());

        car.setAvailable("Available");
        driver.setAvailable("Available");
        carRepo.save(car);
        driverRepo.save(driver);
    }

    @Override
    public void deletePayment(String id) {

    }

    @Override
    public ArrayList<PaymentDto> getAllPayments() {
        return mapper.map(repo.findAll(),new TypeToken<ArrayList<PaymentDto>>(){}.getType());
    }
}
