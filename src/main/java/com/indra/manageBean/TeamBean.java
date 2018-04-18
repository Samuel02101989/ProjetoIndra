package com.indra.manageBean;



/**
 * 
 * @author Benildo Domingos
 * @category ProjetoRH ManagerBean
 * @since 12-04-2018
 * @version 1.0
 * 
 */

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.annotation.WebServlet;
import javax.swing.JOptionPane;

import com.indra.dao.JPDao;
import com.indra.dao.TeamDAO;
import com.indra.model.JP;
import com.indra.model.Team;

@ManagedBean(name = "TeamBean")
@ViewScoped
//@WebServlet(urlPatterns = "/team")
public class TeamBean {

	private TeamDAO teamdao;
	private Team team;

	@PostConstruct
	public void init() {
		team = new Team();
		teamdao = new TeamDAO();
	}

	public TeamDAO getteamdao() {
		return teamdao;
	}

	public void setTeamDAO(TeamDAO teamdao) {
		this.teamdao = teamdao;
	}

	public Team getteam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public void saveBeanTeam() {
		try {

			if(fieldValidation()) {
				
				JOptionPane.showMessageDialog(null, "complete all fields!!");
				
			}else {
				teamdao.saveTeam(team);
				JOptionPane.showMessageDialog(null, "Team registered successfully!!");
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error registering Team!!");
		}
	}

	public void removeTeam() {
		
		try {
			teamdao.remove(team);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error removing Team!!");
		}
	}

	public void findTeam(Integer idTeam) {
		try {

			teamdao.getByIdTeam(idTeam);

		} catch (Exception e) {

		}
	}

	private boolean fieldValidation() {
		return team.getId().equals("") || team.getPolo().isEmpty() || team.getDate_begin().isEmpty()
				|| team.getDate_end().isEmpty() || team.getDescription().isEmpty() ;
	}

}
