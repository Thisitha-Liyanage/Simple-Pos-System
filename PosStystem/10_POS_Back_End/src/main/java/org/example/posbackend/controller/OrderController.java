package org.example.posbackend.controller;

import jakarta.validation.Valid;
import org.example.posbackend.Util.ApiResponse;
import org.example.posbackend.dto.OrderDto;
import org.example.posbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<ApiResponse<String>> placeOrder(
            @RequestBody @Valid OrderDto orderDto) {

        orderService.placeOrder(orderDto);

        return new ResponseEntity<>(
                new ApiResponse<>(201, "Order Placed", null),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<OrderDto>>> getAllOrders() {
        List<OrderDto> orders = orderService.getOrders();
        ApiResponse<List<OrderDto>> response = new ApiResponse<>(
                200,
                "Orders fetched successfully",
                orders
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
