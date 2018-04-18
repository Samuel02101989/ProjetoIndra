package com.indra.model;

/**
 * 
 * @author Samuel Oliveira
 * @category ProjetoRH Model
 * @since 06-04-2018
 * @version 1.2
 * 
 */

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: People
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class People implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PEOPLE")
	private Integer id;
	
	@Column(name="NAME_PEOPLE")
	private String name;
	
	@Column(name="PERSONAL_DOCUMENTS")
	private String personalDocuments;
	
	@Column(name="REGISTRATION_PEOPLE")
	private String registration;
	
	@Column(name="EMAIL_PEOPLE")
	private String email;
	
	@Column(name="CITY_PEOPLE")
	private String city;
	
	@Column(name="GENRE_PEOPLE")
	private String genre;
	
	private static final long serialVersionUID = 1L;

	
	public People(String name, String personalDocuments, String registration, String email, String city, String genre) {
		super();
		this.name = name;
		this.personalDocuments = personalDocuments;
		this.registration = registration;
		this.email = email;
		this.city = city;
		this.genre = genre;
	}
	public People() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getPersonalDocuments() {
		return this.personalDocuments;
	}

	public void setPersonalDocuments(String personalDocuments) {
		this.personalDocuments = personalDocuments;
	}   
	public String getRegistration() {
		return this.registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}   
	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
   
}
