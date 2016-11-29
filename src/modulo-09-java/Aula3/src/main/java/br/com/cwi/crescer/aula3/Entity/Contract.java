package br.com.cwi.crescer.aula3.Entity;

import java.io.Serializable;
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
@Table(name = "CONTRACT")
public class Contract implements Serializable, ICSVExportavel {

    @Id
    @Basic(optional = false)
    @Column(name = "ID_CONTRACT")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CONTRACT")
    @SequenceGenerator(name = "SEQ_CONTRACT", sequenceName = "SEQ_CONTRACT", allocationSize = 1)
    private Long idContract;

    @Basic(optional = false)
    @Column(name = "DS_DESCRIPTION")
    private String dsDescrition;

    @Basic(optional = false)
    @Column(name = "DS_STATE")
    private String dsState;

    @Basic(optional = false)
    @Column(name = "DS_WEBSITE")
    private String dsWebsite;

    @Basic(optional = false)
    @Column(name = "NM_CONTRACT")
    private String nmContract;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID_CLIENT")
    private Client client;

    public Long getIdContract() {
        return idContract;
    }

    public void setIdContract(Long idContract) {
        this.idContract = idContract;
    }

    public String getDsDescrition() {
        return dsDescrition;
    }

    public void setDsDescrition(String dsDescrition) {
        this.dsDescrition = dsDescrition;
    }

    public String getDsState() {
        return dsState;
    }

    public void setDsState(String dsState) {
        this.dsState = dsState;
    }

    public String getDsWebsite() {
        return dsWebsite;
    }

    public void setDsWebsite(String dsWebsite) {
        this.dsWebsite = dsWebsite;
    }

    public String getNmContract() {
        return nmContract;
    }

    public void setNmContract(String nmContract) {
        this.nmContract = nmContract;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append(idContract);
        sb.append(";");
        sb.append(dsDescrition);
        sb.append(";");
        sb.append(dsState);
        sb.append(";");
        sb.append(dsWebsite);
        sb.append(";");
        sb.append(nmContract);
        sb.append(";");
        sb.append(client.getIdClient());

        return sb.toString();

    }

}
