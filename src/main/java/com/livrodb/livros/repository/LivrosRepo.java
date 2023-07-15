package com.livrodb.livros.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import com.livrodb.livros.models.LivrosModel;

import java.util.List;
import java.util.function.Function;

@Repository
public interface LivrosRepo extends JpaRepository<LivrosModel, Long> {
}