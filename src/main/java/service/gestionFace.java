/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import entity.Client;
import entity.Regie;


import entity.campagne;
import entity.face;


import java.awt.Component;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.component.*;
import javax.persistence.*;
import org.hibernate.Session;




    /**
 *
 * @author guigam
 */
public class gestionFace {
      private List<SelectItem> lesfaces = new ArrayList<SelectItem>();
    private List<face> faces = new LinkedList<face>();
     private face laface = new face();
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("manager");
    private EntityManager em = factory.createEntityManager();
    private UIData dataTable;
    private Date d1;
    private Date d2;
    private String idface = null;
    private String format = null;
    private String type = null;

      private int nbrface;
 

Regie mareg  = ((connexion)FacesContext.getCurrentInstance().getExternalContext()
               .getSessionMap().get( "log")).getMareg();
Client monCLi  = ((connexion)FacesContext.getCurrentInstance().getExternalContext()
               .getSessionMap().get( "log")).getMoncli();


    public List<face> getmesfaces(){
          Query query =   getEm().createQuery("SELECT f FROM face f where  f.etat = 'a' and f.maregie = ?1 ");
    
           query.setParameter(1,mareg);

        for (face f : (List<face>)query.getResultList()) {
            getFaces().add(f);
        }
          return getFaces();

        }


    public Collection<campagne> getfacec(){
        Query query = em.createQuery("select c from campagne c where c.idCampagne = 1 ");
        
        Collection<campagne> mesface = query.getResultList();
        
        return mesface;
        
        }


        public List<Client> getclientPermission(){
            List<Client> cli = new LinkedList<Client>();
            if (!cli.isEmpty()){

                    face f = (face) dataTable.getRowData();
            f.setPFC(cli);

        em.getTransaction().begin();
	em.merge(f);
	em.getTransaction().commit();

        
        }

            return cli;

        
      }




	public List<SelectItem> getfacesItems() {
		List<SelectItem> facess = new ArrayList<SelectItem>();
                Query query =  em.createQuery("select f from face f");
                 List<face> f =  (List<face>) query.getResultList();
                for(face ff : f)
                    facess.add(new SelectItem(ff,ff.getIdFace()));
                return facess;
		
	}


        public List<SelectItem> getfaceClientDispo(){

         faces = lesdispo();
         for(face f :faces){
          getLesfaces().add(new SelectItem(f, f.getIdFace()+"  -> "+f.getFormat()+"->"+f.getMaregie().getNom()));

         }
             return (List<SelectItem>) getLesfaces();

        }


   
       
        public List<face> getmesDispo(){
    Query query = em.createQuery("select f from face f ");
    
     
    for (face f : (List<face>)query.getResultList()) {
            faces.add(f);
        }
                      return  faces;


    }

public List<SelectItem> getListTypes() {
    Query query = em.createQuery("select DISTINCT f from face f ");
        LinkedList<SelectItem> types = new LinkedList<SelectItem>();
        // On it�re sur les RequestTypes existants, ayant un Id et un Label
        for (face f : (List<face>)query.getResultList()) {
            types.add(new SelectItem(f.getType()));
        }
        return types;
    }
public List<SelectItem> getListFormat() {
    Query query = em.createQuery("select DISTINCT f from face f ");
        LinkedList<SelectItem> format = new LinkedList<SelectItem>();
        // On it�re sur les RequestTypes existants, ayant un Id et un Label
        for (face f : (List<face>)query.getResultList()) {
            format.add(new SelectItem(f.getFormat()));
        }
        return format;
    }

        public List<face> getmesfacedispo(){
           
                 Query q = em.createQuery("select f from face f where f.etat ='a' and f.dispo = '1'");
        Query query = em.createQuery("select faceCampagne from campagne c where c.dateDebut >= ?1 and c.dateFin < ?2");
        query.setParameter(1, d1);
        query.setParameter(2, d2);
            List<face> faceresult = new LinkedList<face>();
            List<face> facegentity = new LinkedList<face>();

            faceresult = query.getResultList();
            facegentity = q.getResultList();

            Iterator i = facegentity.iterator();
            while(i.hasNext()){
            Object o = i.next();
            if(!faceresult.contains(o))
            faces.add((face) o);
          
            
            }
            return faces;
}
 
