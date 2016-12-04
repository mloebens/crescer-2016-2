package br.com.cwi.crescer.aula4;

import br.com.cwi.crescer.aula5.dao.UsuarioDao;
import br.com.cwi.crescer.aula5.entity.Usuario;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * @author carloshenrique
 */
public class UsuarioDaoTest extends AbstractDaoTest {
    
    private UsuarioDao usuarioDao;
    
    @Before
    public void setBefore() {
        this.usuarioDao = new UsuarioDao(this.getEntityManager());
        final Usuario usuario = new Usuario();
        usuario.setEmail("teste@teste.com");
        usuario.setNome("teste");
        usuario.setSenha("teste");
        this.usuarioDao.insert(usuario);
    }

    /**
     * Test of findAll method, of class UsuarioDao.
     */
    @Test
    public void testFindByEmail() {
        
        Usuario usuario = this.usuarioDao.findByEmail("teste@teste.com");
        Assert.assertNotNull(usuario);
        Assert.assertEquals("teste", usuario.getNome());
        Assert.assertEquals("teste", usuario.getSenha());
    }
    
}
