/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author guigam
 */
@Entity
public class campagne implements Serializable {
   @Id
@GeneratedValue(strategy=GenerationType.AUTO)
    private int idCampagne;
    private String nomCampagne;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebut;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFin;
  
    private String etat;// 1=traité, 0 =  en attente 

@ManyToMany
private List<Regie> mesregie;
@ManyToMany
private List<face> faceCampagne;

@OneToMany

   @ManyToOne(optional = false)
    private Client monClient;
    /**
     * @return the idCampagne
     */
    public int getIdCampagne() {
        return idCampagne;
    }

    /**
     * @param idCampagne the idCampagne to set
     */
    public void setIdCampagne(int idCampagne) {
        this.idCampagne = idCampagne;
    }

    /**
     * @return the nomCampagne
     */
    public String getNomCampagne() {
        return nomCampagne;
    }

    /**
     * @param nomCampagne the nomCampagne to set
     */
    public void setNomCampagne(String nomCampagne) {
        this.nomCampagne = nomCampagne;
    }

    /**
     * @return the dateDebut
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     * @param dateDebut the dateDebut to set
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * @return the dateFin
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * @param dateFin the dateFin to set
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * @return the faceCampagne
     */
    public List<face> getFaceCampagne() {
        return faceCampagne;
    }

    /**
     * @param faceCampagne the faceCampagne to set
     */
    public void setFaceCampagne(List<face> faceCampagne) {
        this.faceCampagne = faceCampagne;
    }

    /**
     * @return the monClient
     */
    public Client getMonClient() {
        return monClient;
    }

    /**
     * @param monClient the monClient to set
     */
    public void setMonClient(Client monClient) {
        this.monClient = monClient;
    }

    /**
     * @return the etat
     */
    public String getEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(String etat) {
        this.etat = etat;
    }

    /**
     * @return the mesregie
     */
    public List<Regie> getMesregie() {
        return mesregie;
    }

    /**
     * @param mesregie the mesregie to set
     */
    public void setMesregie(List<Regie> mesregie) {
        this.mesregie = mesregie;
    }

    


}
