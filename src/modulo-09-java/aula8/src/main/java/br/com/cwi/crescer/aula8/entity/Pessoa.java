package br.com.cwi.crescer.aula8.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author maicon.loebens
 */
@Entity
@Table(name = "PESSOA")
public class Pessoa implements Serializable {

    private static final String SEQ_NAME = "SEQ_PESSOA";
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME)
    @Column(name = "ID_PESSOA")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "NM_PESSOA")
    private String nome;
    
    @Basic(optional = false)
    @Column(name = "NASCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date nascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
