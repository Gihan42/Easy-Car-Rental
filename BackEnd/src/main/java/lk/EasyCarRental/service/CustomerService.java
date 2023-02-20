package lk.EasyCarRental.service;

import lk.EasyCarRental.dto.CarDto;
import lk.EasyCarRental.dto.CustomerDto;

import java.util.ArrayList;

public interface CustomerService {

    void saveCustomer(CustomerDto dto);
    ArrayList<CustomerDto> getCustomer();
    CustomerDto findCustomerByNic(String nic);
    void UpdateCustomer(CustomerDto dto);
    void DeleteCustomer(String nic);
    long countCustomer();

}
