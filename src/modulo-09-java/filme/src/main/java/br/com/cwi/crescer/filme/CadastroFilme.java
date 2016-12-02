package br.com.cwi.crescer.filme;

import br.com.cwi.crescer.filme.DAO.FilmeBean;
import br.com.cwi.crescer.filme.Entity.Classificacao;
import br.com.cwi.crescer.filme.Entity.Elenco;
import br.com.cwi.crescer.filme.Entity.Filme;
import br.com.cwi.crescer.filme.Entity.Genero;
import br.com.cwi.crescer.filme.Entity.Idioma;
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
    private Long idGenero;
    private Long idClassificacao;
    private Long idElenco;
    private Long idIdioma;

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

    public FilmeBean getFilmeBean() {
        return filmeBean;
    }

    public void setFilmeBean(FilmeBean filmeBean) {
        this.filmeBean = filmeBean;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public Long getIdClassificacao() {
        return idClassificacao;
    }

    public void setIdClassificacao(Long idClassificacao) {
        this.idClassificacao = idClassificacao;
    }

    public Long getIdElenco() {
        return idElenco;
    }

    public void setIdElenco(Long idElenco) {
        this.idElenco = idElenco;
    }

    public Long getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Long idIdioma) {
        this.idIdioma = idIdioma;
    }

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    
    public void adicionar() {
        Genero genero = new Genero();
        Classificacao classificacao = new Classificacao();
        Elenco elenco = new Elenco();
        Idioma idioma = new Idioma();
        
        genero.setId(idGenero);
        classificacao.setId(idClassificacao);
        elenco.setId(idElenco);
        idioma.setId(idIdioma);
        
        filme.setGenero(genero);
        filme.setClassificacao(classificacao);
        filme.setElenco(elenco);
        filme.setIdioma(idioma);
        
        filmeBean.insert(filme);
        this.init();
    }
}
