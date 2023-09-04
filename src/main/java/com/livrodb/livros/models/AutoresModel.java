package com.livrodb.livros.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "autor")
public class AutoresModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private UUID id;
    private String nome;

    private String nacionalidade;

    //Anotação para evitar loop infinito, ignora a propriedade "autor" na serialização
    @JsonIgnoreProperties("autor")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "autor")
    public Set<LivrosModel> livros;


    @Column(columnDefinition = "TEXT")
    private String descricao;

    @CreationTimestamp
    private OffsetDateTime createdOn;
    

    @UpdateTimestamp
    private OffsetDateTime updatedOn;



    private String linkImagem;

    //Getters e Setters

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getLinkImagem() {
        return linkImagem;
    }

    public void setLinkImagem(String linkImagem) {
        this.linkImagem = linkImagem;
    }

}
