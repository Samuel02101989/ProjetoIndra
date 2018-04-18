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
@Table(name="Evaluation")
public class Evaluation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EVALUATION")
	private Integer id_evaluation;
	
	@Column(name = "SKILLS")
	private Double skills;
	
	@Column(name = "TECHNICAL_KNOWLEDGE")
	private Double technical_knowledge;
	
	@Column(name = "PERFORMANCE")
	private Double performance;
	
	@Column(name = "RESULT")
	private Double result;

	//Métodos Construtores
	public Evaluation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Evaluation(Double skills, Double technical_knowledge, Double performance,
			Double result) {
		super();
		this.skills = skills;
		this.technical_knowledge = technical_knowledge;
		this.performance = performance;
		this.result = result;
	}
	
	//Métodos Getters e Setters
	
	public Integer getId() {
		return id_evaluation;
	}

	public void setId(Integer id) {
		this.id_evaluation = id;
	}

		public Double getSkills() {
		return skills;
	}

	public void setSkills(Double skills) {
		this.skills = skills;
	}

	public Double getTechnical_knowledge() {
		return technical_knowledge;
	}

	public void setTechnical_knowledge(Double technical_knowledge) {
		this.technical_knowledge = technical_knowledge;
	}

	public Double getPerformance() {
		return performance;
	}

	public void setPerformance(Double performance) {
		this.performance = performance;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
