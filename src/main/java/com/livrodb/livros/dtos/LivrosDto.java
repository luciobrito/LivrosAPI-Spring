package com.livrodb.livros.dtos;

import java.util.List;
import com.livrodb.livros.models.AutoresModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivrosDto(@NotBlank String titulo,
                        String ano,
                        AutoresModel autor,
                        String descricao) {
    
}