package com.livrodb.livros.models;

import java.time.OffsetDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class LivrosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long idLivro;

    private String titulo;
    private String ano;

    //Anotação para evitar loop infinito
    //Ignora a propriedade livros na serialização
    @JsonIgnoreProperties("livros")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id", referencedColumnName = "id", nullable = false)
    private AutoresModel autor;


    @CreationTimestamp
    private OffsetDateTime createdOn;


    @UpdateTimestamp
    private OffsetDateTime updatedOn;



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public AutoresModel getAutor() {
        return autor;
    }

    public void setAutor(AutoresModel autor) {
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