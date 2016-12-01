package br.com.cwi.crescer.filme;

import br.com.cwi.crescer.filme.DAO.FilmeBean;
import br.com.cwi.crescer.filme.Entity.Filme;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CadastroFilme {

    @EJB
    private FilmeBean filmeBean;
    
    private Filme filme;
    private List<Filme> filmes;

    @PostConstruct
    public void init() {
        this.filme = new Filme();
        this.filmes = filmeBean.findAll();
        this.filmes.sort((a,b)-> a.getId().compareTo(b.getId()));
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public List<Filme> getFilmees() {
        return filmes;
    }

    public void setFilmees(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public void adicionar() {
        filmeBean.insert(filme);
        this.init();
    }
}
