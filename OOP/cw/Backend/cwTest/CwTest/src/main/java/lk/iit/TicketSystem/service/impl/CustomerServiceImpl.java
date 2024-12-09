package lk.iit.TicketSystem.service.impl;

import lk.iit.TicketSystem.dto.CustomerDTO;
import lk.iit.TicketSystem.entity.Customer;
import lk.iit.TicketSystem.repo.CustomerRepo;
import lk.iit.TicketSystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {

        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getEmail(),
                customerDTO.getPhone(),
                customerDTO.getPassword(),
                customerDTO.getRetrievalInterval()
        );

        if (!customerRepo.existsById(customer.getCustomerId())) {
            customerRepo.save(customer);
            return "Customer added successfully";
        }else {
            return "Customer already exists";
        }

    }

//    @Override
//    public List<Customer> getAllCustomers() {
//
//        List<Customer> allCustomers = customerRepo.findAll();
//
//        if (allCustomers.isEmpty()) {
//            return null;
//        }else {
//            return allCustomers;
//        }
//
//    }

    @Override
    public String deleteCustomer(int id) {

        if (!customerRepo.existsById(id)) {
            return "Customer not found";
        }else {
            customerRepo.deleteById(id);
            return "Customer deleted successfully";
        }

    }

    @Override
    public CustomerDTO getCustomerByID(int id) {
        Optional<Customer> customerOptional = customerRepo.findById(id);

        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            return new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getEmail(),
                    customer.getPhone(),
                    customer.getPassword(),
                    customer.getRetrievalInterval()
            );
        } else {
            throw new RuntimeException("Customer not found with ID: " + id);
        }
    }

    @Override
    public List<CustomerDTO> findAllCustomers() {

        List<Customer> customers = customerRepo.findAll();

        List<CustomerDTO> customerDTOList = new ArrayList<>();

        if (!customers.isEmpty()) {
            for (Customer customer : customers) {
                customerDTOList.add(new CustomerDTO(
                   customer.getCustomerId(),
                   customer.getCustomerName(),
                   customer.getEmail(),
                   customer.getPhone(),
                   customer.getPassword(),
                   customer.getRetrievalInterval()
                ));
            }
            return customerDTOList;
        }else {
            throw new RuntimeException("Customer list is empty");
        }

    }

    @Override
    public String updateCustomer(CustomerDTO customerDTO) {

        boolean existCustomer = customerRepo.existsById(customerDTO.getCustomerId());

        if (existCustomer) {
            Customer customer = customerRepo.getReferenceById(customerDTO.getCustomerId());
            customer.setCustomerName(customerDTO.getCustomerName());
            customer.setEmail(customerDTO.getEmail());
            customer.setPhone(customerDTO.getPhone());
            customer.setPassword(customerDTO.getPassword());
            customer.setRetrievalInterval(customerDTO.getRetrievalInterval());

            customerRepo.save(customer);
            return "Customer updated successfully";
        }else {
            return "Customer not found";
        }

    }

}
