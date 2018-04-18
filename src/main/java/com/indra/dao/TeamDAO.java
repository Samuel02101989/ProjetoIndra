/**
 * 
 */
package com.indra.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.annotation.WebServlet;

import com.indra.model.Team;
import com.indra.model.User;

/**
 * @author befernandes
 *
 */


public class TeamDAO {

	
		private EntityManager em;
		private EntityManagerFactory emf;
		
		public TeamDAO() {
			emf= Persistence.createEntityManagerFactory("testeindra");
			em = emf.createEntityManager();
			System.out.println("Banco conectado");
		}
		

		// Metodo de Salvar e atualizar
		public Team saveTeam(Team tm) throws Exception {

			try {
				em.getTransaction().begin();
				if (tm.getId()== null) {
					em.persist(tm); // execute insert
				} else {
					if (!em.contains(tm)) {
						if (em.find(Team.class, tm.getId()) == null) {
							throw new Exception("Erro ao atualizar");
						}

					}
					tm = em.merge(tm); // execute update
				}
				em.getTransaction().commit();
			} finally {
				em.close();
			}
	
			return tm;
		}

		// Remove JP da tabela

		public void remove(Team tm) {
			try {
				em.getTransaction().begin();
				tm = em.find(Team.class, tm.getId());
				em.remove(tm);
				em.getTransaction().commit();

			} catch (Exception e) {
				e.printStackTrace();
				em.getTransaction().rollback();
			}
		}
		
		
		 /*public void removeById(final int idTeam) {
             try {
                      Team team = getByIdTeam(idTeam);
                      removeById(idTeam);
             } catch (Exception ex) {
                      ex.printStackTrace();
             }*/
   //}
		
		
		
		// Metodo de pesquisa de Team
		public Team getByIdTeam(final Integer idTeam) throws Exception {
			Team team = new Team();
			
			if (idTeam != null && !idTeam.toString().isEmpty()) {
				String jpql = "SELECT tm FROM team tm WHERE tm.idTeam = :idTeam";
				Query query = em.createQuery(jpql);
				query.setParameter("idTeam", idTeam);
				@SuppressWarnings("unchecked")
				List<Team> teamResult = query.getResultList();
				if (teamResult != null && !teamResult.isEmpty()) {
					if(teamResult.get(0) != null) {
						team = teamResult.get(0);
					}
					
					
				}else {
					throw new Exception("Team not found");
				}
			}
			return team;
		}

	}

