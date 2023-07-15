package com.livrodb.livros.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "autor")
public class AutoresModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="autor_id")
    private Long id;
    private String nome;

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
    //Anotação para evitar loop infinito, esta indica que este é o pai
    @JsonManagedReference

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "autor")
    private Set<LivrosModel> livros;


}
