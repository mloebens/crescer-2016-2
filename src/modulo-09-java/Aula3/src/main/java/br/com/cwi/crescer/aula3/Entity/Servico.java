/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Máicon Loebens
 */
@Entity
@Table(name = "SERVICO")
public class Servico implements Serializable, ICSVExportavel {

    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_SERVICO")
    @SequenceGenerator(name = "SEQ_SERVICO", sequenceName = "SEQ_SERVICO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_SERVICO")
    private Long idServico;

    @Basic(optional = false)
    @Column(name = "DS_DESCRICAO")
    private String dsDescricao;

    @Basic(optional = false)
    @Column(name = "DS_PERIODICIDADE")
    private String dsPeriodicidade;

    @Basic(optional = false)
    @Column(name = "DS_SIMBOLO_MOEDA")
    private String dsSimboloMoeda;

    @Basic(optional = false)
    @Column(name = "DS_SITUACAO")
    private String dsSituacao;

    @Basic(optional = false)
    @Column(name = "DS_WEBSITE")
    private String dsWebsite;

    @Basic(optional = false)
    @Column(name = "NM_SERVICO")
    private String nmServico;

    @Basic(optional = false)
    @Column(name = "VL_MENSAL_USD")
    private BigDecimal vlMensalUSD;

    @Basic(optional = false)
    @Column(name = "VL_TOTAL_SERVICO")
    private BigDecimal vlTotalServico;

    @ManyToOne
    @JoinColumn(name = "USUARIO_ID_USUARIO")
    private Usuario usuario;

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public String getDsDescricao() {
        return dsDescricao;
    }

    public void setDsDescricao(String dsDescricao) {
        this.dsDescricao = dsDescricao;
    }

    public String getDsPeriodicidade() {
        return dsPeriodicidade;
    }

    public void setDsPeriodicidade(String dsPeriodicidade) {
        this.dsPeriodicidade = dsPeriodicidade;
    }

    public String getDsSimboloMoeda() {
        return dsSimboloMoeda;
    }

    public void setDsSimboloMoeda(String dsSimboloMoeda) {
        this.dsSimboloMoeda = dsSimboloMoeda;
    }

    public String getDsSituacao() {
        return dsSituacao;
    }

    public void setDsSituacao(String dsSituacao) {
        this.dsSituacao = dsSituacao;
    }

    public String getDsWebsite() {
        return dsWebsite;
    }

    public void setDsWebsite(String dsWebsite) {
        this.dsWebsite = dsWebsite;
    }

    public String getNmServico() {
        return nmServico;
    }

    public void setNmServico(String nmServico) {
        this.nmServico = nmServico;
    }

    public BigDecimal getVlMensalUSD() {
        return vlMensalUSD;
    }

    public void setVlMensalUSD(BigDecimal vlMensalUSD) {
        this.vlMensalUSD = vlMensalUSD;
    }

    public BigDecimal getVlTotalServico() {
        return vlTotalServico;
    }

    public void setVlTotalServico(BigDecimal vlTotalServico) {
        this.vlTotalServico = vlTotalServico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toCSV() {
        StringBuilder sb = new StringBuilder();
        
    sb.append(idServico);
    sb.append(";");
    sb.append(dsDescricao);
    sb.append(";");
    sb.append(dsPeriodicidade);
    sb.append(";");
    sb.append(dsSimboloMoeda);
    sb.append(";");
    sb.append(dsSituacao);
    sb.append(";");
    sb.append(dsWebsite);
    sb.append(";");
    sb.append(nmServico);
    sb.append(";");
    sb.append(vlMensalUSD);
    sb.append(";");
    sb.append(vlTotalServico);
    sb.append(";");
    sb.append(usuario.getIdUsuario());
    return sb.toString();
}

}
