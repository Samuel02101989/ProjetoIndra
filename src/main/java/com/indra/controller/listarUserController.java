package com.indra.controller;

/**
 * 
 * @author Samuel Oliveira
 * @category ProjetoRH Controller
 * @since 08-04-2018
 * @version 1.0
 * 
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indra.dao.UserDAO;
import com.indra.model.User;

@WebServlet(urlPatterns = "/listarUser")
public class listarUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String cpf = req.getParameter("cpf");

		UserDAO userdao = new UserDAO();
		User user = new User();

		try {

			user = userdao.getByCpf(cpf);
			PrintWriter print = resp.getWriter();
			print.println("<h3>Usuario</h3>");
			print.println("<p>O Nome do usuario é: " + user.getName() + "<br>" + "O Login é: " + user.getLoginUser()
					+ "<br>" + "A cidade do Usuario: " + user.getCity() + "<br>" + "A cidade é: " + user.getEmail()
					+ "<br>" + "Matricula do JP: " + user.getRegistration() + "<br>" + "Password: "
					+ user.getSenhaUser() + "<br>" + "Login user: " + user.getLoginUser() + "</p>");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
