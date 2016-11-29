package br.com.cwi.crescer.aula3;

import br.com.cwi.crescer.aula3.DAO.ServicoDao;
import br.com.cwi.crescer.aula3.DAO.UsuarioDao;
import br.com.cwi.crescer.aula3.Entity.Servico;
import br.com.cwi.crescer.aula3.Entity.Usuario;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author maicon.loebens
 */
public class Run {
    
    public static void main(String[] args) {
        // Criando um EntityManager
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        //UsuarioDao usuarioDao = new UsuarioDao(entityManager);
        ServicoDao servicoDao = new ServicoDao(entityManager);
        
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(26l);
        usuario.setDsEmail("teste");
        usuario.setDsSenha("teste");
        usuario.setDsSituacao("teste");
        usuario.setDsUserName("teste");
        usuario.setNmUsuario("teste");
        usuario.setTpPermissao("teste");
        //usuarioDao.insert(usuario);
        
        Servico servico = new Servico();
        servico.setDsDescricao("teste");
        servico.setDsPeriodicidade("teste");
        servico.setDsSimboloMoeda("teste");
        servico.setDsSituacao("teste");
        servico.setDsWebsite("teste");
        servico.setVlMensalUSD(BigDecimal.TEN);
        servico.setVlTotalServico(BigDecimal.ZERO);
        servico.setNmServico("teste");
        servico.setUsuario(usuario);
        
        servicoDao.insert(servico);
        
        entityManager.close();
        entityManagerFactory.close();
    }
}
