package org.example.posbackend.controller;

import org.example.posbackend.Util.ApiResponse;
import org.example.posbackend.dto.OrderDto;
import org.example.posbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<ApiResponse<String>> placeOrder(@RequestBody OrderDto orderDto) {
        orderService.placeOrder(orderDto);
        return new ResponseEntity<>(new ApiResponse<>(
                201,"Order Placed" , null)
                , HttpStatus.CREATED);
    }
}
