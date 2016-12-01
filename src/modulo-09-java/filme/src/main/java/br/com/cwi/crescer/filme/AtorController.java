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

/**
 * @author Carlos H. Nonnemacher
 */
@ManagedBean
@ViewScoped
public class AtorController {

    @EJB
    private AtorBean atorBean;
    
    private Ator ator;
    private List<Ator> ators;

    @PostConstruct
    public void init() {
        this.ator = new Ator();
        this.ators = atorBean.findAll();
        this.ators.sort((a,b)-> a.getId().compareTo(b.getId()));
    }

    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public List<Ator> getAtors() {
        return ators;
    }

    public void setAtors(List<Ator> ators) {
        this.ators = ators;
    }

    public void adicionar() {
        atorBean.insert(ator);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste", "teste"));
    }

}
