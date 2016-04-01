package it.uniroma3.agiw.ProgettoBingSearch;

import java.io.IOException;
import java.util.ArrayList;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.files.UploadErrorException;

public class BingSearchEngine{
    
    public static void main( String[] args ) throws IOException, UploadErrorException, DbxException{
    	//SearchPage sp = new SearchPage();
    	//GeneratoreLista gr = new GeneratoreLista();
    	//ExecuteQuery eq = new ExecuteQuery();   
    	DownloadPages d = new DownloadPages();
    	
    	//1.Prendiamo la lista delle persone di cui vanno fatte le query
    	//ArrayList<String> persone = gr.getLista();
    	//2.Per ogni elemento della lista, facciamo la query
    	//eq.execute(sp,persone);
    	//3.Leggendo il file degli URL dei risultati, scarico le pagine
    	d.executeDownload();
    }
      
}
