package lk.EasyCarRental.controller;

import lk.EasyCarRental.dto.CarDto;
import lk.EasyCarRental.dto.DriverDto;
import lk.EasyCarRental.service.CarService;
import lk.EasyCarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {
    @Autowired
    private CarService service;

    @PostMapping
    public ResponseUtil saveCar(@ModelAttribute CarDto dto){
        System.out.println(dto);
        service.saveCar(dto);
        return new ResponseUtil("ok","car save",null);
    }
    @GetMapping(path = {"/vehicleNum"})
    public ResponseUtil searchCar(String vehicleNum){
        service.findCarByvehicleNum(vehicleNum);
        return new ResponseUtil("ok","search car",null);

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

}
