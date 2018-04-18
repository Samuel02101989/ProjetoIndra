package com.indra.model;

public enum UserType {

	ADM("adm") , USER("user");
	
	private String descricao;
	
	UserType(String descricao){
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
}
