package com.livrodb.livros.repository;

import com.livrodb.livros.models.AutoresModel;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoresRepo extends JpaRepository<AutoresModel, UUID> {

}
