/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author guigam
 */
@Entity
@Table(name = "face")
@NamedQueries({@NamedQuery(name = "face.findAll", query = "SELECT b FROM face b"), @NamedQuery(name = "face.findById", query = "SELECT b FROM face b WHERE b.id = :id"), @NamedQuery(name = "face.findByIdFace", query = "SELECT b FROM face b WHERE b.idFace = :idFace"), @NamedQuery(name = "face.findByAdresse", query = "SELECT b FROM face b WHERE b.adresse = :adresse"), @NamedQuery(name = "face.findBySig", query = "SELECT b FROM face b WHERE b.sig = :sig"), @NamedQuery(name = "face.findBySupport", query = "SELECT b FROM face b WHERE b.support = :support"), @NamedQuery(name = "face.findByFormat", query = "SELECT b FROM face b WHERE b.format = :format"), @NamedQuery(name = "face.findByType", query = "SELECT b FROM face b WHERE b.type = :type"), @NamedQuery(name = "face.findByNoteQualitative", query = "SELECT b FROM face b WHERE b.noteQualitative = :noteQualitative"), @NamedQuery(name = "face.findByGrp", query = "SELECT b FROM face b WHERE b.grp = :grp"), @NamedQuery(name = "face.findByAudience", query = "SELECT b FROM face b WHERE b.audience = :audience"), @NamedQuery(name = "face.findByPrixPublic", query = "SELECT b FROM face b WHERE b.prixPublic = :prixPublic"), @NamedQuery(name = "face.findByEtat", query = "SELECT b FROM face b WHERE b.etat = :etat")})
public class face implements Serializable {
    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer Id;
    @Column(name = "id_face")
    private String idFace;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "sig")
    private Integer sig;
    @Column(name = "support")
    private String support;
    @Column(name = "format")
    private String format;
    @Column(name = "type")
    private String type;
    @Column(name = "note_qualitative")
    private Float noteQualitative;
    @Column(name = "grp")
    private float grp;
    @Column(name = "audience")
    private Float audience;
    @Column(name = "prixPublic")
    private Float prixPublic;
    @Column(name = "etat")
    private String etat;
    @Column(name = "latitude")
    private Float coordonneX;
    @Column(name = "longitude")
    private Float coordonneY;
    private int dispo;


    @ManyToOne(optional = false)
    private Regie maregie;

    @ManyToMany
    private List<Client> PFC;

    public face() {
    }

    public face(Integer id) {
        this.Id = id;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getIdFace() {
        return idFace;
    }

    public void setIdFace(String idFace) {
        this.idFace = idFace;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getSig() {
        return sig;
    }

    public void setSig(Integer sig) {
        this.sig = sig;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getNoteQualitative() {
        return noteQualitative;
    }

    public void setNoteQualitative(Float noteQualitative) {
        this.noteQualitative = noteQualitative;
    }

    public float getGrp() {
        return grp;
    }

    public void setGrp(float grp) {
        this.grp = grp;
    }


    public Float getAudience() {
        return audience;
    }

    public void setAudience(Float audience) {
        this.audience = audience;
    }

    public Float getPrixPublic() {
        return prixPublic;
    }

    public void setPrixPublic(Float prixPublic) {
        this.prixPublic = prixPublic;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof face)) {
            return false;
        }
        face other = (face) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.Id.equals(other.Id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BEntries[id=" + getId() + "]";
    }

    /**
     * @return the coordonneX
     */
    public Float getCoordonneX() {
        return coordonneX;
    }

    /**
     * @param coordonneX the coordonneX to set
     */
    public void setCoordonneX(Float coordonneX) {
        this.coordonneX = coordonneX;
    }

    /**
     * @return the coordonneY
     */
    public Float getCoordonneY() {
        return coordonneY;
    }

    /**
     * @param coordonneY the coordonneY to set
     */
    public void setCoordonneY(Float coordonneY) {
        this.coordonneY = coordonneY;
    }

    /**
     * @return the maregie
     */
    public Regie getMaregie() {
        return maregie;
    }

    /**
     * @param maregie the maregie to set
     */
    public void setMaregie(Regie maregie) {
        this.maregie = maregie;
    }

    /**
     * @return the PFC
     */
    public List<Client> getPFC() {
        return PFC;
    }

    /**
     * @param PFC the PFC to set
     */
    public void setPFC(List<Client> PFC) {
        this.PFC = PFC;
    }

    /**
     * @return the dispo
     */
    public int isDispo() {
        return getDispo();
    }

    /**
     * @param dispo the dispo to set
     */
    public void setDispo(int dispo) {
        this.dispo = dispo;
    }

    /**
     * @return the dispo
     */
    public int getDispo() {
        return dispo;
    }
       

}
