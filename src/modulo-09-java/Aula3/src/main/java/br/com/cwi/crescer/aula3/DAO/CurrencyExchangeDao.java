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
    public void insert(CurrencyExchange currencyExchange) {
        if (entityManager.isOpen()) {
            entityManager.getTransaction().begin();
            try {
                entityManager.persist(currencyExchange);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
            } 
        }
    }

    @Override
    public void delete(CurrencyExchange currencyExchange) {
        if (entityManager.isOpen()) {
            entityManager.getTransaction().begin();
            try {
                entityManager.remove(currencyExchange);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
            } 
        }
    }

    @Override
    public CurrencyExchange find(Long id) {
        final CurrencyExchange currencyExchange = entityManager.find(CurrencyExchange.class, id);     
        return currencyExchange;
    }

    @Override
    public List<CurrencyExchange> list() {
        return entityManager.createQuery("select p from CurrencyExchange p").getResultList();
    }
}
