package com.livrodb.livros.controllers;

import com.livrodb.livros.LivrosApplication;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.livrodb.livros.dtos.LivrosDto;
import com.livrodb.livros.models.LivrosModel;
import com.livrodb.livros.repository.LivrosRepo;
import java.util.List;
import java.util.Optional;

@RestController
public class LivrosController {
    @Autowired
    LivrosRepo livrosRepo;

    @PostMapping("/livros")
    public ResponseEntity<LivrosModel>  salvarLivro(@RequestBody @Valid LivrosDto livrosdto){
        var livrosmodel = new LivrosModel();
        BeanUtils.copyProperties(livrosdto, livrosmodel);
        return ResponseEntity.status(HttpStatus.CREATED).body(livrosRepo.save(livrosmodel));
    }
    @GetMapping("/livros")
    public ResponseEntity<List<LivrosModel>> getAllLivros(){
        return ResponseEntity.status(HttpStatus.OK).body(livrosRepo.findAll());
    }
    @GetMapping("/livros/{id}")
    public ResponseEntity<Object> getOneLivros(@PathVariable(value="id") Long id){
        Optional<LivrosModel> livrosO = livrosRepo.findById(id);
        if(livrosO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(livrosO.get());
    }
    @PutMapping("/livros/{id}")
    public ResponseEntity<Object> updateLivros(@PathVariable(value ="id") Long id,
                                               @RequestBody @Valid LivrosDto livrosDto){
        Optional<LivrosModel> livrosO = livrosRepo.findById(id);
        if(livrosO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado.");
        }
        var livrosModel = livrosO.get();
        BeanUtils.copyProperties(livrosDto, livrosModel);
        return ResponseEntity.status(HttpStatus.OK).body(livrosRepo.save(livrosModel));
    }
    @DeleteMapping("/livros/{id}")
    public ResponseEntity<Object> delLivros(@PathVariable(value="id") Long id){
        Optional<LivrosModel> livrosO = livrosRepo.findById(id);
        if(livrosO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado.");
        }
        livrosRepo.delete(livrosO.get());
        return ResponseEntity.status(HttpStatus.OK).body(livrosO.get());
    }

}