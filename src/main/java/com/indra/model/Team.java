/**
 * 
 */
package com.indra.model;

import java.io.Serializable;
import java.text.DateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Benildo Domingos
 * @since 06/04/2018
 * @category ProjetoIndra TeamModel
 * @version 1.0
 *
 */


@Entity(name="team")
public class Team implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTeam;

	@Column
	private String polo;
	
	@Column
	private String date_begin;
	@Column
	private String date_end;
	@Column
	private String description;
	
	public Team(String polo, String date_begin, String date_end, String description) {
		super();
		this.polo = polo;
		this.date_begin = date_begin;
		this.date_end = date_end;
		this.description = description;
	}
	
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return idTeam;
	}


	public void setId(Integer idTeam) {
		this.idTeam = idTeam;
	}
	
	public String getPolo() {
		return polo;
	}
	public void setPolo(String polo) {
		this.polo = polo;
	}
	public String getDate_begin() {
		return date_begin;
	}
	public void setDate_begin(String date_begin) {
		this.date_begin = date_begin;
	}
	public String getDate_end() {
		return date_end;
	}
	public void setDate_end(String date_end) {
		this.date_end = date_end;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
