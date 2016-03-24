package it.uniroma3.agiw.ProgettoBingSearch;

import org.apache.http.client.ResponseHandler;

import java.net.URLEncoder;
import java.io.IOException;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class BingSearchEngine {
	
public static void getBing() throws Exception {
		
		HttpClient httpclient = new DefaultHttpClient();
		String accountKey = "*";
        byte[] accountKeyBytes = Base64.encodeBase64((":" + accountKey).getBytes());
        String accountKeyEnc = new String(accountKeyBytes);

        String query = "Barack Obama";
        int skipParam = 0;
        String bingURL = "https://api.datamarket.azure.com/Bing/Search/Web?Query=%27"+URLEncoder.encode(query, "UTF-8")+"%27&Market=%27en-US%27&$format=JSON&$skip="+skipParam+"";

		JSONObject result = null;
		
		try {
            HttpGet httpget = new HttpGet(bingURL);
            httpget.setHeader("Authorization", "Basic " + accountKeyEnc);

            System.out.println("executing request " + httpget.getURI());

            // Create a response handler
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
            System.out.println("----------------------------------------");
            result = new JSONObject(responseBody.toString());
            System.out.println(result.getJSONObject("d").get("__next"));

            JSONObject d = result.getJSONObject("d");
            JSONArray resultsArray = d.getJSONArray("results");
            int resultsLength = resultsArray.length();
            for (int i = 0; i < resultsLength; i++) {
                final JSONObject aResult = resultsArray.getJSONObject(i);
                System.out.println(aResult.get("Url"));
            }
            
            
            
        }catch(IOException e){
        	System.out.println("Exception is"+ e);
            e.printStackTrace();
            
        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }
	}
public static void main(String[] args) throws Exception {
	getBing();
}

}
