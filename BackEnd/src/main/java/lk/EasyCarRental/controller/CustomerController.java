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
    public ResponseUtil getAllCustomer(){
        System.out.println("getAll");
        return new ResponseUtil("ok","loadallcustomer",service.getCustomer());
    }
    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDto dto){
        System.out.println(dto);
        service.saveCustomer(dto);
        return new ResponseUtil("ok","CustomerSave",null);
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDto dto){
        service.UpdateCustomer(dto);
        System.out.println(dto);
        return new ResponseUtil("ok","CustomerUpdated",null);
    }


//    searchcustomer
    @GetMapping(path = {"/nic"})
    public ResponseUtil searchCustomer(String nic){
        service.findCustomerByNic(nic);
        return new ResponseUtil("ok","searchcustomer",null);
    }

}
