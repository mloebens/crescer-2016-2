package br.com.cwi.crescer.aula3.DAO;

import br.com.cwi.crescer.aula3.Entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author maicon.loebens
 */
public class UsuarioDao implements IDAO<Usuario, Long> {
        private final EntityManager entityManager;
        
    public UsuarioDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    @Override
    public void insert(Usuario pessoa) {
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
    public void delete(Usuario pessoa) {
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
    public Usuario find(Long id) {
        final Usuario pessoa = entityManager.find(Usuario.class, id);     
        return pessoa;
    }

    @Override
    public List<Usuario> findAll() {
        return entityManager.createQuery("select p from Usuario p").getResultList();
    }

}
