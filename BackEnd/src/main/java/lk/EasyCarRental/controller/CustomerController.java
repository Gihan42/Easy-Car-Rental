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

    @DeleteMapping(params = "nic")
    public ResponseUtil DeleteCustomer(@RequestParam String nic){
        service.DeleteCustomer(nic);
        return new ResponseUtil("ok","DeleteCustomer",null);
    }

//    searchcustomer
    @GetMapping(params = {"nic"})
    public ResponseUtil searchCustomer(String nic){
        return new ResponseUtil("ok","searchcustomer",service.findCustomerByNic(nic));
    }

    @GetMapping(params = {"option"})
    public ResponseUtil customerCount(){
        System.out.println(service.countCustomer());
        return new ResponseUtil("ok","countcustomer",service.countCustomer());
    }

}
