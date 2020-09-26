package data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author FelipeLiberio <felipeldossantos@gmail.com>
 *
 */
public class Log {

    public void atualizarLog(String usuario, String registro) throws IOException {
        LocalDateTime agora = LocalDateTime.now();

        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");
        String hoje = formatterData.format(agora);

        DateTimeFormatter formatterDataDia = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String dia = formatterDataDia.format(agora);

        String log = String.format("%-20s -> %s - %s", registro, usuario, hoje);
        System.out.println(log);

        registrarlog(log, dia);
    }

    private void registrarlog(String log, String dia) throws IOException {

        String nomeArquivo = String.format("%s.txt", dia).replaceAll("/", "-");

        try (
            FileWriter writer = new FileWriter(String.format("build/classes/data/logs/%s", nomeArquivo), true); BufferedWriter bw = new BufferedWriter(writer)) {

            bw.write(log);
            bw.newLine();

        }
    }
}
