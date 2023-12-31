package com.livrodb.livros.models;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class LivrosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID idLivro;

    private String titulo;
    private String ano;

    //Anotação para evitar loop infinito
    //Ignora a propriedade livros na serialização
    @JsonIgnoreProperties("livros")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id", referencedColumnName = "id", nullable = false)
    private AutoresModel autor;



    private String linkImagem;

    @Column(columnDefinition = "TEXT")
    private String descricao;


    @CreationTimestamp
    private OffsetDateTime createdOn;


    @UpdateTimestamp
    private OffsetDateTime updatedOn;




    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
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

    public UUID getIdLivro() {
        return idLivro;
    }


    public void setIdLivro(UUID idLivro) {
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

    public String getLinkImagem() {
        return linkImagem;
    }

    public void setLinkImagem(String linkImagem) {
        this.linkImagem = linkImagem;
    }

}