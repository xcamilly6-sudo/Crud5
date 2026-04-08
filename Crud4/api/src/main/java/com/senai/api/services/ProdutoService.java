package com.senai.api.services;

import com.senai.api.dtos.CategoriaDto;
import com.senai.api.dtos.ProdutoDtos;
import com.senai.api.dtos.RespostaUsuarioDto;
import com.senai.api.entities.CategoriaEntity;
import com.senai.api.entities.ProdutoEntity;
import com.senai.api.entities.UsuarioEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private ArrayList<ProdutoEntity> produto = new ArrayList<ProdutoEntity>();
    private ArrayList<CategoriaEntity> categoria = new ArrayList<CategoriaEntity>();

    public String categorias(CategoriaDto categoriaDto){

        CategoriaEntity categorias = new CategoriaEntity();

        categorias.setId(categoriaDto.getId());
        categorias.setNomecat(categoriaDto.getNomecat());

        categoria.add(categorias);

        return "Usuario Cadastrado com sucesso!";
    }

    public List<CategoriaDto> listaCategoria(){

        List<CategoriaDto> resposta = new ArrayList<>();

        for (CategoriaEntity u : categoria) {
            CategoriaDto dto = new CategoriaDto(
                    u.getId();
                    u.getNomecat();
            );
            resposta.add(dto);
        }

        return resposta;

    }

}
