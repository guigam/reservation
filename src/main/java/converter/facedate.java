/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import java.util.Date;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import service.gestionFace;

/**
 *
 * @author guiga
 */
public class facedate {


     public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        // r�cup�rer le faceman de la session
        FacesContext ctx = FacesContext.getCurrentInstance();
        gestionFace fm = (gestionFace)ctx.getExternalContext().getSessionMap().get("face");


        return fm.getFaceFromDate(new Date(arg2));

    }

}
