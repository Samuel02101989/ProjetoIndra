package com.indra.controller;
/**
 * 
 * @author Samuel Oliveira
 * @category Projeto-RhIndra DAO
 * @since 05-04-2018
 * @version 1.2
 * 
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestMain {

	public static void main(String[] args) {

		EntityManager em;
		EntityManagerFactory emf;

		emf = Persistence.createEntityManagerFactory("testeindra");
		em = emf.createEntityManager();
		
		em.close();
		emf.close();

		System.out.println("Banco conectado");

	}

}
