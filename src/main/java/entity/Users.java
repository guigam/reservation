/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;
import javax.faces.model.SelectItem;

/**
 *
 * @author guigam
 */

@Entity
public class Users implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int ID;

private String username;
private String mdp;
private String statut;

private String type;

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the mdp
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * @param mdp the mdp to set
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

 

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the statut
     */
    public String getStatut() {
        return statut;
    }

    /**
     * @param statut the statut to set
     */
    public void setStatut(String statut) {
        this.statut = statut;
    }
   

}
