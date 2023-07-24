package com.livrodb.livros.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


import java.time.OffsetDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "autor")
public class AutoresModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    private String nome;

    private String nacionalidade;

    //Anotação para evitar loop infinito, ignora a propriedade "autor" na serialização
    @JsonIgnoreProperties("autor")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "autor")
    public Set<LivrosModel> livros;


    @CreationTimestamp
    private OffsetDateTime createdOn;
    

    @UpdateTimestamp
    private OffsetDateTime updatedOn;


    //Getters e Setters

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<LivrosModel> getLivros() {
        return livros;
    }

    public void setLivros(Set<LivrosModel> livros) {
        this.livros = livros;
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
