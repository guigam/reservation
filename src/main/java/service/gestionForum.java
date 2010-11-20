/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import entity.forum;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.richfaces.component.UIDataTable;

/**
 *
 * @author guigam
 */
public class gestionForum {
  private List<forum> lesmessages = new LinkedList<forum>();
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("manager");
    private EntityManager em = factory.createEntityManager();
    private UIDataTable dataTable;




    public List<forum> getdiscution(){
        Query query = getEm().createQuery("select f from forum f ");
                
                for(forum f : (List<forum>) query.getResultList()){
                    lesmessages.add(f);
                }

        return lesmessages;
           
    }
  
    /**
     * @return the dataTable
     */
    public UIDataTable getDataTable() {
        return dataTable;
    }

    /**
     * @param dataTable the dataTable to set
     */
    public void setDataTable(UIDataTable dataTable) {
        this.dataTable = dataTable;
    }

    /**
     * @return the lesmessages
     */
    public List<forum> Lesmessages() {
        return getLesmessages();
    }

    /**
     * @param lesmessages the lesmessages to set
     */
    public void setLesmessages(List<forum> lesmessages) {
        this.setLesmessages(lesmessages);
    }

    /**
     * @return the lesmessages
     */
    public List<forum> getLesmessages() {
        return lesmessages;
    }

  
    /**
     * @return the factory
     */
    public EntityManagerFactory getFactory() {
        return factory;
    }

    /**
     * @param factory the factory to set
     */
    public void setFactory(EntityManagerFactory factory) {
        this.factory = factory;
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

}
