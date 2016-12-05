package br.com.cwi.crescer.aula5.mbean;

import br.com.cwi.crescer.aula5.bean.UsuarioBean;
import br.com.cwi.crescer.aula5.dao.UsuarioDao;
import br.com.cwi.crescer.aula5.entity.Usuario;
import br.com.cwi.crescer.aula5.filters.UsuarioLogado;
import br.com.cwi.crescer.aula5.utils.FacesUtils;
import static br.com.cwi.crescer.aula5.utils.FacesUtils.getContext;
import br.com.cwi.crescer.aula5.utils.UserDetails;
import static br.com.cwi.crescer.aula5.utils.UserDetails.USER_AUTH;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
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

        public String getUsuarioLogadoNome() {
        final UserDetails userDetails;
        userDetails = (UserDetails) FacesUtils.getSession().getAttribute(USER_AUTH);
        return userDetails == null ? null : userDetails.getNome();
    }

    public String login() {
        Usuario usuarioEncontrado = usuarioBean.getDao().findByEmail(this.getEntity().getEmail());
        if (usuarioEncontrado != null) {
            boolean senhaValida = usuarioEncontrado.getSenha().equals(this.getEntity().getSenha());

            if (senhaValida) {
                UsuarioLogado user = new UsuarioLogado();
                user.setEmail(usuarioEncontrado.getEmail());
                user.setNome(usuarioEncontrado.getNome());
                FacesUtils.getSession().setAttribute(USER_AUTH, user);
                return "index";
            }
        }
        
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário/senha inválida ", "");
        getContext().addMessage(null, facesMessage);
        return "login";
    }

    public String logout() {
        FacesUtils.getSession().invalidate();
        return "login";
    }
    
}
