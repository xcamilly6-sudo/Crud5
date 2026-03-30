package com.senai.api.services;

import com.senai.api.dtos.UsuarioDto;
import com.senai.api.entities.UsuarioEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private List<UsuarioEntity> listaUsuario = new ArrayList<UsuarioEntity>();

    public boolean cadastrar(UsuarioDto usuarioDto){

        //--Validar se o logi já existe
        for (UsuarioEntity usuario : listaUsuario){
            if (usuario.getLogin().equals(usuarioDto.getLogin())){
                //--Se já existe, retorna para o controller como false
                return false;
            }
        }

        UsuarioEntity usuario = new UsuarioEntity();

        //--Converter dados do DTO para o ENTITY
        usuario.setCpf(usuarioDto.getCpf());
        usuario.setNome(usuarioDto.getNome());
        usuario.setLogin(usuarioDto.getLogin());
        usuario.setSenha(usuarioDto.getSenha());

        listaUsuario.add(usuario);

        //--Se chegou até aqui significa que o usuário foi inserido com sucesso!
        return true;
    }

    public boolean atualizar(String cpf, UsuarioDto usuarioDto){

        //-- validar se o login (dentro de usuarioDto) já não existe na lista
        //-- se já houver este login na lista, retorna false

        //--Percorre a lista de usuários
        for (UsuarioEntity usuario : listaUsuario){
            if (usuario.getLogin().equals(usuarioDto.getLogin())){
                //-- ! é para negar a condição invertendo o sentido da sentença
                if (!usuario.getCpf().equals(cpf)) {
                    return false;
                }
            }
        }

        //--localizar o usuário por cpf e realizar a atualização de dados
        for (UsuarioEntity usuario : listaUsuario){
           if (usuario.getCpf().equals(cpf)) {
                //--Atualizar os valores do usuário
               usuario.setCpf(usuarioDto.getCpf());
               usuario.setNome(usuarioDto.getNome());
               usuario.setLogin(usuarioDto.getLogin());
               usuario.setSenha(usuarioDto.getSenha());
               return true;
           }
        }

        //--retornar verdadeiro, pois chegou até aqui então deu certo!
        return true;
    }
}
