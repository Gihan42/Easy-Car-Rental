package lk.EasyCarRental.service.impl;

import lk.EasyCarRental.dto.PaymentDto;
import lk.EasyCarRental.entity.Payment;
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
    @Override
    public void savePayment(PaymentDto dto) {
        if (repo.existsById(dto.getBookingID())){
            throw new RuntimeException("Already exist id");
        }
        System.out.println(dto);
        Payment payment = mapper.map(dto,Payment.class);
        repo.save(payment);
    }

    @Override
    public void deletePayment(String id) {

    }

    @Override
    public ArrayList<PaymentDto> getAllPayments() {
        return mapper.map(repo.findAll(),new TypeToken<ArrayList<PaymentDto>>(){}.getType());
    }
}
