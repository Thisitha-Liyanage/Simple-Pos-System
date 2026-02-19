package org.example.posbackend.controller;

import jakarta.validation.Valid;
import org.example.posbackend.Util.ApiResponse;
import org.example.posbackend.dto.CustomerDto;
import org.example.posbackend.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<ApiResponse<String>> saveCustomer(@RequestBody @Valid CustomerDto customerDto) {
        customerService.saveCustomer(customerDto);
        return new ResponseEntity<>(new ApiResponse<>(
                201,"Customer Saved" , null)
                , HttpStatus.CREATED);

    }

    @PutMapping(consumes = "application/json")
    public  ResponseEntity<ApiResponse<String>> updateCustomer(@RequestBody @Valid CustomerDto customerDto) {
        customerService.updateCustomer(customerDto);
        return new ResponseEntity<>(new ApiResponse<>(
                201,"Customer Updated" , null)
                , HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteCustomer(@PathVariable String id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(new ApiResponse<>(
                201,"Customer Deleted" , null)
                , HttpStatus.CREATED);
    }

    @GetMapping
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}
