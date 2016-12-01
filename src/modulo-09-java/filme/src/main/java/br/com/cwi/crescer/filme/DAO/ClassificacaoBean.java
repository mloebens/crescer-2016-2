package br.com.cwi.crescer.filme.DAO;

import br.com.cwi.crescer.filme.Entity.Classificacao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Carlos H. Nonnemacher
 */
@Stateless
public class ClassificacaoBean extends AbstractDao<Classificacao, Long>{

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public ClassificacaoBean() {
        super(Classificacao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Classificacao> findAll() {
        return this.getEntityManager().createQuery("select p from Classificacao p").getResultList();
    } 
}
