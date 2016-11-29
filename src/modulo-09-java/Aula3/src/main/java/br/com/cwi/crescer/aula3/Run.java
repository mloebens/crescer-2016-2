package br.com.cwi.crescer.aula3;

import br.com.cwi.crescer.aula3.DAO.ServicoDao;
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

        Exportador exp = new Exportador(entityManager);
        exp.exportarServico();

        entityManager.close();
        entityManagerFactory.close();
    }
}
