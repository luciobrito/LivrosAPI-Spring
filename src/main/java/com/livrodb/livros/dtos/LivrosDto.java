package com.livrodb.livros.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivrosDto(@NotBlank String nome, @NotNull String autor, String ano) {
    
}