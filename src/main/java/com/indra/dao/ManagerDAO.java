/**
 * 
 */
package com.indra.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.indra.model.Manager;
import com.indra.model.User;

/**
 * @author befernandes
 *
 */
public class ManagerDAO {

	private EntityManager em;
	private EntityManagerFactory emf;
	
	public ManagerDAO() {
		emf= Persistence.createEntityManagerFactory("testeindra");
		em = emf.createEntityManager();
		System.out.println("Banco conectado");
	}
	

	// Metodo de Salvar e atualizar
	public Manager saveManager(Manager mg) throws Exception {

		try {
			em.getTransaction().begin();
			if (mg.getIdUser()== null) {
				em.persist(mg); // execute insert
			} else {
				if (!em.contains(mg)) {
					if (em.find(Manager.class, mg.getId()) == null) {
						throw new Exception("Erro ao atualizar");
					}

				}
				mg = em.merge(mg); // execute update
			}
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return mg;
	}

	// Metodo de pesquisa de usuario
	public Manager getByRegistration(final String registration) {
		Manager mg = new Manager("ms","",1);

		try {
			if (registration != null && !registration.isEmpty()) {
				String jpql = "Select m from r where m.registration = :registration";
				Query query = em.createQuery(jpql);
				query.setParameter("registration", registration);
				@SuppressWarnings("unchecked")
				List<Manager> mgResult = query.getResultList();
				mg = mgResult.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "User not found!!");

		}
		return mg;
	}



	// Remove JP da tabela

	public void remove(Manager mg) {
		try {
			em.getTransaction().begin();
			mg = em.find(Manager.class, mg.getId());
			em.remove(mg);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

}
