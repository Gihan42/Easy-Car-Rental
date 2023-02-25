package lk.EasyCarRental.controller;

import lk.EasyCarRental.dto.BookingDto;
import lk.EasyCarRental.service.BookingService;
import lk.EasyCarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
@CrossOrigin

public class BookingController {
    @Autowired
    private BookingService service;
    @GetMapping
    public ResponseUtil getAllBooking(){
        System.out.println("get all");
        return new ResponseUtil("ok","getAll",service.getAllBooking());
    }
    @GetMapping(params = {"bookingID"})
    public ResponseUtil generateBookingId(){

        return new ResponseUtil("ok","generateId",service.generateBookingId());
    }
    @PostMapping
    public ResponseUtil saveBooking(@RequestBody BookingDto dto){
        service.saveBooking(dto);
        return new ResponseUtil("ok","saved",null);
    }

}
