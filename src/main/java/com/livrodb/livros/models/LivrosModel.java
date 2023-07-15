package com.livrodb.livros.models;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.annotation.Generated;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_livros")
public class LivrosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long idLivro;
    private String nome;
    private String ano;

    public AutoresModel getAutor() {
        return autor;
    }

    public void setAutor(AutoresModel autor) {
        this.autor = autor;
    }
    //Anotação para evitar loop infinito, este indica que é o filho
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private AutoresModel autor;



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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