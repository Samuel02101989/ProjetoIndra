package com.indra.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.property.access.spi.GetterMethodImpl;

import com.indra.dao.TeamDAO;
import com.indra.dao.UserDAO;
import com.indra.model.Team;
import com.indra.model.User;


@WebServlet(urlPatterns="/delete")

public class BuscaTeamController extends HttpServlet {
	
	private EntityManager em;
	private EntityManagerFactory emf;
		private static final long serialVersionUID = 1L;

		/*protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException {
			
			
			String idTeam = req.getParameter("idTeam");
			Integer buscaId = Integer.parseInt(idTeam);

			TeamDAO teamdao = new TeamDAO();
			Team team = new Team();

			try {

				team = teamdao.getByIdTeam(buscaId);
				PrintWriter print = resp.getWriter();
				print.println("<h3>Turma JP</h3>");
				print.println("<br>  Id da Turma: " +team.getId() + "<br>" + "Polo: " + team.getPolo()
						+ "<br>" + "Data de Admissão: " + team.getDate_begin()  + "<br>" + "Data Demissional: " + team.getDate_end()
						+ "<br>" +  "Descrição: "
						+ team.getDescription() );

			} catch (Exception e) {

				e.printStackTrace();
			}
			
			
			
		}	
		*/
		protected void doDelete(HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException {
			
			
			String idTeam = req.getParameter("delete");
			Integer buscaId = Integer.parseInt(idTeam);

			TeamDAO teamdao = new TeamDAO();
			Team team = new Team();

			try {
				
				teamdao.remove(team);
			}
			catch(Exception e) {
			e.printStackTrace();
		
		}
		}
}
