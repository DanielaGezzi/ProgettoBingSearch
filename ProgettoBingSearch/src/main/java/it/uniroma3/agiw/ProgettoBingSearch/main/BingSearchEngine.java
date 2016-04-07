package it.uniroma3.agiw.ProgettoBingSearch.main;

import java.io.IOException;
import java.util.ArrayList;

import it.uniroma3.agiw.ProgettoBingSearch.DownloadPages;
import it.uniroma3.agiw.ProgettoBingSearch.ExecuteQuery;
import it.uniroma3.agiw.ProgettoBingSearch.GeneratoreLista;
import it.uniroma3.agiw.ProgettoBingSearch.SearchPage;

public class BingSearchEngine{
    
    public static void main( String[] args ) throws IOException{
    	SearchPage sp = new SearchPage();
    	GeneratoreLista gr = new GeneratoreLista();
    	ExecuteQuery eq = new ExecuteQuery();   
    	DownloadPages d = new DownloadPages();
    	
    	//1.Prendiamo la lista delle persone di cui vanno fatte le query
    	ArrayList<String> persone = gr.getLista();
    	//2.Per ogni elemento della lista, facciamo la query
    	eq.execute(sp,persone);
    	//3.Leggendo il file degli URL dei risultati, scarico le pagine
    	d.executeDownload();
    }
      
}
