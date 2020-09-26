package domain;

import java.util.HashMap;
import java.util.Map;
import present.admin.TelaAdmin;
import present.gerente.TelaGerente;
import present.vendas.TelaVendas;

/**
 *
 * @author FelipeLiberio <felipeldossantos@gmail.com>
 *
 */
public class InicializadorTelas {
    
    public void inicializarTela(Usuario user){
        String função = user.getFuncao().toUpperCase();
        Map<String, Runnable> telas = new HashMap<>();
        
        telas.put("ADMIN",() -> inicializarTelaAdmin(user));
        telas.put("VENDEDOR",() -> inicializarTelaVendedor(user));
        telas.put("GERENTE",() -> inicializarTelaGerente(user));

        telas.get(função).run();
        
    }

    private void inicializarTelaAdmin(Usuario user) {
        TelaAdmin tela = new TelaAdmin(user);
        tela.setVisible(true);
    }

    private void inicializarTelaVendedor(Usuario user) {
        TelaVendas tela = new TelaVendas();
        tela.setVisible(true);
    }

    private void inicializarTelaGerente(Usuario user) {
        TelaGerente tela = new TelaGerente();
        tela.setVisible(true);
    }
}
