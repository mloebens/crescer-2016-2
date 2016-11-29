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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Máicon Loebens
 */
@Entity
@Table(name = "COTACAO")
public class Cotacao implements Serializable, ICSVExportavel {

    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_COTACAO")
    @SequenceGenerator(name = "SEQ_COTACAO", sequenceName = "SEQ_COTACAO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_COTACAO")
    private Long idCotacao;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_DOLLAR_AUSTRALIANO")
    private BigDecimal dsCotacaoDollarAustraliano;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_DOLLAR_CANADENSE")
    private BigDecimal dsCotacaoDollarCanadense;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_EURO")
    private BigDecimal dsCotacaoEuro;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_FRANCO_SUICO")
    private BigDecimal dsCotacaoFrancoSuico;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_LIBRA")
    private BigDecimal dsCotacaoLibra;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_REAL")
    private BigDecimal dsCotacaoReal;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_YEN")
    private BigDecimal dsCotacaoYen;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_YUAN")
    private BigDecimal dsCotacaoYuan;

    @Basic(optional = false)
    @Column(name = "DT_COTACAO")
    private byte[] dtCotacao;

    public Long getIdCotacao() {
        return idCotacao;
    }

    public void setIdCotacao(Long idCotacao) {
        this.idCotacao = idCotacao;
    }

    public BigDecimal getDsCotacaoDollarAustraliano() {
        return dsCotacaoDollarAustraliano;
    }

    public void setDsCotacaoDollarAustraliano(BigDecimal dsCotacaoDollarAustraliano) {
        this.dsCotacaoDollarAustraliano = dsCotacaoDollarAustraliano;
    }

    public BigDecimal getDsCotacaoDollarCanadense() {
        return dsCotacaoDollarCanadense;
    }

    public void setDsCotacaoDollarCanadense(BigDecimal dsCotacaoDollarCanadense) {
        this.dsCotacaoDollarCanadense = dsCotacaoDollarCanadense;
    }

    public BigDecimal getDsCotacaoEuro() {
        return dsCotacaoEuro;
    }

    public void setDsCotacaoEuro(BigDecimal dsCotacaoEuro) {
        this.dsCotacaoEuro = dsCotacaoEuro;
    }

    public BigDecimal getDsCotacaoFrancoSuico() {
        return dsCotacaoFrancoSuico;
    }

    public void setDsCotacaoFrancoSuico(BigDecimal dsCotacaoFrancoSuico) {
        this.dsCotacaoFrancoSuico = dsCotacaoFrancoSuico;
    }

    public BigDecimal getDsCotacaoLibra() {
        return dsCotacaoLibra;
    }

    public void setDsCotacaoLibra(BigDecimal dsCotacaoLibra) {
        this.dsCotacaoLibra = dsCotacaoLibra;
    }

    public BigDecimal getDsCotacaoReal() {
        return dsCotacaoReal;
    }

    public void setDsCotacaoReal(BigDecimal dsCotacaoReal) {
        this.dsCotacaoReal = dsCotacaoReal;
    }

    public BigDecimal getDsCotacaoYen() {
        return dsCotacaoYen;
    }

    public void setDsCotacaoYen(BigDecimal dsCotacaoYen) {
        this.dsCotacaoYen = dsCotacaoYen;
    }

    public BigDecimal getDsCotacaoYuan() {
        return dsCotacaoYuan;
    }

    public void setDsCotacaoYuan(BigDecimal dsCotacaoYuan) {
        this.dsCotacaoYuan = dsCotacaoYuan;
    }

    public byte[] getDtCotacao() {
        return dtCotacao;
    }

    public void setDtCotacao(byte[] dtCotacao) {
        this.dtCotacao = dtCotacao;
    }

    @Override
    public String toCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append(idCotacao);
        sb.append(";");
        sb.append(dsCotacaoDollarAustraliano);
        sb.append(";");
        sb.append(dsCotacaoDollarCanadense);
        sb.append(";");
        sb.append(dsCotacaoEuro);
        sb.append(";");
        sb.append(dsCotacaoFrancoSuico);
        sb.append(";");
        sb.append(dsCotacaoLibra);
        sb.append(";");
        sb.append(dsCotacaoReal);
        sb.append(";");
        sb.append(dsCotacaoYen);
        sb.append(";");
        sb.append(dsCotacaoYuan);
        sb.append(";");
        sb.append(dtCotacao);

        return sb.toString();
    }
}
