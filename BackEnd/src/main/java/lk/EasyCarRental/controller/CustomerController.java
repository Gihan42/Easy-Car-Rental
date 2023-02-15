package lk.EasyCarRental.controller;

import lk.EasyCarRental.dto.CustomerDto;
import lk.EasyCarRental.service.CustomerService;
import lk.EasyCarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController{
    @Autowired
    private CustomerService service;
    public CustomerController(){
        System.out.println("CustomerController");
    }
    @GetMapping
    public void getAllCustomer(){
        System.out.println("getAll");
    }
    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDto dto){
        System.out.println(dto);
        service.saveCustomer(dto);
        return new ResponseUtil("ok","CustomerSave",null);
    }

}
