package br.com.cwi.crescer.filme.DAO;

import br.com.cwi.crescer.filme.Entity.Elenco;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Carlos H. Nonnemacher
 */
@Stateless
public class ClassificacaoBean extends AbstractDao<Elenco, Long>{

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public ClassificacaoBean() {
        super(Elenco.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Elenco> findAll() {
        return this.getEntityManager().createQuery("select p from Elenco p").getResultList();
    } 
}
