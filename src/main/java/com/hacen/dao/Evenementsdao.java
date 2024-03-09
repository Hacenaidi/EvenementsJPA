package com.hacen.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.hacen.entities.Evenements;
import com.hacen.util.JPAutil;
public class Evenementsdao {
	private EntityManager entityManager=JPAutil.getEntityManager("EvenementJPA");
	//méthode ajouter d'une entité à la bd
	public void ajouter(Evenements e)
	{
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.persist(e);
	tx.commit();
	}
	//méthode modifier d'une entité à partir de la bd
	public void modifier(Evenements e)
	{
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.merge(e);
	tx.commit();
	}
	//méthode Supprimer d'une entité à partir de la bd
	public void supprimer(Evenements e)
	{
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	e=entityManager.merge(e); // important
	entityManager.remove(e);
	tx.commit();
	}
	//méthode Consulter d'une entité à partir de la bd
	public Evenements consulter(Evenements e,Object id)
	{
	return entityManager.find(e.getClass(), id);
	}
	//méthode pour lister tous les objets à partir de la bd
	public List<Evenements> listerTous() {
	List<Evenements> evenements =entityManager.createQuery("select c from Evenements c").getResultList();

	return evenements;
	}
	//méthode pour lister tous les client dont le nom contient un
	//texte donné en paramètre (pnom)
	public List<Evenements> listerParNom(String nom) {
		List<Evenements> evenements=entityManager.createQuery( "select c from Evenements c where c.nomEvenement like :pnom")
	.setParameter("pnom","%"+nom+"%").getResultList();

	return evenements; 
	}
}
