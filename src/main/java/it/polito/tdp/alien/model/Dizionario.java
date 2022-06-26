package it.polito.tdp.alien.model;

import java.util.HashMap;
import java.util.Map;

public class Dizionario {

	private Map<String, ParolaAliena> dizionario;
	
	public Dizionario() {
		dizionario = new HashMap<>();
	}
	
	public void addTraduzione(String parolaAliena, String traduzione) {
		if(!dizionario.containsKey(parolaAliena))
			dizionario.put(parolaAliena, new ParolaAliena(parolaAliena));
		dizionario.get(parolaAliena).addTraduzione(traduzione);
	}

	public String getTraduzione (String parolaAliena) {
		if(dizionario.containsKey(parolaAliena))
			return dizionario.get(parolaAliena).getTraduzioni();
		return null;
	} 
	
	public String getTraduzioneWildcard (String parolaAlienaWC) {
		
		parolaAlienaWC = parolaAlienaWC.replaceAll("\\?", ".");
		
		int matchCount = 0;
		StringBuilder sb = new StringBuilder();
		
		for(ParolaAliena pa:dizionario.values()) {
			if(pa.getParola().matches(parolaAlienaWC)) {
				matchCount++;
				sb.append(pa.getTraduzioni());
			}
		}
		
		if(matchCount!=0)
			return sb.toString();
		return null;
	} 
	
	public void reset() {
		dizionario.clear();
	}
	
}
