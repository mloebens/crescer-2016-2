package br.com.cwi.crescer.aula5.mbean;

import br.com.cwi.crescer.aula5.bean.UsuarioBean;
import br.com.cwi.crescer.aula5.entity.Usuario;
import static br.com.cwi.crescer.aula5.utils.UserDetails.USER_AUTH;

import br.com.cwi.crescer.aula5.filters.UsuarioLogado;
import br.com.cwi.crescer.aula5.utils.FacesUtils;
import static br.com.cwi.crescer.aula5.utils.FacesUtils.getContext;
import br.com.cwi.crescer.aula5.utils.UserDetails;
import java.io.Serializable;
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
public class LoginMBean implements Serializable {

    @EJB
    private UsuarioBean usuarioBean;

    private Usuario usuario;

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario user) {
        this.usuario = usuario;
    }

    public String getUsuarioLogadoNome() {
        final UserDetails userDetails;
        userDetails = (UserDetails) FacesUtils.getSession().getAttribute(USER_AUTH);
        return userDetails == null ? null : userDetails.getNome();
    }

    public String login() {
        Usuario usuarioEncontrado = usuarioBean.getDao().findByEmail(usuario.getEmail());
        if (usuarioEncontrado != null) {
            boolean senhaValida = usuarioEncontrado.getSenha().equals(usuario.getSenha());

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
