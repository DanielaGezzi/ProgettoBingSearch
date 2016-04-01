package it.uniroma3.agiw.ProgettoBingSearch;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.files.UploadErrorException;

public class DownloadPages {

	public void executeDownload() throws IOException, UploadErrorException, DbxException {
		BufferedReader br = new BufferedReader(new FileReader("../ProgettoBingSearch/src/listaResults.txt"));
		String currentLine;		
		
		int cont=0;
		
		/*Mi scorro tutta la lista degli URL e lancio lo scarimento dei file*/
		while ((currentLine = br.readLine()) != null){
//			String[] a = currentLine.split("/");			
			/*Il file lo rinomino con l'url (Solo il dominio puro, www. ecc.)*/
			downloadFromURL("/Users/RobertoNunziato/Desktop/Prova/"+cont+".html", currentLine);
//			downloadFromURL("/Users/RobertoNunziato/Desktop/Prova/"+a[2]+".html", currentLine);
			cont++;
		}
		br.close();
		System.out.println("Ho letto e scaricato "+cont+" righe dal file dei risultati");
	}
	
	public void downloadFromURL(String filename, String URL) throws UploadErrorException, DbxException {
	    URL url;

	    //Aggiunto
	    //DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
	    //DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

	    try {
	        url = new URL(URL);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.connect();
	        
	        if (conn.getResponseCode()!=HttpURLConnection.HTTP_OK)
	            return;

	        InputStream in = conn.getInputStream();
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();

	        int i;
	        while ((i = in.read()) != -1) {
	            bos.write(i);
	        }

	        byte[] b = bos.toByteArray();

	        FileOutputStream fos = new FileOutputStream(filename);
	        fos.write(b);
	        fos.close();
	        
	        //Aggiunto
	        //FileMetadata m = client.files().uploadBuilder(filename).uploadAndFinish(in);
	        
	        conn.disconnect();
	    
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	
	}
}
