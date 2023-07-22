package com.livrodb.livros.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name="autor_id")
    private Long id;
    private String nome;

    //Anotação para evitar loop infinito, esta indica que este é o pai
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "autor")
    private Set<LivrosModel> livros;

    @JsonIgnore
    @CreationTimestamp
    private OffsetDateTime createdOn;
    
    @JsonIgnore
    @UpdateTimestamp
    private OffsetDateTime updatedOn;


    //Getters e Setters
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
