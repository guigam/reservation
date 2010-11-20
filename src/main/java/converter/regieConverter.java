/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import entity.Regie;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import service.gestionRegie;
;

/**
 *
 * @author guigam
 */

public class regieConverter implements Converter {

    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        // r�cup�rer le faceman de la session
        FacesContext ctx = FacesContext.getCurrentInstance();
        gestionRegie fm = (gestionRegie)ctx.getExternalContext().getSessionMap().get("Regie");


        return fm.getRegieFromId(Integer.valueOf(arg2));

    }

    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        return String.valueOf(((Regie)arg2).getID());
    }

}



