package br.com.cwi.crescer.aula3.Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Máicon Loebens
 */
@Entity
@Table(name = "Client")
public class Client implements Serializable, ICSVExportavel {

    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CLIENT")
    @SequenceGenerator(name = "SEQ_CLIENT", sequenceName = "SEQ_CLIENT", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_CLIENT")
    private Long idClient;

    @Basic(optional = false)
    @Column(name = "DS_EMAIL")
    private String dsEmail;

    @Basic(optional = false)
    @Column(name = "DS_PASSWORD")
    private String dsPassword;

    @Basic(optional = false)
    @Column(name = "DS_PREFERRED_COIN")
    private String dsPreferredCoin;

    @Basic(optional = false)
    @Column(name = "DS_STATE")
    private String dsState;

    @Basic(optional = false)
    @Column(name = "DS_USER_NAME")
    private String dsUserName;

    @Basic(optional = false)
    @Column(name = "NM_CLIENT")
    private String nmClient;

    @Basic(optional = false)
    @Column(name = "TP_PERMISSION")
    private String tpPermission;

    @OneToMany(mappedBy = "client")
    private List<Contract> contracts;

    public Long getIdClient() {
        return idClient;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public String getDsPassword() {
        return dsPassword;
    }

    public String getDsPreferredCoin() {
        return dsPreferredCoin;
    }

    public String getDsState() {
        return dsState;
    }

    public String getDsUserName() {
        return dsUserName;
    }

    public String getNmClient() {
        return nmClient;
    }

    public String getTpPermission() {
        return tpPermission;
    }

    
    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public void setDsPassword(String dsPassword) {
        this.dsPassword = dsPassword;
    }

    public void setDsPreferredCoin(String dsPreferredCoin) {
        this.dsPreferredCoin = dsPreferredCoin;
    }

    public void setDsState(String dsState) {
        this.dsState = dsState;
    }

    public void setDsUserName(String dsUserName) {
        this.dsUserName = dsUserName;
    }

    public void setNmClient(String nmClient) {
        this.nmClient = nmClient;
    }

    public void setTpPermission(String tpPermission) {
        this.tpPermission = tpPermission;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public String toCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append(idClient);
        sb.append(";");
        sb.append(dsEmail);
        sb.append(";");
        sb.append(dsPassword);
        sb.append(";");
        sb.append(dsPreferredCoin);
        sb.append(";");
        sb.append(dsState);
        sb.append(";");
        sb.append(dsUserName);
        sb.append(";");
        sb.append(nmClient);
        sb.append(";");
        sb.append(tpPermission);
        
        return sb.toString();
    }

    @Override
    public String toCabecalhoCSV() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
