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
 * Entity implementation class for Entity: TypeUser
 *
 */
@Entity

public class TyperUser implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TYPE")
	private Integer id;
	
	@Column(name="PERMISSION_TYPE")
	private String permission;
	
	@Column(name="DESCRIPTION_TYPE")
	private String description;
	private static final long serialVersionUID = 1L;

	
	
	public TyperUser(String permission, String description) {
		super();
		this.permission = permission;
		this.description = description;
	}
	
	public TyperUser() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getPermission() {
		return this.permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
   
}
