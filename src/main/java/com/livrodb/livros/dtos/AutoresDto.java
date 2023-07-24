package com.livrodb.livros.dtos;

import com.livrodb.livros.models.LivrosModel;
import jakarta.validation.constraints.NotBlank;

public record AutoresDto (@NotBlank String nome, LivrosModel livros, String nacionalidade){
}
