package com.senai.api.controllers;

import com.senai.api.dtos.LoginDto;
import com.senai.api.dtos.SenhaDto;
import com.senai.api.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping
public class LoginController {

    //injeção de dependencia
    private final UsuarioService service;

    public LoginController(UsuarioService service) {
        this.service=service;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {

        //-chamar metodo do service para realizar o login
        String respota;
        //respota = service.login(loginDto.getLogin());
        //String resposta = service.login(loginDto.getSenha());
        //return ResponseEntity.ok().body(respota);
return null;
    }

    @PutMapping("/senha{login}")
    public ResponseEntity<String> atualizar(@RequestBody SenhaDto senhaDto){


        return null;
    }

}
