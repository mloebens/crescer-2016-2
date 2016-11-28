package br.com.cwi.crescer.aula2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Máicon Loebens
 */
public class MeuWriterUtils {

    public static void main(String[] args) {
        List<String> lista = Arrays.asList("teste", "teste1", "testeds3");
        new MeuWriterUtils().gravarArquivo("teste.txt", lista);
    }

    public void gravarArquivo(String nome, List<String> conteudo) {
        File arquivo = new File(nome);
        if (arquivo.exists()) {
            boolean ehTxt = nome.contains(".txt");
            if (ehTxt) {
                try (
                        Writer writer = new FileWriter(nome, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(writer);
                     ){
                      for(String linha : conteudo){
                          bufferedWriter.append(linha);
                          bufferedWriter.newLine();
                          
                      }
                      bufferedWriter.flush();
                } catch (IOException ex) {
                    System.out.println("Não foi possível gravar o arquivo.");
                }
            } else {
                System.out.println("O arquivo é incompatível.");
            }
        } else {
            System.out.println("Arquivo não existe.");
        }
    }
}
