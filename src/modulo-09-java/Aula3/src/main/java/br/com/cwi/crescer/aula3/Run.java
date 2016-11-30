package br.com.cwi.crescer.aula3;

import br.com.cwi.crescer.aula3.DAO.ServicoDao;
import br.com.cwi.crescer.aula3.Entity.Servico;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author maicon.loebens
 */
public class Run {

    public static void main(String[] args) {
        // Criando um EntityManager
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        Exportador exp = new Exportador();
        ServicoDao servicoDao = new ServicoDao(entityManager);
        List<Servico> dados = servicoDao.list();
        if (dados.size() > 0) {
            List<String> dadosFormatados = new ArrayList<>();
            dadosFormatados.add(dados.get(0).toCabecalhoCSV());
            for (Servico dado : dados) {
                dadosFormatados.add(dado.toCSV());
            }
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
