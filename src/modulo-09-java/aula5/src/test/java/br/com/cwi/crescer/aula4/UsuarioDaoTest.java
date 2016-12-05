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
        final Usuario usuario2 = new Usuario();
        usuario.setEmail("teste@teste.com");
        usuario.setNome("teste");
        usuario.setSenha("teste");
        usuario2.setEmail("seila@teste.com");
        usuario2.setNome("mloebens");
        usuario2.setSenha("mloebens");
        this.usuarioDao.insert(usuario);
        this.usuarioDao.insert(usuario2);
    }

    @Test
    public void testInsertUsuario() {
        final Usuario usuarioNovo = new Usuario();
        usuarioNovo.setEmail("teste2@teste.com");
        usuarioNovo.setNome("teste2");
        usuarioNovo.setSenha("teste2");
        this.usuarioDao.insert(usuarioNovo);
        Usuario usuario = this.usuarioDao.findByEmail("teste2@teste.com");
        Assert.assertNotNull(usuario);
        Assert.assertEquals("teste2", usuario.getNome());
        Assert.assertEquals("teste2", usuario.getSenha());
    }
    
    @Test
    public void testDeleteUsuario(){
        Usuario usuario = this.usuarioDao.find(1l);
        this.usuarioDao.delete(usuario);
        Assert.assertNull(this.usuarioDao.find(1l));
    }
    
    @Test
    public void testFindUsuarioByEmail() {
        Usuario usuario = this.usuarioDao.findByEmail("teste@teste.com");
        Assert.assertNotNull(usuario);
        Assert.assertEquals("teste", usuario.getNome());
        Assert.assertEquals("teste", usuario.getSenha());
    }

}
