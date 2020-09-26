/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import data.Log;
import data.RepositorioDeUsuarios;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author @author FelipeLiberio <felipeldossantos@gmail.com>
 */
public class AlterarExcluirCadastrarUsuario {

    Log logger = new Log();
    RepositorioDeUsuarios db;
    Usuario user;

    public AlterarExcluirCadastrarUsuario() throws IOException {
        this.db = new RepositorioDeUsuarios();
    }

    public boolean verificarExistencia(String login) throws IOException, ParseException {
        user = db.recuperarUsuarioJSON(login);
        return user != null;
    }

    public void cadastrarNovoUsuario(String responsavel, String nome, String login, String senha, String function) throws IOException {
        user = new Usuario(nome, login, senha, function);
        logger.atualizarLog(responsavel, "Cadastro usuario "+login);
        db.adicionarUsuario(user);        
    }
    public boolean validarSenha(String senha){
        return senha.length()>=8 && senha.length()<16;
    }
    public void excluirUsuario(String loginAExcluir ) throws IOException, ParseException{
        user = db.recuperarUsuarioJSON(loginAExcluir);
        db.excluirUsuario(user);
    } 

}
