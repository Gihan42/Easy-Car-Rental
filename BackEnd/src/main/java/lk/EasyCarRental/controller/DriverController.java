package lk.EasyCarRental.controller;

import lk.EasyCarRental.dto.DriverDto;
import lk.EasyCarRental.service.DriverService;
import lk.EasyCarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverService service;

    @GetMapping
    public ResponseUtil getDriver(){
        System.out.println("getAllDriver");
        return new ResponseUtil("ok","loadAllDrivers",service.getDriver());
    }
    @PostMapping
    public ResponseUtil saveDriver(@ModelAttribute DriverDto dto){
        System.out.println("saveDriver");
        service.saveDriver(dto);
        return new ResponseUtil("ok","driver save",null);
    }
    @GetMapping(path = {"/driverID"})
    public ResponseUtil searchDriver( String driverID ){
        service.findDriverBydriverID(driverID);
        return new ResponseUtil("ok","search",null);
    }
    @DeleteMapping(params = "driverID")
    public ResponseUtil deleteDriver(@RequestParam String driverID){
        service.deleteDriver(driverID);
        return new ResponseUtil("ok","deleted",null);
    }
    @PutMapping
    public ResponseUtil updateDriver(@RequestBody DriverDto dto){
        service.updateDriver(dto);
        return new ResponseUtil("ok","updated",null);
    }
}
