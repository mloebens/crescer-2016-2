package br.com.cwi.crescer.aula4;

import br.com.cwi.crescer.aula5.dao.ClassificacaoDao;
import br.com.cwi.crescer.aula5.entity.Classificacao;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * @author carloshenrique
 */
public class ClassificacaoDaoTest extends AbstractDaoTest {

    private ClassificacaoDao classificacaoDao;

    @Before
    public void setBefore() {
        this.classificacaoDao = new ClassificacaoDao(this.getEntityManager());
        final Classificacao classificacao = new Classificacao();
        final Classificacao classificacao2 = new Classificacao();
        classificacao.setDescricao("18 anos");
        classificacao.setIdade(18);
        classificacao.setDescricao("Livre");
        classificacao.setIdade(0);
        this.classificacaoDao.insert(classificacao);
        this.classificacaoDao.insert(classificacao2);
    }

    @Test
    public void testInsertClassificacao() {
        final Classificacao classificacaoNovo = new Classificacao();
        classificacaoNovo.setDescricao("16 anos");
        classificacaoNovo.setIdade(16);
        this.classificacaoDao.insert(classificacaoNovo);
        Classificacao classificacao = this.classificacaoDao.find(3l);
        Assert.assertNotNull(classificacao);
        Assert.assertTrue(16 == classificacao.getIdade());
    }
    
    @Test
    public void testDeleteClassificacao(){
        Classificacao classificacao = this.classificacaoDao.find(1l);
        this.classificacaoDao.delete(classificacao);
        Assert.assertNull(this.classificacaoDao.find(1l));
    }
}
