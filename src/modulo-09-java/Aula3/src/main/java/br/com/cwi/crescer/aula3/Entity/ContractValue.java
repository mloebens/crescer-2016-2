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
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Máicon Loebens
 */
public class ContractValue implements Serializable, ICSVExportavel {

    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CONTRACT_VALUE")
    @SequenceGenerator(name = "SEQ_CONTRACT_VALUE", sequenceName = "SEQ_CONTRACT_VALUE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_CONTRACT_VALUE")
    private Long idContractValue;

    @Basic(optional = false)
    @Column(name = "DS_COIN")
    private String dsCoin;

    @Basic(optional = false)
    @Column(name = "DS_PERIODICITY")
    private String dsPeriodicity;

    @Basic(optional = false)
    @Column(name = "VL_AMOUNT_CONTRACT_VALUE")
    private BigDecimal vlAmountContractValue;

    @Basic(optional = false)
    @Column(name = "VL_MONTHLY_USD")
    private BigDecimal vlMonthlyUSD;

    @OneToOne
    @JoinColumn(name = "CONTRACT_ID_CONTRACT")
    private Contract contract;
  

    public Long getIdContractValue() {
        return idContractValue;
    }

    public void setIdContractValue(Long idContractValue) {
        this.idContractValue = idContractValue;
    }

    public String getDsCoin() {
        return dsCoin;
    }

    public void setDsCoin(String dsCoin) {
        this.dsCoin = dsCoin;
    }

    public String getDsPeriodicity() {
        return dsPeriodicity;
    }

    public void setDsPeriodicity(String dsPeriodicity) {
        this.dsPeriodicity = dsPeriodicity;
    }

    public BigDecimal getVlAmountContractValue() {
        return vlAmountContractValue;
    }

    public void setVlAmountContractValue(BigDecimal vlAmountContractValue) {
        this.vlAmountContractValue = vlAmountContractValue;
    }

    public BigDecimal getVlMonthlyUSD() {
        return vlMonthlyUSD;
    }

    public void setVlMonthlyUSD(BigDecimal vlMonthlyUSD) {
        this.vlMonthlyUSD = vlMonthlyUSD;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    @Override
    public String toCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append(idContractValue);
        sb.append(";");
        sb.append(dsCoin);
        sb.append(";");
        sb.append(dsPeriodicity);
        sb.append(";");
        sb.append(vlAmountContractValue);
        sb.append(";");
        sb.append(vlMonthlyUSD);
        sb.append(";");
        sb.append(contract);
        
        return sb.toString();
    }

}
