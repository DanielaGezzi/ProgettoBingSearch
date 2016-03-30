package it.uniroma3.agiw.ProgettoBingSearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BingSearchEngine{
    
    public static void main( String[] args ) throws IOException{
    	SearchPage sp = new SearchPage();
    	GeneratoreLista gr = new GeneratoreLista();
    	ArrayList<String> persone = gr.getLista();
    	//1.Prendiamo la lista delle persone di cui vanno fatte le query
    	
    	//2.Per ogni elemento della lista, facciamo la query
    	for(String s:persone)
    		sp.executeQuery(s);
    }
      
}
