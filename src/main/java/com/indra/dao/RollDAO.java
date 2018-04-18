/**
 * 
 */
package com.indra.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.indra.model.Roll;

/**
 * @author Daniel Renaro Bráz da Silva
 * @category ProjetoIndra Model
 * @date 06/04/2018
 * 
 * @version 1.0
 *
 */
public class RollDAO {
	// parte do codigo para efetuar a persitençia no banco de dados com JPA

	private EntityManager em;
	private EntityManagerFactory emf;
	
	public RollDAO() {
		emf= Persistence.createEntityManagerFactory("testeindra");
		em = emf.createEntityManager();
		System.out.println("Banco conectado");
	}
	

	// Metodo de Salvar e atualizar
	public Roll save(Roll roll) throws Exception {

		try {
			em.getTransaction().begin();
			if (roll.getIdRoll()== null) {
				em.persist(roll); // execute insert
			} else {
				if (!em.contains(roll)) {
					if (em.find(Roll.class, roll.getIdRoll()) == null) {
						throw new Exception("Erro ao atualizar");
					}

				}
				roll = em.merge(roll); // execute update
			}
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return roll;
	}

	// Metodo de pesquisa de roll
	public Roll getById(final Integer id_roll) throws Exception {
		Roll roll = new Roll();

			if (id_roll != null) { 
				String jpql = "Select r from Roll r where r.id_roll = :id_roll";
				Query query = em.createQuery(jpql);
				query.setParameter("id_roll", id_roll);
				@SuppressWarnings("unchecked")
				List<Roll> rollResult = query.getResultList();
				if (rollResult != null && !rollResult.isEmpty()) {
					if (rollResult.get(0) != null) {
						roll = rollResult.get(0);
					}

				} else {
					throw new Exception("User not found!!");
				}
			}
			return roll;
		}

	// Remove Roll da tabela

	public void remove(Roll roll) {
		try {
			em.getTransaction().begin();
			roll = em.find(Roll.class, roll.getIdRoll());
			em.remove(roll);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	
	// Pesquisa todos Rolls da tabela  TA OK
	   @SuppressWarnings("unchecked")
	public ArrayList<Roll> findAll() throws Exception{
		   ArrayList<Roll> rolls = null;
		   try {
			   String jpql = "Select ro from Roll ro";
				Query query = em.createQuery(jpql);
				rolls =  (ArrayList<Roll>) query.getResultList();
	            em.getTransaction().commit();
	        } catch (Exception e) {
	        	
	        } 
	        return rolls;
	    }
}
