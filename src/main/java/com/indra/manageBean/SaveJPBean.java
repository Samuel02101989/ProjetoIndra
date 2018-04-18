package com.indra.manageBean;

/**
 * 
 * @author Samuel Oliveira
 * @category ProjetoRH BeanJP
 * @since 12-04-2018
 * @version 1.0
 * 
 */


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.swing.JOptionPane;

import com.indra.dao.JPDao;
import com.indra.model.JP;

@ManagedBean(name = "SaveJPBean")
@ViewScoped
public class SaveJPBean {

	private JPDao jpdao;
	private JP jp;

	@PostConstruct
	public void init() {
		jp = new JP();
		jpdao = new JPDao();
	}

	//METODOS GETTERS E SETTERS
	
	public JPDao getJpdao() {
		return jpdao;
	}

	public void setJpdao(JPDao jpdao) {
		this.jpdao = jpdao;
	}

	public JP getJp() {
		return jp;
	}

	public void setJp(JP jp) {
		this.jp = jp;
	}

	//METODO PARA SALVAR UM JP NO BANCO
	public void saveBeanJP() {
		try {

			if(fieldValidation()) {
				
				JOptionPane.showMessageDialog(null, "complete all fields!!");
				
			}else {
				jpdao.saveJp(jp);
				JOptionPane.showMessageDialog(null, "JP registered successfully!!");
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error registering JP!!");
		}
	}

	//METODO REMOVE JP DO BANCO
	public void removeJP() {
		
		try {
			
			jpdao.remove(jp);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error removing JP!!");
		}
	}
	
	//METODO PARA PROCURAR UM JP COM BASE NA MATRICULA(registration)

	public void findJP(String registration) {
		try {
			if(jp.getRegistration().isEmpty()) {
				JOptionPane.showMessageDialog(null, "empty field");
			}else {
				jpdao.getByRegistration(registration);				
				System.out.println("Find JP!!");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "JP not found!!");
		}
	}

	//METODO DE VALIDAÇAO DE CAMPOS VAZIOS
	private boolean fieldValidation() {
		return jp.getName().isEmpty() || jp.getPersonalDocuments().isEmpty() || jp.getRegistration().isEmpty()
				|| jp.getEmail().isEmpty() || jp.getCity().isEmpty() || jp.getGenre().isEmpty()
				|| jp.getAge().toString().isEmpty() || jp.getCurrentSalary().toString().isEmpty()
				|| jp.getCourse().isEmpty();
	}

}
