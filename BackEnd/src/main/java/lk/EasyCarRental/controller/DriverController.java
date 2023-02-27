package lk.EasyCarRental.controller;

import lk.EasyCarRental.dto.DriverDto;
import lk.EasyCarRental.entity.Driver;
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
    @GetMapping(params = {"driverID"})
    public ResponseUtil searchDriver( String driverID ){
        return new ResponseUtil("ok","search",service.findDriverBydriverID(driverID));
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
   /* @GetMapping(params = "Available")
    public ResponseUtil selectAvailableDriver(@RequestParam String Available){
        DriverDto d= service.findDriver(Available);
        System.out.println(d);
        return new ResponseUtil("ok","searchA",service.findDriver(Available));
    }*/
    @GetMapping(params = {"available"})
    public ResponseUtil countAvailableDriver(String available){
        return new ResponseUtil("ok","available",service.countAvailableDriver(available));
    }

}
