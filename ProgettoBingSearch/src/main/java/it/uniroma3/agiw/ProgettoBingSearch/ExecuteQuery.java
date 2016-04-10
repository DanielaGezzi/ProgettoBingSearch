package it.uniroma3.agiw.ProgettoBingSearch;

import java.io.IOException;
import java.util.ArrayList;

public class ExecuteQuery {
	
	public void execute(SearchPage sp, ArrayList<String> persone) throws IOException {
		
		for(String s:persone){
			sp.executeQuery(s,1);   //trovo i primi 50 risultati
			sp.executeQuery(s,2);	//trovo i secondi 50 risultati
			sp.executeQuery(s,3);   //trovo altri 50 risultati (tot: 150)
		}
			
		/*Chiudo i file in cui ho scritto i risultati delle query*/
		sp.getFile().close();
		sp.getFile2().close();
   	}
}
