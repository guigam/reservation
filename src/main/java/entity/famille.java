/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author mehdiguiga
 */
@Entity
public class famille implements Serializable{
@Id
private int Idfamille;
private String nomFmille;
private int codefamille;
private String Description;
}
