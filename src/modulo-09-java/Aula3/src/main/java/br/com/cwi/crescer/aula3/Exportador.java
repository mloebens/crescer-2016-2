package br.com.cwi.crescer.aula3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 *
 * @author Máicon Loebens
 */
public class Exportador {

    public void exportarCSV(List<String> dados) {
       
        if (dados != null) {
            final String nomeArquivo = "exportacao.csv";
            try (
                    Writer writer = new FileWriter(nomeArquivo);
                    BufferedWriter bufferedWriter = new BufferedWriter(writer);) {
                
                for (String valor : dados) {
                    bufferedWriter.append(valor);
                    bufferedWriter.newLine();
                }

                new File(nomeArquivo).createNewFile();
                bufferedWriter.flush();
            } catch (IOException ex) {
                System.out.println("Não foi possível gravar o arquivo.");
            }
        } else {
            System.out.println("Nenhum registro encontrado");
        }
    }
}