package lk.EasyCarRental.service.impl;
import lk.EasyCarRental.dto.CustomerDto;
import lk.EasyCarRental.entity.Customer;
import lk.EasyCarRental.repo.CustomerRepo;
import lk.EasyCarRental.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Customer customer=mapper.map(dto,Customer.class);
        repo.save(customer);
    }

    @Override
    public ArrayList<CustomerDto> getCustomer() {
        return mapper.map(repo.findAll(),new TypeToken<ArrayList<CustomerDto>>(){}.getType());

    }

    @Override
    public CustomerDto findCustomerByNic(String nic) {
        if(repo.existsById(nic)){
            throw new RuntimeException("Invalid Id");
        }
        Customer customer=repo.findCustomerByNic(nic);
        CustomerDto map=mapper.map(customer,CustomerDto.class);
        System.out.println(customer);
        return map;
    }
}
