package com.livrodb.livros.controllers;

import com.livrodb.livros.dtos.AutoresDto;
import com.livrodb.livros.models.AutoresModel;

import com.livrodb.livros.repository.AutoresRepo;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AutoresController {
    @Autowired
    AutoresRepo autRepo;

    @PostMapping("/autor")
    public ResponseEntity<AutoresModel> salvarAutor(@RequestBody @Valid AutoresDto autDto){
        var autMod = new AutoresModel();
        BeanUtils.copyProperties(autDto, autMod);
        return ResponseEntity.status(HttpStatus.CREATED).body(autRepo.save(autMod));
    }
    @GetMapping("/autor")
    public ResponseEntity<List<AutoresModel>> getAllAutores(){
        return ResponseEntity.status(HttpStatus.OK).body(autRepo.findAll());
    }
}
