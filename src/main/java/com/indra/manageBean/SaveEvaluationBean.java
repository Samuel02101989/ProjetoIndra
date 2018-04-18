/**
 * 
 */
package com.indra.manageBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.swing.JOptionPane;

import com.indra.dao.EvaluationDAO;
import com.indra.model.Evaluation;

/**
 * @author Daniel Renaro Br�z da Silva
 * @category ProjetoIndra Bean
 * @date 12/04/2018
 * 
 * @version 1.0
 *
 */
@ManagedBean(name = "SaveEvaluationBean")
@ViewScoped
public class SaveEvaluationBean {

	private EvaluationDAO evaluationDAO;
	private Evaluation evaluation;

	@PostConstruct
	public void init() {
		evaluation = new Evaluation();
		evaluationDAO = new EvaluationDAO();
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	public EvaluationDAO getEvaluationdao() {
		return evaluationDAO;
	}

	public void setEvaluationdao(EvaluationDAO evaluationDAO) {
		this.evaluationDAO = evaluationDAO;
	}

	// Cadastrando no banco um Usuario

	public void CadasEvaluation() {
		try {
			if (fieldValidation()) {
				JOptionPane.showMessageDialog(null, "complete all fields");

			} else {
				evaluationDAO.save(this.evaluation);
				JOptionPane.showMessageDialog(null, "evaluation saved successfully");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void RemoveEvaluation() {
		try {
			evaluationDAO.remove(evaluation);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error removing Evaluation!!");
		}

	}

	public void findEvaluation(Integer idEvaluation) {
		try {

			evaluationDAO.getById(idEvaluation);

		} catch (Exception e) {

		}
	}

	private boolean fieldValidation() {
		return evaluation.getPerformance().toString().isEmpty() || evaluation.getSkills().toString().isEmpty()
				|| evaluation.getTechnical_knowledge().toString().isEmpty()
				|| evaluation.getResult().toString().isEmpty();
	}

}
