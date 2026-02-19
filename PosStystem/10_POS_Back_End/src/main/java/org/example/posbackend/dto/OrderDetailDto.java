package org.example.posbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailDto {

    @NotBlank(message = "Item ID is required")
    private String itemId;

    @Positive(message = "Quantity must be greater than 0")
    private int itemQty;

    @Positive(message = "Unit price must be greater than 0")
    private double unitPrice;
}
