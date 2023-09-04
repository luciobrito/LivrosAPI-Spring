package com.livrodb.livros.dtos;

import com.livrodb.livros.models.AutoresModel;
import jakarta.validation.constraints.NotBlank;


public record LivrosDto(@NotBlank String titulo,
                        String ano,
                        AutoresModel autor,
                        String descricao,
                        String linkImagem) {
    
}