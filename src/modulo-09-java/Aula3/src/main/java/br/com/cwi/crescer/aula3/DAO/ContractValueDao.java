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
    public void insert(ContractValue pessoa) {
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
    public void delete(ContractValue pessoa) {
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
    public ContractValue find(Long id) {
        final ContractValue pessoa = entityManager.find(ContractValue.class, id);     
        return pessoa;
    }

    @Override
    public List<ContractValue> findAll() {
        return entityManager.createQuery("select p from ContractValue p").getResultList();
    }

}
