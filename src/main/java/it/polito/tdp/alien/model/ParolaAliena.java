package it.polito.tdp.alien.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ParolaAliena {

	private String parola;
	private Set<String> traduzioni;
	
	public ParolaAliena(String parola) {
		this.parola = parola;
		traduzioni = new HashSet<String>();
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public void addTraduzione(String traduzione) {
		traduzioni.add(traduzione);
	}

	public String getTraduzioni() {
		String s = "";
		for(String t:traduzioni)
			s+=t+"\n";
		return s;
	}

	@Override
	public int hashCode() {
		return Objects.hash(parola, traduzioni);
		/*
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
		 */
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParolaAliena other = (ParolaAliena) obj;
		if (parola == null) {
			if (other.parola != null)
				return false;
		} else if (!parola.equals(other.parola))
			return false;
		return true;
	}
	
	

}
