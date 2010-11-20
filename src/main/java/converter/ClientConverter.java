/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import entity.Client;

import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import service.gestionClient;


/**
 *
 * @author mehdiguiga
 */
public class ClientConverter implements Converter {

    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        // r�cup�rer le faceman de la session
        FacesContext ctx = FacesContext.getCurrentInstance();
        gestionClient fm = (gestionClient)ctx.getExternalContext().getSessionMap().get("Client");
        

        return fm.getClientFromId(Integer.valueOf(arg2));
        
    }

    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        return String.valueOf(((Client)arg2).getIdClient());
    }

}
