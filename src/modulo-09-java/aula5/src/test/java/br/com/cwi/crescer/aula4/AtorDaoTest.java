package br.com.cwi.crescer.aula4;

import br.com.cwi.crescer.aula5.dao.AtorDao;
import br.com.cwi.crescer.aula5.entity.Ator;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * @author carloshenrique
 */
public class AtorDaoTest extends AbstractDaoTest {

    private AtorDao atorDao;

    @Before
    public void setBefore() {
        this.atorDao = new AtorDao(this.getEntityManager());
        final Ator ator = new Ator();
        final Ator ator2 = new Ator();
        ator.setNome("ator1");
        ator2.setNome("ator2");
        this.atorDao.insert(ator);
        this.atorDao.insert(ator2);
    }

    @Test
    public void testInsertAtor() {
        final Ator atorNovo = new Ator();
        atorNovo.setNome("ator3");
        this.atorDao.insert(atorNovo);
        Ator ator = this.atorDao.find(3l);
        Assert.assertNotNull(ator);
        Assert.assertEquals("ator3", ator.getNome());
    }
    
    @Test
    public void testDeleteAtor(){
        Ator ator = this.atorDao.find(1l);
        this.atorDao.delete(ator);
        Assert.assertNull(this.atorDao.find(1l));
    }
}
