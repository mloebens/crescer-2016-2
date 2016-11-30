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
@Table(name = "CURRENCY_EXCHANGE")
public class CurrencyExchange implements Serializable {

    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CURRENCY_EXCHANGE")
    @SequenceGenerator(name = "SEQ_CURRENCY_EXCHANGE", sequenceName = "SEQ_CURRENCY_EXCHANGE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_CURRENCY_EXCHANGE")
    private Long idCurrencyExchange;

    @Basic(optional = false)
    @Column(name = "DS_COIN")
    private String dsCoin;

    @Basic(optional = false)
    @Column(name = "DT_CURRENCY_EXCHANGE")
    private byte[] dtCurrencyExchange;

    @Basic(optional = false)
    @Column(name = "VL_RATE")
    private BigDecimal vlRate;

    public Long getIdCurrencyExchange() {
        return idCurrencyExchange;
    }

    public void setIdCurrencyExchange(Long idCurrencyExchange) {
        this.idCurrencyExchange = idCurrencyExchange;
    }

    public String getDsCoin() {
        return dsCoin;
    }

    public void setDsCoin(String dsCoin) {
        this.dsCoin = dsCoin;
    }

    public byte[] getDtCurrencyExchange() {
        return dtCurrencyExchange;
    }

    public void setDtCurrencyExchange(byte[] dtCurrencyExchange) {
        this.dtCurrencyExchange = dtCurrencyExchange;
    }

    public BigDecimal getVlRate() {
        return vlRate;
    }

    public void setVlRate(BigDecimal vlRate) {
        this.vlRate = vlRate;
    }

    
}
