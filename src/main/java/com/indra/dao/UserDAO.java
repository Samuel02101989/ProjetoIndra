package com.indra.dao;

/**
 * 
 * @author Samuel Oliveira
 * @category ProjetoRH Dao
 * @since 06-04-2018
 * @version 1.1
 * 
 */

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.indra.model.User;
import com.indra.service.Encrypt;

/**
 * 
 * @author Samuel Oliveira
 * @category Projeto-RhIndra DAO
 * @since 02-04-2018
 * @version 1.2
 * 
 */
public class UserDAO {

	// parte do codigo para efetuar a persitençia no banco de dados com JPA
	private EntityManager em;
	private EntityManagerFactory emf;

	public UserDAO() {

		emf = Persistence.createEntityManagerFactory("testeindra");
		em = emf.createEntityManager();

		System.out.println("Banco conectado");
	}

	// Metodo de Salvar e atualizar
	public User save(User user) throws Exception {
		// Encrypt password
		//user.setSalt(Calendar.getInstance().getTime().toString() + "@#$%");
		//user.setSenhaUser(Encrypt.passwordToMD5(user.getSenhaUser()));

		try {
			em.getTransaction().begin();
			if (user.getIdUser() == null) {
				em.persist(user); // execute insert
			} else {
				if (!em.contains(user)) {
					if (em.find(User.class, user.getIdUser()) == null) {
						throw new Exception("Erro ao atualizar");
					}

				}
				user = em.merge(user); // execute update
			}
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return user;
	}

	// Metodo de pesquisa de usuario
	public User getByCpf(final String cpf) throws Exception {
		User user = new User();
		
			if (cpf != null && !cpf.isEmpty()) {
				String jpql = "Select u from User u where u.personalDocuments = :personalDocuments";
				Query query = em.createQuery(jpql);
				query.setParameter("personalDocuments", cpf);
				@SuppressWarnings("unchecked")
				List<User> userResult = query.getResultList();
				
				
				if (userResult != null && !userResult.isEmpty()) {
					if (userResult.get(0) != null) {
						user = userResult.get(0);
						
					}

				}else {
					throw new Exception("User not found!!");
				}

			}

		
		return user;
	}

	// Metodo logar no sistema
	public User login(String loginRh, String senhaRh) {
		
	
		if ((loginRh != null && !loginRh.isEmpty()) && (senhaRh != null && !senhaRh.isEmpty())) {
			String login = loginRh.trim().toLowerCase();
			String senha = senhaRh.trim().toLowerCase();

			String jpql = "select u from User u where u.login = :user AND u.password = :senha";
			Query query = em.createQuery(jpql);
			query.setParameter("user", login);
			query.setParameter("senha", senha);
			
			//Encrypt.passwordToMD5(senha);
			try {
				
				return (User) query.getSingleResult();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}finally {
				System.out.println("Erro de logar");
			}
			
		}
		return null;
	}

	// Remove UsuarioRh da tabela

	public void remove(User user) {
		try {
			em.getTransaction().begin();
			user = em.find(User.class, user.getIdUser());
			em.remove(user);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

}