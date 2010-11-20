/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import entity.Regie;
import entity.face;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.faces.component.UIData;
import javax.faces.model.SelectItem;
import javax.persistence.*;

/**
 *
 * @author guigam
 */
public class gestionRegie {
    private List<face> lesface= new LinkedList<face>();
    private List<Regie> lesregies = new LinkedList<Regie>();
    private Regie maregie = new Regie();
       private EntityManagerFactory factory = Persistence.createEntityManagerFactory("manager");
    private EntityManager em = factory.createEntityManager();
    private int nbface;
    private UIData dataTable;
     private UIData dataTable2;


    public List<Regie> getmesregies(){
    Query query = em.createQuery("select r from Regie r ");
     
       for (Regie r : (List<Regie>)query.getResultList()) {
            getLesregies().add(r);
        }
          return lesregies;
    }



    public String ShowfaceCarte(){

        lesface = (List<face>) dataTable2.getRowData();
        return "faceCarteindiv";
    }



        public List<SelectItem> getListRegie(){
		List<SelectItem> distRegie = new ArrayList<SelectItem>();
                    Query query = em.createQuery("select nom from regie r");
                 List<Regie> r =  (List<Regie>) query.getResultList();
                for(Regie rr : r)
                    distRegie.add(new SelectItem(rr,rr.getNom()));
                return (List<SelectItem>)distRegie;

	}


   
    

     public String facesDesRegies(){

           maregie = (Regie) dataTable.getRowData();
      Query query = em.createQuery("select f from face f where f.maregie = ?1");
      query.setParameter(1, maregie);
        setLesface((List<face>) query.getResultList());
         setNbface(lesface.size());
        return "faceregie";

     }

    /**
     * @return the lesregies
     */
    public List<Regie> getLesregies() {
        return lesregies;
    }

    /**
     * @param lesregies the lesregies to set
     */
    public void setLesregies(List<Regie> lesregies) {
        this.lesregies = lesregies;
    }

    /**
     * @return the dataTable
     */
    public UIData getDataTable() {
        return dataTable;
    }

    /**
     * @param dataTable the dataTable to set
     */
    public void setDataTable(UIData dataTable) {
        this.dataTable = dataTable;
    }

    /**
     * @return the lesface
     */
    public List<face> getLesface() {
        return lesface;
    }

    /**
     * @param lesface the lesface to set
     */
    public void setLesface(List<face> lesface) {
        this.lesface = lesface;
    }

    /**
     * @return the dataTable2
     */
    public UIData getDataTable2() {
        return dataTable2;
    }

    /**
     * @param dataTable2 the dataTable2 to set
     */
    public void setDataTable2(UIData dataTable2) {
        this.dataTable2 = dataTable2;
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
     * @return the nbface
     */
    public int getNbface() {
        return nbface;
    }

    /**
     * @param nbface the nbface to set
     */
    public void setNbface(int nbface) {
        this.nbface = nbface;
    }

      public Object getRegieFromId(Integer valueOf) {
        throw new UnsupportedOperationException("Not yet implemented");
    }



}
