/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import entity.face;
import java.util.Date;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import service.gestionFace;

/**
 *
 * @author guiga
 */
public class faceConverter implements Converter {
   

     public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        // r�cup�rer le faceman de la session
        FacesContext ctx = FacesContext.getCurrentInstance();
        gestionFace fm = (gestionFace)ctx.getExternalContext().getSessionMap().get("face");


        return fm.getFaceFromId(Integer.valueOf(arg2));

    }

    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        return String.valueOf(((face)arg2).getIdFace());
    }

     




}
