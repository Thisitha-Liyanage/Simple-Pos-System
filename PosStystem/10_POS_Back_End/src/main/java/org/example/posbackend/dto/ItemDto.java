package org.example.posbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ItemDto {
    @NotNull
    private String id;

    @NotBlank
    @Pattern(regexp = "^[A-Za-z ]+$\n" ,message = "incorrect name")
    private String name;

    @NotBlank
    @Positive
    @Pattern(regexp = "^\\d+(\\.\\d{1,2})?$\n" , message = "incorrect value")
    private double price;

    @NotBlank
    @Positive
    private int quantity;
}
