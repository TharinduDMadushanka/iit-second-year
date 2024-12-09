package lk.iit.TicketSystem.service;

import lk.iit.TicketSystem.dto.CustomerDTO;
import lk.iit.TicketSystem.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    String saveCustomer(CustomerDTO customerDTO);

//    List<Customer> getAllCustomers();

    String deleteCustomer(int id);

    CustomerDTO getCustomerByID(int id);

    List<CustomerDTO> findAllCustomers();

    String updateCustomer(CustomerDTO customerDTO);
}
