package com.indra.manageBean;


import java.io.IOException;

/**
 * 
 * @author Samuel Oliveira
 * @category ProjetoRH BeanLogin
 * @since 12-04-2018
 * @version 1.0
 * 
 */



import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.indra.dao.UserDAO;
import com.indra.model.User;


@ManagedBean(name = "LoginBean")
@ViewScoped
public class LoginManageBean {
	
	private String password;
	private String login;
	
	private UserDAO userDao = new UserDAO();
	private User user = new User();

	//METODO DE VERIFICAÇAO DO LOGIN E SENHA PARA EFETUAR AUTENTICAÇAO
	public void send() {
		
		user = userDao.login(login, password);
		if (user == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "User not found", "Login Error"));

		} else {
			try {
				FacesContext.getCurrentInstance().getExternalContext()
					.redirect("/ProjetoIndra/userReg.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	//METODOS GETTERS E SETTERS

	public User getUser() {
		return user;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
