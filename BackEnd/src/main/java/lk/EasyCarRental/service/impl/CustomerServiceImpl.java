package lk.EasyCarRental.service.impl;
import lk.EasyCarRental.dto.CustomerDto;
import lk.EasyCarRental.entity.Customer;
import lk.EasyCarRental.repo.CustomerRepo;
import lk.EasyCarRental.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
