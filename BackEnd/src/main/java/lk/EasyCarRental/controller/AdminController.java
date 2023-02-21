package lk.EasyCarRental.controller;

import lk.EasyCarRental.dto.AdminDto;
import lk.EasyCarRental.dto.CustomerDto;
import lk.EasyCarRental.service.AdminService;
import lk.EasyCarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminService service;

    @PostMapping
    public ResponseUtil saveAdmin(@ModelAttribute AdminDto dto){
        System.out.println(dto);
        service.AdminSave(dto);
        return new ResponseUtil("ok","AdminSave",null);
    }
    @GetMapping(params = {"emailaddress"})
    public ResponseUtil findAdmin(String emailaddress){
        return new ResponseUtil("ok","AdminSave",service.findAdminByemail(emailaddress));
    }
    @GetMapping
    public  void getAllAdmin(){
        System.out.println("getAll");
    }
}
