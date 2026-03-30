package com.senai.api.controllers;

import com.senai.api.dtos.UsuarioDto;
import com.senai.api.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    //--Insjeção de dependencia
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/usuario")
    public ResponseEntity<String> cadastrar(@RequestBody UsuarioDto usuarioDto){

        boolean retorno = service.cadastrar(usuarioDto);
        if (retorno) {
            return ResponseEntity.ok().body("Cadastrado com sucesso");
        } else {
            return ResponseEntity.badRequest().body("Já existe este login cadastrado!");
        }
    }

    @PutMapping("/usuario/{cpf}")
    public ResponseEntity<String> atualizar(@RequestBody UsuarioDto usuarioDto, @PathVariable String cpf){

        boolean retorno = service.atualizar(cpf, usuarioDto);

        if (retorno) {
            return ResponseEntity.ok().body("Atualizado com sucesso");
        } else {
            return ResponseEntity.badRequest().body("Já existe este login cadastrado!");
        }

    }


}
