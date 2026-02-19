package org.example.posbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class OrderDetailDto {
    @NotBlank
    private String itemId;
    @NotBlank
    @Positive
    private int itemQty;

    @NotBlank
    @Positive
    @Pattern(regexp = "^\\d+(\\.\\d{1,2})?$\n" , message = "incorrect value")
    private double unitPrice;
}
