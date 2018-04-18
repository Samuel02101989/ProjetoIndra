package com.indra.controller;
/**
 * 
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indra.dao.RollDAO;
import com.indra.model.Evaluation;
import com.indra.model.Roll;
/**
* @author Daniel Renaro Brï¿½z da Silva
* @category ProjetoIndra Controller
* @date 09/04/2018
* 
* @version 1.0
*
*/
@WebServlet(urlPatterns = "/roll")
public class RollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String saveDescription = req.getParameter("descriptionRoll");
		String BaseSalary = req.getParameter("base_salary");
		Double saveBaseSalary = Double.parseDouble(BaseSalary);
		
		RollDAO rollDao = new RollDAO();
		try {
			rollDao
			.save(new Roll(saveDescription, saveBaseSalary));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// doDelete
		protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			String id_Roll = req.getParameter("id_Roll");
			Integer remove_id_Roll = Integer.parseInt(id_Roll);

			RollDAO rollDAO = new RollDAO();
			Roll roll = new Roll();
			roll.setId(remove_id_Roll);
			try {
				rollDAO.remove(roll);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/*
	 	// doGet
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			String id_Roll = req.getParameter("id_Roll");
			Integer busca_id_Roll = Integer.parseInt(id_Roll);

			RollDAO rollDAO = new RollDAO();
			Roll roll = new Roll();
			try {
				roll = rollDAO.getById(busca_id_Roll);
				PrintWriter print = resp.getWriter();
				print.println("<h3>Roll</h3>");
				print.println("<p>O id é: " + roll.getIdRoll() +
							  "<br>" + "A Descrição do Roll é: " + roll.getDescrpition()
							+ "<br>" + "A base de Salaário é: " + roll.getBase_salary() + 
							  "<br> </p>");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
			
			*/
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			RollDAO rollDAO = new RollDAO();
			ArrayList<Roll> rolls = null;
			try {
				rolls = rollDAO.findAll();
				for(Roll roll : rolls) {
					PrintWriter print = resp.getWriter();
					print.println("<h3>Roll</h3>");
					print.println("<p>O id é: " + roll.getIdRoll() +
								  "<br>" + "A Descrição do Roll é: " + roll.getDescrpition()
								+ "<br>" + "A base de Salaário é: " + roll.getBase_salary() + 
								  "<br> </p>");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
		
		
	}