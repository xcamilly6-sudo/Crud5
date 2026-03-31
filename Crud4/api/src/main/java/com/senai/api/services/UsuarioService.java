package com.senai.api.services;

import com.senai.api.dtos.LoginDto;
import com.senai.api.dtos.RespostaUsuarioDto;
import com.senai.api.dtos.UsuarioDto;
import com.senai.api.entities.UsuarioEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private ArrayList<UsuarioEntity> usuarios = new ArrayList<UsuarioEntity>();

    public String cadastrar(UsuarioDto usuarioDto) {

        UsuarioEntity usuario = new UsuarioEntity();

        usuario.setCpf(usuarioDto.getCpf());
        usuario.setLogin(usuarioDto.getLogin());
        usuario.setNome(usuarioDto.getNome());
        usuario.setSenha(usuarioDto.getSenha());

        usuarios.add(usuario);

        return "Usuario Cadastrado com sucesso!";
    }

    public List<RespostaUsuarioDto> listarUsuarios() {

        List<RespostaUsuarioDto> resposta = new ArrayList<>();

        for (UsuarioEntity u : usuarios) {
            RespostaUsuarioDto dto = new RespostaUsuarioDto(
                    u.getCpf(),
                    u.getNome(),
                    u.getLogin()
            );
            resposta.add(dto);
        }

        return resposta;
    }

    public RespostaUsuarioDto buscarUsuarioPorCpf(String cpf) {

        for (UsuarioEntity u : usuarios) {
            if (u.getCpf().equals(cpf)) {
                return new RespostaUsuarioDto(u.getCpf(), u.getNome(), u.getLogin());
            }
        }

        return null;
    }

    public String atualizarUsuario(String cpf, UsuarioDto usuarioDto) {

        for (UsuarioEntity u : usuarios) {
            if (u.getLogin().equalsIgnoreCase(usuarioDto.getLogin()) && !u.getCpf().equals(cpf)) {
                return "Erro: já existe um usuário com o login:" + usuarioDto.getLogin() + ".";
            }
        }

        for (UsuarioEntity u : usuarios) {
            if (u.getCpf().equals(cpf)) {
                u.setNome(usuarioDto.getNome());
                u.setLogin(usuarioDto.getLogin());
                u.setSenha(usuarioDto.getSenha());
                return "Usuário atualizado com sucesso!";
            }
        }

        return "Erro: usuário com CPF: " + cpf + " não foi encontrado.";
    }

    public String removerUsuario(String cpf) {

        for (UsuarioEntity u : usuarios) {
            if (u.getCpf().equals(cpf)) {
                usuarios.remove(u);
                return "Usuário removido com sucesso!";
            }
        }

        return "Erro: usuário com CPF '" + cpf + "' não encontrado.";
    }

    public String login( UsuarioDto usuarioDto) {

        for (UsuarioEntity u : usuarios) {
            if (u.getLogin().equals(usuarioDto)) {
                usuarios.isEmpty();
                return "Autenticação bem-sucedida ";
            }
            return"ERRO: Login não valido!";


        }
        for (UsuarioEntity i : usuarios) {
            if (i.getSenha().equals(usuarioDto)) {
                usuarios.isEmpty();
                return "Autenticação bem-sucedida ";
            }
            return "ERRO: Senha incorreta";
        }
        return "Autenticação bem-sucedida ";
    }





}