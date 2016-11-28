package br.com.cwi.crescer.aula3;

import br.com.cwi.crescer.aula3.DAO.PessoaDao;
import br.com.cwi.crescer.aula3.Entity.Pessoa;
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

        final PessoaDao pessoaDao = new PessoaDao(entityManager);

        final Pessoa pessoa = new Pessoa();
        pessoa.setNmPessoa("Máicon");
        pessoaDao.insert(pessoa);
        pessoaDao.findAll().forEach(p -> System.out.println(p.getNmPessoa()));

        /*
        if (entityManager.isOpen()) {
            entityManager.getTransaction().begin();
            try {
                final Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(1l);
                pessoa.setNmPessoa("Máicon Loebens");

                entityManager.persist(pessoa);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                entityManager.getTransaction().rollback();
            }
        }
        
        final Pessoa pessoa = entityManager.find(Pessoa.class, 1l);
        System.out.println(pessoa.getNmPessoa());
         */
        entityManager.close();
        entityManagerFactory.close();
    }
}
