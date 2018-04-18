/**
 * 
 */
package com.indra.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indra.dao.ManagerDAO;
import com.indra.dao.TeamDAO;
import com.indra.model.Manager;
import com.indra.model.Team;
import com.indra.model.TyperUser;

/**
 * @author befernandes
 *
 */



@WebServlet(urlPatterns = "/Manager")

public class ManagerController  extends HttpServlet {

	
private static final long serialVersionUID = 1L;
   
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		String savename = req.getParameter("name");
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
		
		Manager manager = new Manager();
		manager.setTypeuser(type);
		
		
		ManagerDAO mg = new ManagerDAO();
		
		try {
			
			mg.saveManager(new Manager(savename, saveDoc, saveRegist, saveemail, savecity, savegenre, savepass, savelogin,type));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}

