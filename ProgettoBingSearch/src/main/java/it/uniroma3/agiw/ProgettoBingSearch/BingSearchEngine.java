package it.uniroma3.agiw.ProgettoBingSearch;

import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Base64;

import org.json.JSONArray;
import org.json.JSONObject;

public class BingSearchEngine{
	
    public static void doBingSearch() throws IOException{
    	
      	/*Uso della Api di Bing: trovato su Internet, stampa la lista degli Url della ricerca*/
    	final String accountKey = "*"; 
        final String accountKeyEnc = Base64.getEncoder().encodeToString((accountKey + ":" + accountKey).getBytes());
        
        final String bingUrlPattern = "https://api.datamarket.azure.com/Bing/Search/Web?Query=%%27%s%%27&$format=JSON";
        
        String sCurrentLine;
        BufferedReader br = new BufferedReader(new FileReader("../ProgettoBingSearch/src/cognomi.txt"));
        
        final String query = URLEncoder.encode("'Paolo Merialdo'", Charset.defaultCharset().name());
        final String bingUrl = String.format(bingUrlPattern, query);

        final URL url = new URL(bingUrl);
        final URLConnection connection = url.openConnection();
        connection.setRequestProperty("Authorization", "Basic " + accountKeyEnc);
        final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        
        try {
            String inputLine;
            final StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            System.out.println("Forma del risultato ottenuto");
            System.out.println(response.toString());
            System.out.println();
            
            final JSONObject json = new JSONObject(response.toString());
            final JSONObject d = json.getJSONObject("d");
            final JSONArray results = d.getJSONArray("results");
            
            
            final int resultsLength = results.length();
            for (int i = 0; i < resultsLength; i++) {
            	
                final JSONObject aResult = results.getJSONObject(i);             
                //mi salvo il contenuto del campo metadata che contiene la query che abbiamo eseguito
                final JSONObject aQuery = (JSONObject) aResult.get("__metadata");
                
                System.out.println("URL risultante : "+aResult.get("Url"));
                System.out.println("Query di partenza : "+aQuery.get("uri"));
                System.out.println();
            
            }
        }catch(IOException e){
            e.printStackTrace();
        
        }catch(Exception e){
            e.printStackTrace();
            
        }finally {
        	//chiudo l'input stream
        	in.close();
        	
        }
    }
    
    public static void main( String[] args ) throws IOException{
    	doBingSearch();
    }
      
}
