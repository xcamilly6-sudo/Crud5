package com.senai.api.controllers;

import com.senai.api.dtos.RespostaUsuarioDto;
import com.senai.api.dtos.UsuarioDto;
import com.senai.api.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {


    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }


    @PostMapping("/usuario")
    public ResponseEntity<String> cadastrar(@RequestBody UsuarioDto usuarioDto) {
        String resposta = service.cadastrar(usuarioDto);

        if (resposta == null || resposta.startsWith("Erro")) {
            return ResponseEntity.badRequest().body(resposta);
        }

        return ResponseEntity.ok().body(resposta);
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<RespostaUsuarioDto>> listarUsuarios() {
        List<RespostaUsuarioDto> usuarios = service.listarUsuarios();
        return ResponseEntity.ok().body(usuarios);
    }

    @GetMapping("/usuario/{cpf}")
    public ResponseEntity<?> buscarUsuarioPorCpf(@PathVariable String cpf) {
        RespostaUsuarioDto usuario = service.buscarUsuarioPorCpf(cpf);

        if (usuario == null) {
            return ResponseEntity.status(404).body("Usuário com CPF '" + cpf + "' não encontrado.");
        }

        return ResponseEntity.ok().body(usuario);
    }

    @PutMapping("/usuario/{cpf}")
    public ResponseEntity<String> atualizarUsuario(@PathVariable String cpf, @RequestBody UsuarioDto usuarioDto) {
        String resposta = service.atualizarUsuario(cpf, usuarioDto);

        if (resposta.startsWith("Erro")) {
            return ResponseEntity.badRequest().body(resposta);
        }

        return ResponseEntity.ok().body(resposta);
    }

    @DeleteMapping("/usuario/{cpf}")
    public ResponseEntity<String> removerUsuario(@PathVariable String cpf) {
        String resposta = service.removerUsuario(cpf);

        if (resposta.startsWith("Erro")) {
            return ResponseEntity.status(404).body(resposta);
        }

        return ResponseEntity.ok().body(resposta);
    }
}