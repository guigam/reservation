/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;
import javax.persistence.OneToMany;
import service.connexion;

/**
 *
 * @author mehdiguiga
 */
@Entity
public class Client implements Serializable{
 @Id
    private int idClient;
    private String NomClient;
    private String adresse;
    private String phone;
    private String fax;
    private String Email;
    private String Information;
    private String famille;

  
   

@OneToOne
private Users monuser;



    /**
     * @return the idClient
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * @param idClient the idClient to set
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * @return the NomClient
     */
    public String getNomClient() {
        return NomClient;
    }

    /**
     * @param NomClient the NomClient to set
     */
    public void setNomClient(String NomClient) {
        this.NomClient = NomClient;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Information
     */
    public String getInformation() {
        return Information;
    }

    /**
     * @param Information the Information to set
     */
    public void setInformation(String Information) {
        this.Information = Information;
    }

    /**
     * @return the famille
     */
    public String getFamille() {
        return famille;
    }

    /**
     * @param famille the famille to set
     */
    public void setFamille(String famille) {
        this.famille = famille;
    }


    /**
     * @return the monuser
     */
    public Users getMonuser() {
        return monuser;
    }

    /**
     * @param monuser the monuser to set
     */
    public void setMonuser(Users monuser) {
        this.monuser = monuser;
    }


   
  
 
   
}
