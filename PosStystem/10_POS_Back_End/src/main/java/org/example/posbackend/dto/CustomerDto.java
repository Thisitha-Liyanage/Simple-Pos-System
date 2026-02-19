package org.example.posbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    @NotNull
    private String id;

    @NotBlank
    @Pattern(regexp = "^[A-Za-z]+$" ,message = "incorrect name")
    private String name;

    @NotBlank
    @Size(min = 5, max = 100)
    private String address;

}
