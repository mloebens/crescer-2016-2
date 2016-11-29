package br.com.cwi.crescer.aula3.DAO;

import br.com.cwi.crescer.aula3.Entity.Servico;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author maicon.loebens
 */
public class ServicoDao implements IDAO<Servico, Long> {
        private final EntityManager entityManager;
        
    public ServicoDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    @Override
    public void insert(Servico pessoa) {
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
    public void delete(Servico pessoa) {
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
    public Servico find(Long id) {
        final Servico pessoa = entityManager.find(Servico.class, id);     
        return pessoa;
    }

    @Override
    public List<Servico> findAll() {
        return entityManager.createQuery("select p from Servico p").getResultList();
    }
}
