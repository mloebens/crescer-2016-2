package br.com.cwi.crescer.aula3.DAO;

import br.com.cwi.crescer.aula3.Entity.Cotacao;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author maicon.loebens
 */
public class CotacaoDao implements IDAO<Cotacao, Long> {
        private final EntityManager entityManager;
        
    public CotacaoDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    @Override
    public void insert(Cotacao cotacao) {
        if (entityManager.isOpen()) {
            entityManager.getTransaction().begin();
            try {
                entityManager.persist(cotacao);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
            } 
        }
    }

    @Override
    public void delete(Cotacao cotacao) {
        if (entityManager.isOpen()) {
            entityManager.getTransaction().begin();
            try {
                entityManager.remove(cotacao);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
            } 
        }
    }

    @Override
    public Cotacao find(Long id) {
        final Cotacao cotacao = entityManager.find(Cotacao.class, id);     
        return cotacao;
    }

    @Override
    public List<Cotacao> list() {
        return entityManager.createQuery("select p from Cotacao p").getResultList();
    }

}
