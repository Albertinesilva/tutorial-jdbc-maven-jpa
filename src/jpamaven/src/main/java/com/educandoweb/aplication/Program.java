package com.educandoweb.aplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.educandoweb.dominio.Pessoa;

public class Program {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		//Inserir dados 
		/*em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();*/
		
		//Buscar por Id
		Pessoa p = em.find(Pessoa.class, 4);
		System.out.println(p);
		
		// em.getTransaction().begin();
		// Pessoa p = em.find(Pessoa.class, 1);
		// em.remove(p);
		// em.getTransaction().commit();
		
		System.out.println("Pronto!...");
		emf.close();
		em.close();
	}

}
