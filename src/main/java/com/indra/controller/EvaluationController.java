package com.indra.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indra.dao.EvaluationDAO;
import com.indra.model.Evaluation;

/**
 * @author Daniel Renaro da Silva
 * @category ProjetoIndra Model
 * @date 09/04/2018
 * 
 * @version 1.0
 *
 */
@WebServlet(urlPatterns = "/evaluation")
public class EvaluationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final Double SKILLS = 0.2;
	public static final Double TECHNICAL_KNOWLEDGE = 0.4;
	public static final Double PERFORMANCE = 0.4;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String skills = req.getParameter("skills");
		Double saveSkills = Double.parseDouble(skills);

		String technical_knowledge = req.getParameter("technical_knowledge");
		Double saveTecKno = Double.parseDouble(technical_knowledge);

		String performance = req.getParameter("performance");
		Double savePerformance = Double.parseDouble(performance);

		// Formula de atribuição de notas com seus devidos pesos

		Double saveResult = ((saveSkills * SKILLS) + (saveTecKno * TECHNICAL_KNOWLEDGE)
				+ (savePerformance * PERFORMANCE));

		EvaluationDAO evaluationDAO = new EvaluationDAO();
		try {
			evaluationDAO.save(new Evaluation(saveSkills, saveTecKno, savePerformance, saveResult));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// doDelete
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id_evaluation = req.getParameter("id_evaluation");
		Integer remove_id_evaluation = Integer.parseInt(id_evaluation);

		EvaluationDAO evaluationDAO = new EvaluationDAO();
		Evaluation evaluation = new Evaluation();
		evaluation.setId(remove_id_evaluation);
		try {
			evaluationDAO.remove(evaluation);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
 	// doGet
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id_evaluation = req.getParameter("id_evaluation");
		Integer busca_id_evaluation = Integer.parseInt(id_evaluation);

		EvaluationDAO evaluationDAO = new EvaluationDAO();
		Evaluation evaluation = new Evaluation();
		try {
			evaluation = evaluationDAO.getById(busca_id_evaluation);
			PrintWriter print = resp.getWriter();
			print.println("<h3>Evaluation</h3>");
			print.println("<p>O id é: " + evaluation.getId() +
						  "<br>" + "A nota Skills é: " + evaluation.getSkills()
						+ "<br>" + "A nota Performance é: " + evaluation.getPerformance() + 
						  "<br>" + "A nota Tecnhical Knowledge é: " + evaluation.getTechnical_knowledge() +
						  "<br>" + "A nota Result é: " + evaluation.getResult()	+ 
						  "<br> </p>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	/*	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EvaluationDAO evaluationDAO = new EvaluationDAO();
		ArrayList<Evaluation> evaluations = null;
		try {
			evaluations = evaluationDAO.findAll();
			PrintWriter print = resp.getWriter();
			for(Evaluation eva : evaluations) {
			print.println("<h3>Evaluations</h3>");
			print.println("<p>O id é: " + eva.getId() +
						  "<br>" + "A nota Skills é: " + eva.getSkills()
						+ "<br>" + "A nota Performance é: " + eva.getPerformance() + 
						  "<br>" + "A nota Tecnhical Knowledge é: " + eva.getTechnical_knowledge() +
						  "<br>" + "A nota Result é: " + eva.getResult()	+ 
						  "<br> </p>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
		*/
	
}