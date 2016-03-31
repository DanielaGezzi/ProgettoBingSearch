package it.uniroma3.agiw.ProgettoBingSearch;

import java.io.IOException;
import java.util.ArrayList;

public class ExecuteQuery {
	
	public void execute(SearchPage sp, ArrayList<String> persone) throws IOException {
		
		for(String s:persone)
			sp.executeQuery(s);
		
		/*Chiudo i file in cui ho scritto i risultati delle query*/
		sp.getFile().close();
		sp.getFile2().close();
   	}
}