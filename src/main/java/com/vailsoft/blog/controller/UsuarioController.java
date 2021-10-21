package com.vailsoft.blog.controller;

import com.vailsoft.blog.model.UserLogin;
import com.vailsoft.blog.model.Usuario;
import com.vailsoft.blog.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/logar")
    public ResponseEntity<UserLogin> autentication(@RequestBody Optional<UserLogin> user){
        return usuarioService.logar(user).map(resp->ResponseEntity.ok(resp))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario>post(@RequestBody Usuario usuario){
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioService.cadastraUsuario(usuario));
    }


}
