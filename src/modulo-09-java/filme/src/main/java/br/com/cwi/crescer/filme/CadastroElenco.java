package br.com.cwi.crescer.filme;


import br.com.cwi.crescer.filme.DAO.ElencoBean;
import br.com.cwi.crescer.filme.Entity.Ator;
import br.com.cwi.crescer.filme.Entity.Elenco;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CadastroElenco {

    @EJB
    private ElencoBean elencoBean;
    
    private Elenco elenco;
    private List<Elenco> elencos;
    private List<Long> ids;
    private List<String> atoresNomes;

    @PostConstruct
    public void init() {
        this.elenco = new Elenco();
        this.elencos = elencoBean.findAll();
        this.elencos.sort((a,b)-> a.getId().compareTo(b.getId()));
        atoresNomes = new ArrayList<>();
        for (Elenco elenco1 : elencos) {
            atoresNomes.add(elenco1.getAtoresNomes());
        }
        
    }

    public Elenco getElenco() {
        return elenco;
    }

    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }

    public List<Elenco> getElencos() {
        return elencos;
    }

    public void setElencos(List<Elenco> elencos) {
        this.elencos = elencos;
    }

    public ElencoBean getElencoBean() {
        return elencoBean;
    }

    public void setElencoBean(ElencoBean elencoBean) {
        this.elencoBean = elencoBean;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
    
    public List<String> getAtoresNomes(){
        return this.atoresNomes;
    }
    
    public void adicionar() {
        List<Ator> atores = new ArrayList<>();
        
        for (Long id : ids) {
            Ator ator = new Ator();
            ator.setId(id);
            atores.add(ator);
        }
        elenco.setAtores(atores);
        elencoBean.insert(elenco);
        this.init();
    }

}
