package domain;

import data.Log;
import data.RepositorioDeUsuarios;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author FelipeLiberio <felipeldossantos@gmail.com>
 *
 */
public class EfetuarLogin {
    Log logger = new Log();
    public Usuario autenticar(String login, String senha) throws IOException, ParseException{
        RepositorioDeUsuarios db = new RepositorioDeUsuarios();
        //Usuario usuario = db.recuperarUsuarioPorLogin(login);
        Usuario usuario = db.recuperarUsuarioJSON(login);
        
        if (usuario!=null) {
            boolean senhasConferem = usuario.getSenha().equals(senha);
            if (senhasConferem) {
                logger.atualizarLog(login, "Login");
                return usuario;
            }
        }
        
        return null;
    }
}
