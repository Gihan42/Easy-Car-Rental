package lk.EasyCarRental.controller;

import lk.EasyCarRental.dto.DriverDto;
import lk.EasyCarRental.service.DriverService;
import lk.EasyCarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/driver")
@RestController
public class DriverController {
    @Autowired
    private DriverService service;

    @PostMapping
    public ResponseUtil saveDriver(@ModelAttribute DriverDto dto){
        System.out.println("saveDriver");
        service.saveDriver(dto);
        return new ResponseUtil("ok","driver save",null);
    }
    @GetMapping
    public void getDriver(){
        System.out.println("driver");
    }
}
