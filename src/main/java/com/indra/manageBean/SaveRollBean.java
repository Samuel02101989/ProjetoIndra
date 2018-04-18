/**
 * 
 */
package com.indra.manageBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.swing.JOptionPane;

import com.indra.dao.EvaluationDAO;
import com.indra.dao.RollDAO;
import com.indra.model.Evaluation;
import com.indra.model.Roll;

/**
 * @author Daniel Renaro Br�z da Silva
 * @category ProjetoIndra Bean
 * @date 12/04/2018
 * 
 * @version 1.0
 *
 */
@ManagedBean(name = "SaveRollBean")
@ViewScoped
public class SaveRollBean {

	private RollDAO rollDAO;
	private Roll roll;

	@PostConstruct
	public void init() {
		roll = new Roll();
		rollDAO = new RollDAO();
	}

	public Roll getRoll() {
		return roll;
	}

	public void setRoll(Roll roll) {
		this.roll = roll;
	}

	public RollDAO getRolldo() {
		return rollDAO;
	}

	public void setRolldao(RollDAO rollDAO) {
		this.rollDAO = rollDAO;
	}

	// Cadastrando no banco um Usuario

	public void CadasRoll() {
		try {
			if (fieldValidation()) {
				JOptionPane.showMessageDialog(null, "complete all fields");

			} else {
				rollDAO.save(this.roll);
				JOptionPane.showMessageDialog(null, "roll saved successfully");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void RemoveEvaluation() {
		try {
			rollDAO.remove(roll);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error removing Roll!!");
		}

	}

	public void findRoll(Integer idRoll) {
		try {

			rollDAO.getById(idRoll);

		} catch (Exception e) {

		}
	}

	private boolean fieldValidation() {
		return roll.getDescrpition().isEmpty() || roll.getBase_salary().toString().isEmpty();
	}

}
