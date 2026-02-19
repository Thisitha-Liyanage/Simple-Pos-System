package org.example.posbackend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
    @NotBlank
    private String orderID;
    @NotBlank
    @DateTimeFormat
    private String date;
    @NotBlank
    private String customerID;
    private List<OrderDetailDto> orderDetailDTOList;

}
