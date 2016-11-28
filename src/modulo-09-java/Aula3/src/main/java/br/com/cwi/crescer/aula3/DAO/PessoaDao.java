package br.com.cwi.crescer.aula3.DAO;

import br.com.cwi.crescer.aula3.Entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author maicon.loebens
 */
public class PessoaDao implements IDAO<Pessoa, Long> {
        private final EntityManager entityManager;
        
    public PessoaDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    @Override
    public void insert(Pessoa pessoa) {
        if (entityManager.isOpen()) {
            entityManager.getTransaction().begin();
            try {
                entityManager.persist(pessoa);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
            } 
        }
    }

    @Override
    public void delete(Pessoa pessoa) {
        if (entityManager.isOpen()) {
            entityManager.getTransaction().begin();
            try {
                entityManager.remove(pessoa);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
            } 
        }
    }

    @Override
    public Pessoa find(Long id) {
        final Pessoa pessoa = entityManager.find(Pessoa.class, id);     
        return pessoa;
    }

    @Override
    public List<Pessoa> findAll() {
        return entityManager.createQuery("select p from Pessoa p").getResultList();
    }

}
