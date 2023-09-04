package com.livrodb.livros.controllers;

import com.livrodb.livros.dtos.AutoresDto;
import com.livrodb.livros.models.AutoresModel;

import com.livrodb.livros.repository.AutoresRepo;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    @GetMapping("/autor/{id}")
    public ResponseEntity<Object> getOneAutor(@PathVariable(value="id") UUID id){
        Optional<AutoresModel> autoresO = autRepo.findById(id);
        if(autoresO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Autor não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(autoresO.get());
    }
    @PutMapping("/autor/{id}")
    public ResponseEntity<Object> updateAutor(@PathVariable(value ="id") UUID id,
                                               @RequestBody @Valid AutoresDto autoresDto){
        Optional<AutoresModel> autoresO = autRepo.findById(id);
        if(autoresO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado.");
        }
        var autoresModel = autoresO.get();
        BeanUtils.copyProperties(autoresDto, autoresModel);
        return ResponseEntity.status(HttpStatus.OK).body(autRepo.save(autoresModel));
    }
    @DeleteMapping("/autor/{id}")
    public ResponseEntity<Object> delAutores(@PathVariable(value="id") UUID id){
        Optional<AutoresModel> autoresO = autRepo.findById(id);
        if(autoresO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado.");
        }
        autRepo.delete(autoresO.get());
        return ResponseEntity.status(HttpStatus.OK).body(autoresO.get());
    }
}
