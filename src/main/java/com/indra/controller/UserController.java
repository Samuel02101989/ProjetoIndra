package com.indra.controller;

/**
 * 
 * @author Samuel Oliveira
 * @category ProjetoRH Controller
 * @since 06-04-2018
 * @version 1.2
 * 
 */

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indra.dao.TeamDAO;
import com.indra.model.Team;



@WebServlet(urlPatterns = "/homeuser")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
	
		String savepolo = req.getParameter("polo");
		String savedatebegin = req.getParameter("date_begin");
		String savedateend = req.getParameter("date_end");
		String savedescription = req.getParameter("description");
		/*String savename = req.getParameter("name");
		String saveDoc = req.getParameter("doc");
		String saveRegist = req.getParameter("registration");
		String saveemail = req.getParameter("email");
		String savecity = req.getParameter("city");
		String savegenre = req.getParameter("genre");
		String savepass = req.getParameter("password");
		String savelogin = req.getParameter("login");
		String savedescription = req.getParameter("descriptions");
		String savepermission = req.getParameter("permission");

		TyperUser type = new TyperUser();
		type.setDescription(savedescription);
		type.setPermission(savepermission);

		TyperUserDao typerdao = new TyperUserDao();

		try {
			typerdao.saveType(new TyperUser(savepermission, savedescription));

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		Manager manager = new Manager();
		manager.setTypeuser(type);

		*/
		TeamDAO tm = new TeamDAO();
		
		try {

			
			tm.saveTeam(new Team(savepolo,savedatebegin,savedateend, savedescription));

		//	dao.save(new User(savename, saveDoc, saveRegist, saveemail, savecity, savegenre, savepass, savelogin, type));


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


