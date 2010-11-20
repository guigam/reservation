/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package service;


import entity.Client;
import entity.Regie;
import entity.campagne;
import entity.face;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.faces.component.*;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

/**
 *
 * @author guigam
 */
public class campagneManager {
 
    private List<face> faceCampagne = new LinkedList<face>();
    private List<campagne> mescamps = new LinkedList<campagne>();
    private face laface = new face();
    private campagne macamp = new campagne();
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("manager");
    private EntityManager em = factory.createEntityManager();
     private UIData dataTable;
     private UIData dataTable2;
    private Date db;
    private Date df ;
     private int nbrface;
     private float  sommeGRP;
     private int sommeBudget;
     private int sommeAudience;
Client moncli  = ((connexion)FacesContext.getCurrentInstance().getExternalContext()
               .getSessionMap().get( "log")).getMoncli();

Regie reg  = ((connexion)FacesContext.getCurrentInstance().getExternalContext()
               .getSessionMap().get( "log")).getMareg();



    public String savelaCampagne(){
        campagne lacamp = new campagne();
      
        lacamp.setDateDebut(macamp.getDateDebut());
        lacamp.setDateFin(macamp.getDateFin());
        lacamp.setEtat("En attente");
        lacamp.setNomCampagne(macamp.getNomCampagne());
        lacamp.setMonClient(moncli);
        lacamp.setFaceCampagne(faceCampagne);
        em.getTransaction().begin();
	em.merge(lacamp);
	em.getTransaction().commit();

    return "listcampCli";
    }




    public  List<campagne> rech(){
        if(db == null && df == null){
            Query query = em.createQuery("select c from campagne c where c.monClient = ?1");
            query.setParameter(1, moncli);
              mescamps = query.getResultList();
              return mescamps;
        }else{
            if(db==null){
                db = new Date(2000-01-01) ;
            }
          if(df==null){
                df = new Date(2050-01-01) ;
            }
        Query query = em.createQuery("select c from campagne c where c.dateDebut >= ?1 and c.dateFin <= ?2 and c.monClient = ?3");
        query.setParameter(1,db, TemporalType.DATE);
        query.setParameter(2,df, TemporalType.DATE);
        query.setParameter(3, moncli);

        mescamps = query.getResultList();

        return mescamps;
        }
    }


    public List<campagne> getlistecampagne(){
        Query query = em.createQuery("select c from campagne c ");

                 List<campagne> camp = new LinkedList<campagne>();

        for (campagne c : (List<campagne>)query.getResultList()) {
            camp.add(c);
        }

    return (List<campagne>) camp;
    }


     public List<campagne> getlistecampagneClients(){
        Query query = em.createQuery("select c from campagne c where c.monClient = ?1 and c.dateDebut > ?2 and c.dateFin < ?3 ");
        query.setParameter(1,moncli );
        query.setParameter(2,getDb());
        query.setParameter(3,getDf());
                 List<campagne> camp = new LinkedList<campagne>();

        for (campagne c : (List<campagne>)query.getResultList()) {
            camp.add(c);
        }

    return (List<campagne>) camp;
    }


    public String detailCampCli(){
      sommeGRP = 0;
            setSommeAudience(0);
      sommeBudget = 0;

      macamp = (campagne) dataTable.getRowData();
            setNbrface(macamp.getFaceCampagne().size());
            for(face f : macamp.getFaceCampagne()){
            sommeGRP = sommeGRP + f.getGrp();
            sommeBudget = (int) (sommeBudget + f.getPrixPublic());
                setSommeAudience((int) (getSommeAudience() + f.getAudience()));

            }


        return "detailcampagnecli";
      }
   
      public String detail(){
      sommeGRP = 0;
            setSommeAudience(0);
      sommeBudget = 0;

      macamp = (campagne) dataTable.getRowData();
            setNbrface(macamp.getFaceCampagne().size());
            for(face f : macamp.getFaceCampagne()){
            sommeGRP = sommeGRP + (int) f.getGrp();
            sommeBudget = (int) (sommeBudget + f.getPrixPublic());
                setSommeAudience((int) (getSommeAudience() + f.getAudience()));

            }


        return "detailcamp";
      }


      public String aa(String rep){
            File createDirectory = new File("/images/ramayan" + rep);
            createDirectory.mkdirs();
            return "nvCamp";

      }



    public String facecarto(){
      laface = (face) dataTable.getRowData();


        return "carteReg";
    }

    public List<campagne> getcampagneEnAtente(){
        Query query = em.createQuery("select c from campagne c where c.etat ='en attente'");
       List<campagne> mescamp = new LinkedList<campagne>();
       List<face> r = new LinkedList<face>();
       for(campagne c: (List<campagne>)query.getResultList()){
              if(c.getMesregie().equals(reg)){
              mescamps.add(c);
              }
       }
       
   
        return mescamps;

    }
         




   

