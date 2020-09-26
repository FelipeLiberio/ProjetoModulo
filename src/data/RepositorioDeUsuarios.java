package data;

import domain.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

/**
 *
 * @author FelipeLiberio <felipeldossantos@gmail.com>
 *
 */
public class RepositorioDeUsuarios {

    public Usuario recuperarUsuarioJSON(String login) throws IOException, ParseException {
        org.json.JSONArray ja;

        try {
            java.io.BufferedReader br = new BufferedReader(new FileReader("Build/Classes/data/Usuarios.json"));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb = sb.append(line);
            }
            br.close();

            ja = new org.json.JSONArray(sb.toString());

            for (int x = 0; x < ja.length(); x++) {
                org.json.JSONObject ob = ja.getJSONObject(x);
                String nome = ob.getString("nome");
                String usuario = ob.getString("login");
                String senha = ob.getString("senha");
                String funcao = ob.getString("função");

                if (ob.getString("login").equals(login)) {
                    Usuario user = new Usuario(nome, usuario, senha, funcao);
                    return user;
                }
            }

        } catch (IOException | JSONException e) {
        }

        return null;
    }

//    public Usuario recuperarUsuarioPorLogin(String login) {
//        return usuarios.get(login);
//    }
    public void excluirUsuario(Usuario user) throws FileNotFoundException, IOException {
        org.json.JSONArray ja;
        org.json.JSONArray jaAtualizado;
        StringBuilder sb;
        try (java.io.BufferedReader br = new BufferedReader(new FileReader("Build/Classes/data/Usuarios.json"))) {
            sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb = sb.append(line);
            }
        }
        
        ja = new org.json.JSONArray(sb.toString());
        jaAtualizado = new org.json.JSONArray();
        for (int i = 0; i < ja.length(); i++) {
            if (!ja.getJSONObject(i).get("login").equals(user.getUsuario())) {

                jaAtualizado.put(ja.get(i));
            }
        }
        try (
            FileWriter writer = new FileWriter("Build/Classes/data/Usuarios.json", false); BufferedWriter bw = new BufferedWriter(writer)) {

            bw.write(jaAtualizado.toString());
            bw.newLine();
            bw.close();
        }
    }

    public void adicionarUsuario(Usuario user) throws FileNotFoundException, IOException {
        org.json.JSONArray ja;

        java.io.BufferedReader br = new BufferedReader(new FileReader("Build/Classes/data/Usuarios.json"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb = sb.append(line);
        }
        br.close();

        ja = new org.json.JSONArray(sb.toString());

        JSONObject jOb = new JSONObject();

        jOb.put("nome", user.getNome());
        jOb.put("login", user.getUsuario());
        jOb.put("senha", user.getSenha());
        jOb.put("função", user.getFuncao());

        ja.put(jOb);

        try (
            FileWriter writer = new FileWriter("Build/Classes/data/Usuarios.json", false); BufferedWriter bw = new BufferedWriter(writer)) {

            bw.write(ja.toString());
            bw.newLine();
            bw.close();
        }
    }
}
