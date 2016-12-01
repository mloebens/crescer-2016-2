package br.com.cwi.crescer.filme;


import br.com.cwi.crescer.filme.DAO.AtorBean;
import br.com.cwi.crescer.filme.Entity.Ator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class CadIdioma {

    @EJB
    private AtorBean idiomaBean;
    
    private Ator idioma;
    private List<Ator> idiomas;

    @PostConstruct
    public void init() {
        this.idioma = new Ator();
        this.idiomas = idiomaBean.findAll();
        this.idiomas.sort((a,b)-> a.getId().compareTo(b.getId()));
    }

    public Ator getAtor() {
        return idioma;
    }

    public void setAtor(Ator idioma) {
        this.idioma = idioma;
    }

    public List<Ator> getAtores() {
        return idiomas;
    }

    public void setAtores(List<Ator> idiomas) {
        this.idiomas = idiomas;
    }

    public void adicionar() {
        idiomaBean.insert(idioma);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste", "teste"));
    }

}
