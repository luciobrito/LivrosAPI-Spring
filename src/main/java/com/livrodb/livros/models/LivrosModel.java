package com.livrodb.livros.models;

import java.time.OffsetDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class LivrosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long idLivro;
    private String nome;
    private String ano;
    //Anotação para evitar loop infinito, este indica que é o filho
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id", referencedColumnName = "autor_id", nullable = false)
    private AutoresModel autor;

    @JsonIgnore
    @CreationTimestamp
    private OffsetDateTime createdOn;

    @JsonIgnore
    @UpdateTimestamp
    private OffsetDateTime updatedOn;


    public AutoresModel getAutor() {
        return autor;
    }

    public void setAutor(AutoresModel autor) {
        this.autor = autor;
    }



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

    public OffsetDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(OffsetDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public OffsetDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(OffsetDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

}