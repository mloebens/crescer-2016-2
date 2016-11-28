package br.com.cwi.crescer.aula2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Máicon Loebens
 */
public class MeuReaderUtils {

    public void exibirConteudo(String nome) {
        File arquivo = new File(nome);
        if (arquivo.exists()) {
            boolean ehTxt = nome.contains(".txt");
            if (ehTxt) {
                try {
                    Files.readAllLines(Paths.get(nome)).forEach(System.out::println);
                } catch (IOException ex) {
                    System.out.println("Erro ao ler o arquivo.");
                }
            } else {
                System.out.println("O arquivo é incompatível.");
            }
        } else {
            System.out.println("Arquivo não existe.");
        }
    }
}
