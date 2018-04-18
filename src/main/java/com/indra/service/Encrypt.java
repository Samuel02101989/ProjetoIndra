package com.indra.service;

/**
 * 
 * @author Samuel Oliveira
 * @category ProjetoRH Servive
 * @since 08-04-2018
 * @version 1.3
 * 
 */

import java.math.BigInteger;
import java.security.MessageDigest;

public class Encrypt {

	public static String passwordToMD5(String senha) {
		String retorno = "";
		MessageDigest md;

		try {
			md = MessageDigest.getInstance("MD5");
			BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
			retorno = hash.toString(16);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;

	}

}
