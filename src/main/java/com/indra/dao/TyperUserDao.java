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
import com.indra.model.TyperUser;
import com.indra.model.User;

public class TyperUserDao {
	// parte do codigo para efetuar a persitençia no banco de dados com JPA

			private EntityManager em;
			private EntityManagerFactory emf;
			
			public TyperUserDao() {
				emf= Persistence.createEntityManagerFactory("testeindra");
				em = emf.createEntityManager();
				System.out.println("Banco conectado");
			}
			

			// Metodo de Salvar e atualizar typeUser
			public TyperUser saveType(TyperUser type) throws Exception {

				try {
					em.getTransaction().begin();
					if (type.getId() == null) {
						em.persist(type); // execute insert
					} else {
						if (!em.contains(type)) {
							if (em.find(TyperUser.class, type.getId()) == null) {
								throw new Exception("Erro ao atualizar");
							}

						}
						type = em.merge(type); // execute update
					}
					em.getTransaction().commit();
				} finally {
					em.close();
				}
				return type;
			}

			// Metodo de pesquisa de Tipo de usuario
			public TyperUser getById(final Integer idType) {
				TyperUser type = new TyperUser();

				try {
					if (idType!= null && !idType.toString().isEmpty()) {
						String jpql = "Select m from r where m.idType = :idType";
						Query query = em.createQuery(jpql);
						query.setParameter("idType", idType);
						@SuppressWarnings("unchecked")
						List<TyperUser> typeResult = query.getResultList();
						type = typeResult.get(0);
					}

				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "User not found!!");

				}
				return type;
			}

			// Remove Tipo de usuario da tabela

			public void remove(TyperUser type) {
				try {
					em.getTransaction().begin();
					type = em.find(TyperUser.class, type.getId().toString());
					em.remove(type);
					em.getTransaction().commit();

				} catch (Exception e) {
					e.printStackTrace();
					em.getTransaction().rollback();
				}
			}

}
