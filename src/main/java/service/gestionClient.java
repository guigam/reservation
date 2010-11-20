/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import entity.Client;
import entity.Users;
import entity.campagne;
import java.util.LinkedList;
import java.util.List;
import javax.faces.component.UIData;
import javax.faces.model.SelectItem;
import javax.persistence.*;


/**
 *
 * @author guigam
 */
public class gestionClient {
    private List<campagne> campClient = new LinkedList<campagne>();
    Users monUser = new Users();
    Client monClient = new Client();
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("manager");
    private EntityManager em = factory.createEntityManager();
      private UIData datatable;

 

        public List<SelectItem> getlistFaceClient(){
        Query query =   em.createQuery("SELECT c FROM Client c )");
        List<SelectItem> clients = new LinkedList<SelectItem>();
        for (Client c : (List<Client>)query.getResultList()) {
            clients.add(new SelectItem(c, c.getNomClient()));
        }
        return (List<SelectItem>)clients;
         }


        public List<campagne> getcampagnecli(){

            return listecampagneClients();
        }


              public List<campagne> listecampagneClients(){

                    
                
        Query query = em.createQuery("select c from campagne c where c.monClient = ?1 ");
        query.setParameter(1,monClient);
                 List<campagne> camp = new LinkedList<campagne>();

        for (campagne c : (List<campagne>)query.getResultList()) {
            camp.add(c);
        }

    return (List<campagne>) camp;
                
    }


        public List<Client> getlistClients(){
        Query query = em.createQuery("select c from Client c ");
        return query.getResultList();


        }




     public List<SelectItem> getlistClientItem(){
             Query query = em.createQuery("select c from Client c ");
                LinkedList<SelectItem> leclient = new LinkedList<SelectItem>();
            for (Client c : (List<Client>)query.getResultList()) {
            leclient.add(new SelectItem(c, c.getNomClient()));
        }
                      return (List<SelectItem>) leclient;

        }


    /**
     * @return the datatable
     */
    public UIData getDatatable() {
        return datatable;
    }

    /**
     * @param datatable the datatable to set
     */
    public void setDatatable(UIData datatable) {
        this.datatable = datatable;
    }

    public Object getClientFromId(Integer valueOf) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
