package it.uniroma3.agiw.ProgettoBingSearch;

import java.io.IOException;
import java.util.ArrayList;

public class BingSearchEngine{
    
    public static void main( String[] args ) throws IOException{
    	SearchPage sp = new SearchPage();
    	GeneratoreLista gr = new GeneratoreLista();
    	
    	//1.Prendiamo la lista delle persone di cui vanno fatte le query
    	ArrayList<String> persone = gr.getLista();
    	
    	sp.executeQuery("Paolo Merialdo");
    	//2.Per ogni elemento della lista, facciamo la query
//    	for(String s:persone)
//    		sp.executeQuery(s);
    }
      
}
