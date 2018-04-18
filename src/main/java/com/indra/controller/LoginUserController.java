package com.indra.controller;

/**
 * 
 * @author Samuel Oliveira
 * @category ProjetoRH Controller
 * @since 08-04-2018
 * @version 1.3
 * 
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indra.dao.UserDAO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/user")
public class LoginUserController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String user = req.getParameter("usuario");
		String password = req.getParameter("senha");

		UserDAO userDao = new UserDAO();

	/*	if (userDao.login(user, password)) {

			req.getRequestDispatcher("/indexlogado.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("/indexerro.jsp").forward(req, resp);
			

		}*/
	}

}
