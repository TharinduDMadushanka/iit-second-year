package lk.iit.TicketSystem.controller;

import lk.iit.TicketSystem.dto.CustomerDTO;
import lk.iit.TicketSystem.entity.Customer;
import lk.iit.TicketSystem.service.CustomerService;
import lk.iit.TicketSystem.util.StandardResponse;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.Logger;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/v1/customer")
public class CustomerController {

    private static final Logger logger = LogManager.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save-customer")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDTO customerDTO) {

        String message = customerService.saveCustomer(customerDTO);

        if (message != null) {
//            logger.info("Customer saved successfully..!");
            logger.info("Customer "+customerDTO.getCustomerName()+" saved successfully");
        }else {
            logger.error("Customer save failed");
        }

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",message), HttpStatus.CREATED
        );

    }

//    @GetMapping(
//            path = "/get-all-customers"
//    )
//    public ResponseEntity<StandardResponse> getAllCustomers() {
//
//        List<Customer> customers = customerService.getAllCustomers();
//
//        return new ResponseEntity<StandardResponse>(
//                new StandardResponse(201,"Success",customers), HttpStatus.CREATED
//        );
//
//    }

    @GetMapping(
            path = "/customer-get-by-id",
            params = "id"
    )
    public ResponseEntity<StandardResponse> getCustomerById(@RequestParam int id) {
        CustomerDTO customerDTO = customerService.getCustomerByID(id);

        if (customerDTO != null) {
            logger.info("Customer "+customerDTO.getCustomerName()+" get successfully");
        }else {
            logger.error("Customer "+customerDTO.getCustomerName()+" get failed");
        }

        return new ResponseEntity<>(
                new StandardResponse(200, "Success", customerDTO),
                HttpStatus.OK
        );
    }


    @DeleteMapping(
            path = "delete-customer",
            params = "id"
    )
    public ResponseEntity<StandardResponse> deleteCustomer(@RequestParam int id) {

        String message = customerService.deleteCustomer(id);

        if (message != null) {
            logger.info("Customer "+id+" deleted successfully");
        }else {
            logger.error("Customer "+id+" deleted failed");
        }

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",message), HttpStatus.CREATED
        );

    }

    @GetMapping(path ="/get-all-customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customerDTOS = customerService.findAllCustomers();

        if (customerDTOS != null) {
            logger.info("Customer list found");
        }else {
            logger.warn("Customer list not found");
        }

        return ResponseEntity.status(200).body(customerDTOS);

    }

    @PutMapping("/update-customer")
    public ResponseEntity<StandardResponse> updateCustomer(@RequestBody CustomerDTO customerDTO) {

        String message = customerService.updateCustomer(customerDTO);

        if (message != null) {
            logger.info("Customer "+customerDTO.getCustomerName()+" updated successfully");
        }else {
            logger.error("Customer "+customerDTO.getCustomerName()+" updated failed");
        }

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",message), HttpStatus.CREATED
        );
    }

}
