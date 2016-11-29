package br.com.cwi.crescer.aula3.DAO;

import br.com.cwi.crescer.aula3.Entity.CurrencyExchange;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author maicon.loebens
 */
public class CurrencyExchangeDao implements IDAO<CurrencyExchange, Long> {
        private final EntityManager entityManager;
        
    public CurrencyExchangeDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    @Override
    public void insert(CurrencyExchange pessoa) {
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
    public void delete(CurrencyExchange pessoa) {
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
    public CurrencyExchange find(Long id) {
        final CurrencyExchange pessoa = entityManager.find(CurrencyExchange.class, id);     
        return pessoa;
    }

    @Override
    public List<CurrencyExchange> findAll() {
        return entityManager.createQuery("select p from CurrencyExchange p").getResultList();
    }
}
