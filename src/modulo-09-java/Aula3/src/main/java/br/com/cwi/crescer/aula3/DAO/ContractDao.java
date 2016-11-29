package br.com.cwi.crescer.aula3.DAO;

import br.com.cwi.crescer.aula3.Entity.Contract;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author maicon.loebens
 */
public class ContractDao implements IDAO<Contract, Long> {
        private final EntityManager entityManager;
        
    public ContractDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    @Override
    public void insert(Contract pessoa) {
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
    public void delete(Contract pessoa) {
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
    public Contract find(Long id) {
        final Contract pessoa = entityManager.find(Contract.class, id);     
        return pessoa;
    }

    @Override
    public List<Contract> findAll() {
        return entityManager.createQuery("select p from Contract p").getResultList();
    }

}
