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
    
    public static void main( String[] args ) throws IOException{
    	SearchPage sp = new SearchPage();
    	
 
    	
    	sp.executeQuery("Paolo Merialdo");
    }
      
}
