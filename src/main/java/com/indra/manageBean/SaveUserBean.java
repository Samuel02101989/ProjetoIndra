package com.indra.manageBean;


/**
 * 
 * @author Samuel Oliveira
 * @category ProjetoRH BeanUser
 * @since 12-04-2018
 * @version 1.0
 * 
 */


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.swing.JOptionPane;

import com.indra.dao.UserDAO;
import com.indra.model.User;


@ManagedBean(name= "SaveUserBean")
@ViewScoped
public class SaveUserBean {

	private UserDAO userdao;
	private User user;
	
	@PostConstruct
	public void init() {
		user = new User();
		userdao = new UserDAO();
	}
	

	//METODO GETTERS E SETTERS
	public User getUser() {	
			return user;	
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserDAO getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}
	
	//METODO CADASTRAR USUARIO O BANCO
	public void CadUser() {
		try {
			if(fieldValidation()) {
				JOptionPane.showMessageDialog(null, "empty fields");
				
			}else {
				userdao.save(user);
				JOptionPane.showMessageDialog(null, "save successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//METODO EDITAR USANDO O MESMO METEDO save POIS ESTA SENDO TRATADO UM MERGE() PARA EDIÇAO USUARIO O BANCO
	public void editUser() {
		try {
			if(fielValidationEditUser()) {
				JOptionPane.showMessageDialog(null, "empty fields");
				
			}else {
				userdao.save(user);
				JOptionPane.showMessageDialog(null, "edit successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	

	//METODO REMOVER USUARIO
	public void RemoveUser() {
		try {
			
			userdao.remove(user);
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "error removing User!!");
		}
		
	}
	
	//METODO PESQUISAR USUARIO POR CPF 
	public void PesquisaUser(String cpf) {
		try {
			
			if(user.getPersonalDocuments().isEmpty()) {
				JOptionPane.showMessageDialog(null, "error removing User!!");
				
			}else {
				userdao.getByCpf(cpf);
				JOptionPane.showMessageDialog(null, "error removing User!!");
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	//METODO DE VALIDAÇAO DE CAMPOS VAZIOS 
	private boolean fieldValidation() {
		return user.getLoginUser().isEmpty() || user.getSenhaUser().isEmpty();
	}
	
	private boolean fielValidationEditUser() {
		return user.getRegistration().isEmpty() || user.getName().isEmpty() || user.getEmail().isEmpty()
				|| user.getCity().isEmpty();
	}
}
