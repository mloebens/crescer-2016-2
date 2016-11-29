package br.com.cwi.crescer.aula3.DAO;

import br.com.cwi.crescer.aula3.Entity.ContractValue;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author maicon.loebens
 */
public class ContractValueDao implements IDAO<ContractValue, Long> {
        private final EntityManager entityManager;
        
    public ContractValueDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    @Override
    public void insert(ContractValue contractValue) {
        if (entityManager.isOpen()) {
            entityManager.getTransaction().begin();
            try {
                entityManager.persist(contractValue);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
            } 
        }
    }

    @Override
    public void delete(ContractValue contractValue) {
        if (entityManager.isOpen()) {
            entityManager.getTransaction().begin();
            try {
                entityManager.remove(contractValue);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
            } 
        }
    }

    @Override
    public ContractValue find(Long id) {
        final ContractValue contractValue = entityManager.find(ContractValue.class, id);     
        return contractValue;
    }

    @Override
    public List<ContractValue> list() {
        return entityManager.createQuery("select p from ContractValue p").getResultList();
    }

}
