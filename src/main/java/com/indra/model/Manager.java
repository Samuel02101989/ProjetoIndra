/**
 * 
 */
package com.indra.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
/**
 * @author Benildo Domingos
 * @since 06/04/2018
 * @category TeamModel
 * @version 1.0
 *
 */

@Entity
public class Manager extends User implements Serializable {
	

	@Column(name="IdManager")
	private Integer idManager;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	private TyperUser typeuser;


	public Manager(String senhaUser, String loginUser, Integer idManager) {
		super(senhaUser, loginUser);
		this.idManager = idManager;
	}

	public Manager(String senhaUser, String loginUser) {
		super(senhaUser, loginUser);
		this.idManager = idManager;
	}

	public Manager() {
		super();
		
		// TODO Auto-generated constructor stub
	}

	public Manager(String name, String personalDocuments, String registration, String email, String city, String genre,
			String password, String login, TyperUser typeuser) {
		super(name, personalDocuments, registration, email, city, genre, password, login, typeuser);
		// TODO Auto-generated constructor stub
	}
	

}
