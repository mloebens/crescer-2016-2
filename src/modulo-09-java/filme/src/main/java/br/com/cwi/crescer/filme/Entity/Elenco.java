/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.filme.Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Note i3
 */
@Entity
@Table(name = "ELENCO")
public class Elenco implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_ELENCO")
    @SequenceGenerator(name = "SEQ_ELENCO", sequenceName = "SEQ_ELENCO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_ELENCO")
    private Long id;

    @Basic(optional = false)
    @Column(name = "NOME", nullable = false)
    private String nome;
    
    private List<Ator> atores;
    private List<Filme> filmes;
       
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }
    
    public String getAtoresNomes(){
        StringBuilder nomes = new StringBuilder();
        for (Ator ator : atores) {
            nomes.append(ator.getNome());
            nomes.append(",");
        }
        
        return nomes.toString().substring(0, nomes.length()-1);
    }
}