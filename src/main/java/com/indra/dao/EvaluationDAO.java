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

import com.indra.model.Evaluation;

/**
 * @author Daniel Renaro Bráz da Silva
 * @category ProjetoIndra Model
 * @date 06/04/2018
 * 
 * @version 1.0
 *
 */
public class EvaluationDAO {
	// parte do codigo para efetuar a persitençia no banco de dados com JPA

	private EntityManager em;
	private EntityManagerFactory emf;

	public EvaluationDAO() {
		emf = Persistence.createEntityManagerFactory("testeindra");
		em = emf.createEntityManager();
		System.out.println("Banco conectado");
	}

	// Metodo de Salvar e atualizar
	public Evaluation save(Evaluation evaluation) throws Exception {

		try {
			em.getTransaction().begin();
			if (evaluation.getId() == null) {
				em.persist(evaluation); // execute insert
			} else {
				if (!em.contains(evaluation)) {
					if (em.find(Evaluation.class, evaluation.getId()) == null) {
						throw new Exception("Erro ao atualizar");
					}
				}
				evaluation = em.merge(evaluation); // execute update
			}
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return evaluation;
	}

	// Metodo de pesquisa de evaluation
	public Evaluation getById(final Integer idEvaluation) throws Exception {
		Evaluation evaluation = new Evaluation();

		if (idEvaluation != null && !idEvaluation.toString().isEmpty()) {
			String jpql = "Select ev from Evaluation ev where ev.id_evaluation = :id_evaluation";
			Query query = em.createQuery(jpql);
			query.setParameter("id_evaluation", idEvaluation);
			@SuppressWarnings("unchecked")
			List<Evaluation> evaluationResult = query.getResultList();

			if (evaluationResult != null && !evaluationResult.isEmpty()) {
				if (evaluationResult.get(0) != null) {
					evaluation = evaluationResult.get(0);
				}

			} else {
				throw new Exception("User not found!!");
			}
		}
		return evaluation;
	}
	
	// Remove Evaluation da tabela

	public void remove(Evaluation evaluation) {
		try {
			em.getTransaction().begin();
			evaluation = em.find(Evaluation.class, evaluation.getId());
			em.remove(evaluation);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	} 
	// Pesquisa todos Evaluations da tabela
	
	   @SuppressWarnings("unchecked")
	public ArrayList<Evaluation> findAll() throws Exception{
		   ArrayList<Evaluation> evaluations = null;
		   try {
			   String jpql = "Select ev from Evaluation ev";
				Query query = em.createQuery(jpql);
				evaluations =  (ArrayList<Evaluation>) query.getResultList();
	            em.getTransaction().commit();
	        } catch (Exception e) {
	        	
	        } 
	        return evaluations;
	    }
}