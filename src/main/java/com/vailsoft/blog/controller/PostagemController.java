package com.vailsoft.blog.controller;

import com.vailsoft.blog.model.Postagem;
import com.vailsoft.blog.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {
    @Autowired
    private PostagemRepository repository;

    @GetMapping
    public ResponseEntity<List<Postagem>> GetAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postagem> GetById(@PathVariable Long id){
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }
}



