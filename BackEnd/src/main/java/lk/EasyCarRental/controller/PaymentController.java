package lk.EasyCarRental.controller;

import lk.EasyCarRental.dto.AdminDto;
import lk.EasyCarRental.dto.PaymentDto;
import lk.EasyCarRental.service.PaymentService;
import lk.EasyCarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/payment")
@CrossOrigin
public class PaymentController {

    @Autowired
    private PaymentService service;
    @PostMapping
    public ResponseUtil savePayment(@RequestBody PaymentDto dto){
        service.savePayment(dto);
        return new ResponseUtil("ok","successfully payment added",null);
    }

    @GetMapping
    public ResponseUtil getAllPayments(){
        return new ResponseUtil("ok","",service.getAllPayments());
    }
}
