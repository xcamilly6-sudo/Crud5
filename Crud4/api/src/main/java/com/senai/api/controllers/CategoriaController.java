package com.senai.api.controllers;

import com.senai.api.dtos.CategoriaDto;
import com.senai.api.dtos.ProdutoDtos;
import com.senai.api.entities.CategoriaEntity;
import com.senai.api.entities.ProdutoEntity;
import com.senai.api.services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping()
public class CategoriaController {

    private final ProdutoService service;

    public CategoriaController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping("/categorias")
    public CategoriaEntity<String> categorias(@RequestBody CategoriaDto categoriaDto) {
        String categorias = service.categorias(categoriaDto);
        if (categorias == null || categorias.startsWith("Erro")) return CategoriaEntity.badRequest().body(categorias);
        return CategoriaEntity.ok().body(categorias);
    }

    @GetMapping("/categorias")
    public CategoriaEntity<List<CategoriaDto>> listaCategoria(){

        List<CategoriaDto> produto = service.listaCategoria();
        return CategoriaEntity.ok().body(produto);

    }
}
