package br.com.cwi.crescer.aula5.dao;

import br.com.cwi.crescer.aula5.entity.Usuario;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class UsuarioDao extends AbstractDao<Usuario, Long> {

    final EntityManager entityManager;

    public UsuarioDao(EntityManager entityManager) {
        super(Usuario.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Usuario findByEmail(String email) {
        Object resultado = null;
        try {
            resultado = entityManager.createQuery("select u from Usuario u where u.email = :email").setParameter("email", email).getSingleResult();
        } catch (NoResultException e) {
                //implementar erro
        }
        return (Usuario) resultado;
    }

}
