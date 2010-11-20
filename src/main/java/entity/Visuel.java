/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author guigam
 */
@Entity
public class Visuel implements Serializable {
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String URL;
    @ManyToOne
    private campagne lacamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Visuel)) {
            return false;
        }
        Visuel other = (Visuel) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Visuel[id=" + getId() + "]";
    }

    /**
     * @return the URL
     */
    public String getURL() {
        return URL;
    }

    /**
     * @param URL the URL to set
     */
    public void setURL(String URL) {
        this.URL = URL;
    }

    /**
     * @return the lacamp
     */
    public campagne getLacamp() {
        return lacamp;
    }

    /**
     * @param lacamp the lacamp to set
     */
    public void setLacamp(campagne lacamp) {
        this.lacamp = lacamp;
    }

}
