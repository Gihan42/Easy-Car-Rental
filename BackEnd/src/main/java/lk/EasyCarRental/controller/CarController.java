package lk.EasyCarRental.controller;

import lk.EasyCarRental.dto.CarDto;
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
}
