package com.hacen.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Evenements implements Serializable{
@Id
@GeneratedValue (strategy=GenerationType.IDENTITY)
//pour autoincrement
private Long idEvenement;
private String nomEvenement;
private String DateEvenement;
public Evenements() {
super();
}
public Evenements(String nomEvenement, String DateEvenement) {
super();
this.nomEvenement = nomEvenement;
this.DateEvenement = DateEvenement;
}
public Long getIdEvenement() {
return idEvenement;
}
public void setIdEvenement(Long idEvenement) {
this.idEvenement = idEvenement;
}
public String getNomEvenement() {
return nomEvenement;
}
public void setNomEvenement(String nomEvenement) {
this.nomEvenement = nomEvenement;
}
public String getDateEvenement() {
return DateEvenement;
}
public void setDateEvenement(String DateEvenement) {
this.DateEvenement = DateEvenement;
}


}