package com.livrodb.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.livrodb.livros.models.LivrosModel;

@Repository
public interface LivrosRepo extends JpaRepository<LivrosModel, Long> {
}