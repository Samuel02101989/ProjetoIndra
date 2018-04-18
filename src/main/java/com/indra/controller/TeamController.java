/**
 * 
 */
package com.indra.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indra.dao.TeamDAO;
import com.indra.model.Team;

/**
 * @author befernandes
 *
 */

//@WebServlet(urlPatterns = "indexListTteam")
public class TeamController extends HttpServlet {


	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//req.getRequestDispatcher("WEB-INF/indexTeam.jsp").forward(req, resp);
		
		String savepolo = req.getParameter("polo");
		String savedatebegin = req.getParameter("date_begin");
		String savedateend = req.getParameter("date_end");
		String savedescription = req.getParameter("description");

		TeamDAO tm = new TeamDAO();

		try {

			tm.saveTeam(new Team(savepolo, savedatebegin, savedateend, savedescription));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
