/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package service;


import entity.Client;
import entity.Regie;
import entity.Users;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 *
 * @author guigam
 */
public class connexion {
private Regie mareg= new Regie();
private Client moncli = new Client();
    private Users monuser = new Users();
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("manager");
    private EntityManager em = factory.createEntityManager();
    

    public String login(){
        

        Query query = em.createQuery("select u from Users u where u.username = ?1 and u.mdp = ?2");
        //Query query = em.createQuery("select u from Users u, Role r where r.name = ?1 AND r in elements(u.lesroles)");
           query.setParameter(1, getMonuser().getUsername());
        //query.setParameter(1, "regie");
        query.setParameter(2, getMonuser().getMdp());
        if(!query.getResultList().isEmpty()){

            Users leuser = (Users) query.getResultList().get(0);
            this.monuser = leuser; 
            if(monuser.getType().equals("Client") && monuser.getStatut().equals("a")){
            Query req = em.createQuery("select c from Client c where c.monuser= ?1");
            req.setParameter(1, monuser);
                setMoncli((Client) req.getSingleResult());

                return "menuClient";
            
            }
                
            else{
                if(monuser.getType().equals("Regie") && monuser.getStatut().equals("a")){
            Query query2 = em.createQuery("select r from Regie r where r.monuser= ?1");
            query2.setParameter(1, monuser);
             mareg = ((Regie) query2.getSingleResult());
                        return "menuRegie";
            }
              


                }
            }
                    return null;
            }

    public String nvUtil(){
        monuser.setType("Regie");
        monuser.setStatut("b");
        mareg.setMonuser(monuser);
        em.getTransaction().begin();
        em.persist(monuser);
	em.persist(mareg);
        em.getTransaction().commit();
        return "oui";
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

    /**
     * @return the factory
     */
    public EntityManagerFactory getFactory() {
        return factory;
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @return the mareg
     */
    public Regie getMareg() {
        return mareg;
    }

    /**
     * @param mareg the mareg to set
     */
    public void setMareg(Regie mareg) {
        this.mareg = mareg;
    }

    /**
     * @return the moncli
     */
    public Client getMoncli() {
        return moncli;
    }

    /**
     * @param moncli the moncli to set
     */
    public void setMoncli(Client moncli) {
        this.moncli = moncli;
    }


}
