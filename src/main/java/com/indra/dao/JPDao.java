package com.indra.dao;

/**
 * 
 * @author Samuel Oliveira
 * @category ProjetoRH Dao
 * @since 06-04-2018
 * @version 1.2
 * 
 */

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.indra.model.JP;
import com.indra.model.User;

public class JPDao {
	
	// parte do codigo para efetuar a persitençia no banco de dados com JPA

		private EntityManager em;
		private EntityManagerFactory emf;
		
		public JPDao() {
			emf= Persistence.createEntityManagerFactory("testeindra");
			em = emf.createEntityManager();
			System.out.println("Banco conectado");
		}
		

		// Metodo de Salvar e atualizar
		public JP saveJp(JP jp) throws Exception {

			try {
				em.getTransaction().begin();
				if (jp.getId()== null) {
					em.persist(jp); // execute insert
				} else {
					if (!em.contains(jp)) {
						if (em.find(User.class, jp.getId()) == null) {
							throw new Exception("Erro ao atualizar");
						}

					}
					jp = em.merge(jp); // execute update
				}
				em.getTransaction().commit();
			} finally {
				em.close();
			}
			return jp;
		}

		// Metodo de pesquisa de usuario
		public JP getByRegistration(final String registration) {
			JP jp = new JP();

			try {
				if (registration != null && !registration.isEmpty()) {
					String jpql = "Select m from r where m.registration = :registration";
					Query query = em.createQuery(jpql);
					query.setParameter("registration", registration);
					@SuppressWarnings("unchecked")
					List<JP> jpResult = query.getResultList();
					jp = jpResult.get(0);
				}

			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "User not found!!");

			}
			return jp;
		}

	

		// Remove JP da tabela

		public void remove(JP jp) {
			try {
				em.getTransaction().begin();
				jp = em.find(JP.class, jp.getId());
				em.remove(jp);
				em.getTransaction().commit();

			} catch (Exception e) {
				e.printStackTrace();
				em.getTransaction().rollback();
			}
		}


}

