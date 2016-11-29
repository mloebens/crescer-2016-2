package br.com.cwi.crescer.aula3;

import br.com.cwi.crescer.aula3.DAO.ServicoDao;
import br.com.cwi.crescer.aula3.Entity.Servico;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Máicon Loebens
 */
public class Exportador {

    final EntityManager entityManager;

    public Exportador(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void exportarServico() {
        final List<Servico> servicos = new ServicoDao(entityManager).list();
        final String cabecalho = "idServico;dsDescricao;dsPeriodicidade;dsSimboloMoeda;dsSituacao;dsWebsite;nmServico;vlMensalUSD;vlTotalServico;usuarioIdUsuario";
        
        if (servicos != null) {
            final String nomeArquivo = "servico.csv";

            try (
                    Writer writer = new FileWriter(nomeArquivo);
                    BufferedWriter bufferedWriter = new BufferedWriter(writer);) {
                
                bufferedWriter.append(cabecalho);
                bufferedWriter.newLine();
                for (Servico servico : servicos) {
                    bufferedWriter.append(servico.toCSV());
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
