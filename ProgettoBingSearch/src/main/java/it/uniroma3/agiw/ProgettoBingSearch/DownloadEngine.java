package it.uniroma3.agiw.ProgettoBingSearch;

import java.io.IOException;


public class DownloadEngine{
    
    public static void main( String[] args ) throws IOException{
  
    	DownloadPages d = new DownloadPages();
    	String bucket = args[0];
    	String key = args[1];
    	String filename = args[2];
    	//d.executeDownload(bucket, key, filename);
    }
      
}
