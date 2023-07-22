package com.livrodb.livros.dtos;


import com.livrodb.livros.models.AutoresModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivrosDto(@NotBlank String nome, String ano, @NotNull AutoresModel autor) {
    
}