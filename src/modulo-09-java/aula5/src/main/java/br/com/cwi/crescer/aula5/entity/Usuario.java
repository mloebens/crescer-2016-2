package br.com.cwi.crescer.aula5.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Carlos H. Nonnemacher
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

    private static final String SQ_NAME = "SQ_USUARIO";

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Column(name = "ID_USUARIO")
    private Long id;

    @Basic(optional = false)
    @Column(name = "NM_USUARIO")
    private String nome;

    @Basic(optional = false)
    @Column(name = "DS_EMAIL")
    private String email;

    @Basic(optional = false)
    @Column(name = "DS_SENHA")
    private String senha;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}