package lk.EasyCarRental.service.impl;
import lk.EasyCarRental.dto.CarDto;
import lk.EasyCarRental.dto.CustomerDto;
import lk.EasyCarRental.entity.Car;
import lk.EasyCarRental.entity.Customer;
import lk.EasyCarRental.repo.CustomerRepo;
import lk.EasyCarRental.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public void saveCustomer(CustomerDto dto) {
        if(repo.existsById(dto.getNic())){
            throw new RuntimeException("Invalid Id");
        }
//        Path licenseLocation = Paths.get("C:\\Users\\LALITH\\Pictures\\whats app");
//
//        System.out.println("licenseLocation = " + licenseLocation);
//
//        try {
//            Files.write(licenseLocation, dto.getNicImage().getBytes());
//            dto.getNicImage().transferTo(licenseLocation);
//
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        Customer customer=mapper.map(dto,Customer.class);
       // customer.setNicImage(licenseLocation.toString());
       repo.save(customer);
    }

    @Override
    public ArrayList<CustomerDto> getCustomer() {
        return mapper.map(repo.findAll(),new TypeToken<ArrayList<CustomerDto>>(){}.getType());

    }

    @Override
    public CustomerDto findCustomerByNic(String nic) {
        if(!repo.existsById(nic)){
            throw new RuntimeException("Invalid Id");
        }
        Customer customer=repo.findCustomerByNic(nic);
        CustomerDto map=mapper.map(customer,CustomerDto.class);
        System.out.println(customer);
        return map;
    }

    @Override
    public void UpdateCustomer(CustomerDto dto) {
        if(!repo.existsById(dto.getNic())){
            throw new RuntimeException("customer not exits");
        }
        repo.save(mapper.map(dto,Customer.class));
        System.out.println(dto);
    }

    @Override
    public void DeleteCustomer(String nic) {
        if(!repo.existsById(nic)){
            throw new RuntimeException("invalid id") ;
        }
        repo.deleteById(nic);
    }


    @Override
    public long countCustomer( ){
        long count = repo.count();
        return count;
    }




}