        public List<face> lesdispo(){

          List<face> f = new LinkedList<face>();

                 Query q = em.createQuery("select f from face f where f.etat ='a' and f.dispo = '1'");
        Query query = em.createQuery("select faceCampagne from campagne c where c.dateDebut >= ?1 or c.dateFin <= ?2 ");
            query.setParameter(1, d1, TemporalType.DATE);
            query.setParameter(2, d2, TemporalType.DATE);

            List<face> faceresult = new LinkedList<face>();
            List<face> facegentity = new LinkedList<face>();
            faces.clear();
            faceresult = query.getResultList();
            facegentity = q.getResultList();
            if (faceresult.isEmpty()){
                faces = facegentity;
            }else {


            if (facegentity.removeAll(faceresult)){
                faces = facegentity;
            }
            }

            setNbrface(faces.size());
            return faces;
        }


       

     public String createface(){
     
        face maface = new face();

        maface.setIdFace(getLaface().getIdFace());
        maface.setFormat(getLaface().getFormat());
        maface.setType(getLaface().getType());
        maface.setGrp(getLaface().getGrp());
        maface.setNoteQualitative(getLaface().getNoteQualitative());
        maface.setCoordonneX(getLaface().getCoordonneX());
        maface.setCoordonneY(getLaface().getCoordonneY());
        maface.setAudience(getLaface().getAudience());
        maface.setAdresse(getLaface().getAdresse());
        maface.setPrixPublic(getLaface().getPrixPublic());
        maface.setDispo(getLaface().isDispo());
        maface.setEtat("a");
        maface.setMaregie(mareg);
       

        
         try {
        em.getTransaction().begin();
	em.persist(maface);
	em.getTransaction().commit();

        return "valid";


        }catch (Exception e) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                        "Error creating user!",
                                                        "Unexpected error when creating your account.  Please contact the system Administrator");
                return null;
        }
    }




    public String goEditface(){
      laface = (face) dataTable.getRowData();
        return "editface";
    }


      public String gofaceregie(){
      laface = (face) dataTable.getRowData();
        return "faceclient";
    }



    
    public String editeLaFace(){
     
   
       em.getTransaction().begin();
	em.merge(laface );
	em.getTransaction().commit();
        return "valid";
        
   }

    public String delete(){
        laface  = (face) dataTable.getRowData();
        laface.setEtat("d");
        em.getTransaction().begin();
	em.merge(laface );
	em.getTransaction().commit();
        return "valid";
    }



    public List<face> marecherche(){
        String id = laface.getIdFace();
        Query query = em.createQuery("select f from face f where f.idFace =?1 and f.format = ?2 and f.etat = 'a' and f.maregie = ?3   ");
        query.setParameter(1, idface);
        query.setParameter(2, format);
        query.setParameter(3, mareg);
       

        for (face f : (List<face>)query.getResultList()) {
            faces.add(f);
        }
          return faces;

    }


    /**
     * @param laface the laface to set
     */
    public void setLaface(face laface) {
        this.laface = laface;
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
     * @return the laface
     */
    public face getLaface() {
        return laface;
    }

    /**
     * @return the faces
     */
    public List<face> getFaces() {
        return faces;
    }

    /**
     * @param faces the faces to set
     */
    public void setFaces(List<face> faces) {
        this.faces = faces;
    }
     public Object getFaceFromId(Integer valueOf) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
      public Object getFaceFromDate(Date valueOf) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @return the d1
     */
    public Date getD1() {
        return d1;
    }

    /**
     * @param d1 the d1 to set
     */
    public void setD1(Date d1) {
        this.d1 = d1;
    }

    /**
     * @return the d2
     */
    public Date getD2() {
        return d2;
    }

    /**
     * @param d2 the d2 to set
     */
    public void setD2(Date d2) {
        this.d2 = d2;
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
     * @return the format
     */
    public String getFormat() {
        return format;
    }

    /**
     * @param format the format to set
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * @return the idface
     */
    public String getIdface() {
        return idface;
    }

    /**
     * @param idface the idface to set
     */
    public void setIdface(String idface) {
        this.idface = idface;
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
     * @return the lesfaces
     */
    public List<SelectItem> getLesfaces() {
        return lesfaces;
    }

    /**
     * @param lesfaces the lesfaces to set
     */
    public void setLesfaces(List<SelectItem> lesfaces) {
        this.lesfaces = lesfaces;
    }
       

    

}
