/**
 * 
 */
package com.indra.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Daniel Renaro Bráz da Silva
 * @category ProjetoIndra Model
 * @date 06/04/2018
 * 
 * @version 1.0
 *
 */
@Entity
@Table(name = "Roll")
public class Roll implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROLL")

	// @OneToOne(cascade = CascadeType.PERSIST)
	// @PrimaryKeyJoinColumn
	private Integer id_roll;

	@Column(name = "DESCRIPTION_ROLL")
	private String descriptionRoll;

	@Column(name = "BASE_SALARY")
	private Double base_salary;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Métodos Construtores
	public Roll() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roll(String descrpition, Double base_salary) {
		super();
		this.descriptionRoll = descrpition;
		this.base_salary = base_salary;
	}

	// Métodos Getters e Setters
	public Integer getIdRoll() {
		return id_roll;
	}

	public void setId(Integer id) {
		this.id_roll = id;
	}

	public String getDescrpition() {
		return descriptionRoll;
	}

	public void setDescrpition(String descrpition) {
		this.descriptionRoll = descrpition;
	}

	public Double getBase_salary() {
		return base_salary;
	}

	public void setBase_salary(Double base_salary) {
		this.base_salary = base_salary;
	}

}
