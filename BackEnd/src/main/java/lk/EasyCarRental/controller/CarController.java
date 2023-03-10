package lk.EasyCarRental.controller;

import lk.EasyCarRental.dto.CarDto;
import lk.EasyCarRental.dto.DriverDto;
import lk.EasyCarRental.service.CarService;
import lk.EasyCarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {
    @Autowired
    private CarService service;

    @PostMapping
    public ResponseUtil saveCar(@ModelAttribute CarDto dto, @ModelAttribute MultipartFile img){
        System.out.println(dto);

        service.saveCar(dto, img);
        return new ResponseUtil("ok","car save",null);
    }
    @GetMapping(params = {"vehicleNum"})
    public ResponseUtil searchCar(String vehicleNum){
        System.out.println(vehicleNum);
        return new ResponseUtil("ok","search car",service.findCarByvehicleNum(vehicleNum));

    }
    @GetMapping
    public ResponseUtil getAllCar(){
        System.out.println("getAllCar");
        return new ResponseUtil("ok","loadcar",service.getCars());
    }
    @PutMapping
    public ResponseUtil updateCar(@RequestBody CarDto dto){
        service.updateCar(dto);
        return new ResponseUtil("ok","updated",null);
    }
    @DeleteMapping(params = "vehicleNum")
    public ResponseUtil deleteCar(@RequestParam String vehicleNum){
        service.deleteCar(vehicleNum);
        return new ResponseUtil("ok","deleted",null);
    }
    @GetMapping(params = {"availableC"})
    public ResponseUtil countAvailableCar(String available){
        return new ResponseUtil("ok","available",service.countAvailableCars(available));
    }

    @GetMapping(params = {"Premium"})
    public ResponseUtil getPremiumCar(){
        System.out.println("no");
        return new ResponseUtil("ok","PremiumCars",service.indCarsByVehicleType("Premium","Available"));
    }
    @GetMapping(params = {"General"})
    public ResponseUtil getGenaralCars(){
        return new ResponseUtil("ok","PremiumCars",service.findCarsByGeneralType("General","Available"));

    }
    @GetMapping(params = {"Luxury"})
    public ResponseUtil getLuxuryCars(){
        return new ResponseUtil("ok","PremiumCars",service.findCarsByLuxuryType("Luxury","Available"));

    }

}
