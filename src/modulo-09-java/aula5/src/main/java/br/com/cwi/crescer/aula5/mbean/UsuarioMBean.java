package br.com.cwi.crescer.aula5.mbean;

import br.com.cwi.crescer.aula5.bean.UsuarioBean;
import br.com.cwi.crescer.aula5.dao.UsuarioDao;
import br.com.cwi.crescer.aula5.entity.Usuario;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Carlos H. Nonnemacher
 */
@ManagedBean
@ViewScoped
public class UsuarioMBean extends AbstractMBean<Usuario, Long, UsuarioDao, UsuarioBean> {

    @EJB
    private UsuarioBean usuarioBean;

    @PostConstruct
    public void init() {
        this.limpar();
    }
    
    @Override
    public UsuarioBean getBean() {
        return usuarioBean;
    }

    @Override
    public void limpar() {
        this.setEntity(new Usuario());
        this.setList(this.getBean().findAll());
    }

}
