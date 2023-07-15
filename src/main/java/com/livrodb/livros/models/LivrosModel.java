package com.livrodb.livros.models;

import java.math.BigDecimal;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_livros")
public class LivrosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long idLivro;
    private String nome;
    private String autor;
    private String ano;




    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getAutor() {
        return autor;
    }


    public void setAutor(String autor) {
        this.autor = autor;
    }


    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Long getIdLivro() {
        return idLivro;
    }


    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

}