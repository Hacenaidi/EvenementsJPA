package com.hacen.test;

import com.hacen.dao.Evenementsdao;
import com.hacen.entities.Evenements;

public class EvenementsTest {
	public static void main(String[] args) {
		//créer un objet Evenements
		Evenements e = new Evenements();
		e.setNomEvenement("Orange");
		e.setDateEvenement("01/04/2025");
		//ajouter l'objet Evenements à la BD
		Evenementsdao evenDao = new Evenementsdao();
		evenDao.ajouter(e);
		System.out.println("Appel de la méthode listerTous");
		for (Evenements ev : evenDao.listerTous())
		System.out.println(ev.getIdEvenement()+" "+ev.getNomEvenement()+" "+ev.getDateEvenement());
		System.out.println("Appel de la méthode listerParNom");
		for (Evenements ev : evenDao.listerParNom("IEEE")) {
		System.out.println(ev.getIdEvenement()+" "+ev.getNomEvenement()+" "+ev.getDateEvenement());
		}
		System.out.println("---------------------------------------------------------");
		System.out.println("Appel de la méthode modifier pour modifier le nom IEEE par Google");
		for (Evenements ev : evenDao.listerParNom("IEEE")) {
			ev.setNomEvenement("Google");
			evenDao.modifier(ev);
		}
		for (Evenements ev : evenDao.listerTous()) {
			System.out.println(ev.getIdEvenement()+" "+ev.getNomEvenement()+" "+ev.getDateEvenement());
			}
		System.out.println("---------------------------------------------------------");
		System.out.println("Appel de la méthode supprimer pour supprimer les evenements de Crepto Art");
		for (Evenements ev : evenDao.listerParNom("Creprto Art")) {
			evenDao.supprimer(ev);	
			}
		for (Evenements ev : evenDao.listerTous()) {
			System.out.println(ev.getIdEvenement()+" "+ev.getNomEvenement()+" "+ev.getDateEvenement());
			}
			
		//tester les autres méthodes de la classe ClientDao
		}
}
