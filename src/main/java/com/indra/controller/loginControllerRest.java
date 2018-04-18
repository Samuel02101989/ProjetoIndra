/*package com.indra.controller;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.indra.dao.UserDAO;
import com.indra.model.User;


@Path("/anderson")
public class loginControllerRest {
	
	@Path("/logar")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String LogarRest(String json) {
		UserDAO userdao = new UserDAO();
		Gson gson = new Gson();
		User user = new User();
		System.out.println("JSON: " + gson.toJson(user));
		
		JSONObject jsonObject = new JSONObject(json);
		
		//jsonObject.getString("");

		return null;
	}

}
*/