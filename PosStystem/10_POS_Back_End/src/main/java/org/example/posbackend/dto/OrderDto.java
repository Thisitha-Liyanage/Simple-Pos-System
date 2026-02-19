package org.example.posbackend.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {

    @NotBlank(message = "Order ID is required")
    private String orderID;

    @NotBlank(message = "Date is required")
    private String date;

    @NotBlank(message = "Customer ID is required")
    private String customerID;

    @NotNull(message = "Order must contain items")
    @Size(min = 1, message = "Add at least one item")
    @Valid
    private List<OrderDetailDto> orderDetailDTOList;
}