    public List<campagne> getrechercheCampagne(Client leclient, Date d1, Date d2){
        d1 = getMacamp().getDateDebut();
        d2 = getMacamp().getDateFin();
        leclient = moncli;
    Query query = em.createQuery("select c from campagne c where c.dateDebut = ?1 and c.dateFin = ?2 and c.monClient = ?3 ");
    query.setParameter(1,d1);
    query.setParameter(2,d2);
    query.setParameter(3, leclient);
    List<campagne> camp = new LinkedList<campagne>();
     for (campagne c : (List<campagne>)query.getResultList()) {
            camp.add(c);
        }

    return (List<campagne>) camp;
    }





    public List<campagne> getcampagneEnCour(){
    String format = "dd/MM/yy H:mm:ss";

        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
        java.util.Date date = new java.util.Date();


    Query query = em.createQuery("select c from campagne c where c.dateDebut <= ?1  and c.dateFin >= ?1 and c.monClient = ?3");
    query.setParameter(1,date);
    query.setParameter(3, moncli);

                 List<campagne> camp = new LinkedList<campagne>();

        for (campagne c : (List<campagne>)query.getResultList()) {
            camp.add(c);
        }

    return (List<campagne>) camp;
    }

        public Collection<campagne> getcampagneEnCourRegie(){
    String format = "dd/MM/yy H:mm:ss";

        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
        java.util.Date date = new java.util.Date();


    Query query = em.createQuery("select c from campagne c where c.dateDebut <= ?1  and c.dateFin >= ?1");
    query.setParameter(1,date);


                

        for (campagne c : (Collection<campagne>)query.getResultList()) {
            mescamps.add(c);
        }

    return (Collection<campagne>) mescamps;
    }


       public List<campagne> getcampagneEnCourClient(){
    String format = "dd/MM/yy H:mm:ss";

        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
        java.util.Date date = new java.util.Date();


    Query query = em.createQuery("select c from campagne c where c.dateDebut < ?1  and c.dateFin > ?1 and c.monClient = ?2");
    query.setParameter(1,date);
    query.setParameter(2, moncli);

                 List<campagne> camp = new LinkedList<campagne>();

        for (campagne c : (List<campagne>)query.getResultList()) {
            camp.add(c);
        }

    return (List<campagne>) camp;
    }

    public String ShowfaceCarte(){
        laface = (face) dataTable2.getRowData();


    return "faceCarteindiv";
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
     * @return the macamp
     */
    public campagne getMacamp() {
        return macamp;
    }

    /**
     * @param macamp the macamp to set
     */
    public void setMacamp(campagne macamp) {
        this.macamp = macamp;
    }

    /**
     * @return the nbrface
     */
    public int getNbrface() {
        return nbrface;
    }

    /**
     * @param nbrface the nbrface to set
     */
    public void setNbrface(int nbrface) {
        this.nbrface = nbrface;
    }

    /**
     * @return the sommeGRP
     */
    public int getSommeGRP() {
        return (int) sommeGRP;
    }

    /**
     * @param sommeGRP the sommeGRP to set
     */
    public void setSommeGRP(int sommeGRP) {
        this.sommeGRP = sommeGRP;
    }

    /**
     * @return the sommeBudget
     */
    public int getSommeBudget() {
        return sommeBudget;
    }

    /**
     * @param sommeBudget the sommeBudget to set
     */
    public void setSommeBudget(int sommeBudget) {
        this.sommeBudget = sommeBudget;
    }

    /**
     * @return the sommeAudience
     */
    public int getSommeAudience() {
        return sommeAudience;
    }

    /**
     * @param sommeAudience the sommeAudience to set
     */
    public void setSommeAudience(int sommeAudience) {
        this.sommeAudience = sommeAudience;
    }

    /**
     * @return the laface
     */
    public face getLaface() {
        return laface;
    }

    /**
     * @param laface the laface to set
     */
    public void setLaface(face laface) {
        this.laface = laface;
    }

    /**
     * @return the mescamps
     */
    public List<campagne> getMescamps() {
        return mescamps;
    }

    /**
     * @param mescamps the mescamps to set
     */
    public void setMescamps(List<campagne> mescamps) {
        this.mescamps = mescamps;
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
     * @return the db
     */
    public Date getDb() {
        return db;
    }

    /**
     * @param db the db to set
     */
    public void setDb(Date db) {
        this.db = db;
    }

    /**
     * @return the df
     */
    public Date getDf() {
        return df;
    }

    /**
     * @param df the df to set
     */
    public void setDf(Date df) {
        this.df = df;
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




}
