package com.example.crud.domain.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDTO(
        String id,
        @NotBlank
        String name,
        @NotNull
        Integer price) {
}
