package it.uniroma3.agiw.ProgettoBingSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Base64;

import org.json.JSONArray;
import org.json.JSONObject;

import it.uniroma3.agiw.ProgettoBingSearch.createFile.CreateFileQuery;
import it.uniroma3.agiw.ProgettoBingSearch.createFile.CreateFileResults;

public class SearchPage {
	
    private CreateFileQuery file;
    private CreateFileResults file2;
    
    public SearchPage() throws IOException{
    	this.file = new CreateFileQuery();
    	this.file2 = new CreateFileResults();
    }
    	
	public void executeQuery(String q, int n_results) throws IOException{
		
		String accountKey = "";  //chiave account Bing 
	    String accountKeyEnc = Base64.getEncoder().encodeToString((accountKey + ":" + accountKey).getBytes());
	    String bingUrlPattern = "";
	    
	    //Se è la prima query, prendiamo i primi 50 risultati, altrimenti i secondi 50
	    if(n_results == 1)
	    	bingUrlPattern = "https://api.datamarket.azure.com/Bing/Search/Web?Query=%%27%s%%27&$format=JSON";
	    else if(n_results == 2)
	    	bingUrlPattern = "https://api.datamarket.azure.com/Bing/Search/Web?Query=%%27%s%%27&$format=JSON&$skip=50&$top=50";    
	    else if(n_results == 3)
	    	bingUrlPattern = "https://api.datamarket.azure.com/Bing/Search/Web?Query=%%27%s%%27&$format=JSON&$skip=100&$top=100";    	    	
	    
	    String query = URLEncoder.encode(q, Charset.defaultCharset().name());
	    String bingUrl = String.format(bingUrlPattern, query);
	
	    URL url = new URL(bingUrl);
	    URLConnection connection = url.openConnection();
	    connection.setRequestProperty("Authorization", "Basic " + accountKeyEnc);    
	    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	    
	    try {
	        String inputLine;
	        final StringBuilder response = new StringBuilder();
	        while ((inputLine = in.readLine()) != null) {
	            response.append(inputLine);
	        }
	        System.out.println("Forma del risultato ottenuto");
	        System.out.println(response.toString());
	        System.out.println();
	        
	        JSONObject json = new JSONObject(response.toString());
	        JSONObject d = json.getJSONObject("d");
	        JSONArray results = d.getJSONArray("results");
	        
	        
	        final int resultsLength = results.length();
	        for (int i = 0; i < resultsLength; i++) {
	        	
	            JSONObject aResult = results.getJSONObject(i);             
	            //mi salvo il contenuto del campo metadata che contiene la query che abbiamo eseguito
	            JSONObject aQuery = (JSONObject) aResult.get("__metadata");
	            
	            //Scrivo in un file i campi della query e l'url risultante
	            this.file.writeFileQuery(q,aQuery,aResult);

	            
	            //Scrivo in un file la lista degli url che poi usiamo per scaricare le pagine
	            this.file2.writeFileResults(aResult);
	            System.out.println("Query di partenza : "+aQuery.get("uri"));
	        }

	    }catch(IOException e){
	        e.printStackTrace();
	    
	    }catch(Exception e){
	        e.printStackTrace();
	        
	    }finally {
	    	in.close();
	    }
	}

	public CreateFileQuery getFile() {
		return file;
	}

	public void setFile(CreateFileQuery file) {
		this.file = file;
	}

	public CreateFileResults getFile2() {
		return file2;
	}

	public void setFile2(CreateFileResults file2) {
		this.file2 = file2;
	}
}
