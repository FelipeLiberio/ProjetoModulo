package domain;

/**
 *
 * @author FelipeLiberio <felipeldossantos@gmail.com>
 *
 */
public class Usuario {
    private String nome;
    private String usuario;
    private String senha;
    private String funcao;

    public Usuario(String nome, String usuario, String senha, String funcao) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.funcao = funcao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
