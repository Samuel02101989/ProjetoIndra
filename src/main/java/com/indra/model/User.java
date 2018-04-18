package com.indra.model;

/**
 * 
 * @author Samuel Oliveira
 * @category ProjetoRH Controller
 * @since 06-04-2018
 * @version 1.3
 * 
 */

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User extends People implements Serializable {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_USER")
	private Integer id;
	
	@Column(name="PASSWORD_USER")
	private String password;
	
	@Column(name="LOGIN_USER")
	private String login;
	
	/*@Column(name="TIPO_User")
	private UserType userType;
	*/
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
	@JoinColumn(name="TYPE_USER")
	private TyperUser typeuser;
	
	private String salt;
	
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	private static final long serialVersionUID = 1L;

	public User(String senhaUser, String loginUser) {
		super();
		this.password = senhaUser;
		this.login = loginUser;
	}

	public User(String name, String personalDocuments, String registration, String email, String city, String genre,
			String password, String login, TyperUser typeuser) {
		super(name, personalDocuments, registration, email, city, genre);
		this.password = password;
		this.login = login;
		this.typeuser = typeuser;
	}

	public User() {
		super();
	}

	

	public Integer getIdUser() {
		return this.id;
	}

	public void setIdUser(Integer idUser) {
		this.id = idUser;
	}

	public String getSenhaUser() {
		return this.password;
	}

	public void setSenhaUser(String senhaUser) {
		this.password = senhaUser;
	}

	public String getLoginUser() {
		return this.login;
	}

	public void setLoginUser(String loginUser) {
		this.login = loginUser;
	}

	public TyperUser getTypeuser() {
		return typeuser;
	}

	public void setTypeuser(TyperUser typeuser) {
		this.typeuser = typeuser;
	}

}

