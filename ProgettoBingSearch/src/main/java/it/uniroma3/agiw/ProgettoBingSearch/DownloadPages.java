package it.uniroma3.agiw.ProgettoBingSearch;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;

public class DownloadPages {

	public void executeDownload() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("../ProgettoBingSearch/src/listaQuery.txt"));
		String currentLine;		
		
		String bucket_name = "prova-agiw";	
		String key_name = "prova8/page";	
		
		int cont=0;
		
		/*Mi scorro tutta la lista degli URL e lancio lo scarimento dei file*/
		while ((currentLine = br.readLine()) != null){
			String[] a = currentLine.split("\t");
			String url = a[2];
			String query = a[0];
			downloadURLIntoS3(bucket_name, key_name+cont, url, query);
			cont++;
		}
		
		System.out.println("Ho letto "+cont+" righe dal file dei risultati");
	}
	
	public void downloadFromURL(String filename, String URL){
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
	
	public void downloadURLIntoS3(String bucket_name, String key_name,String URL, String query){
	    URL url;

	    try {
	        url = new URL(URL);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.connect();
	        
	        if (conn.getResponseCode()!=HttpURLConnection.HTTP_OK)
	            return;

	        InputStream in = conn.getInputStream();
	        
	        //con la riga che segue effettuo l'accesso sincronizzato già con aws toolkit eclipse
	        AmazonS3 aws_conn = new AmazonS3Client(new ProfileCredentialsProvider());        
	       
	        /*per effettuare l'acceso con qualsiasi account aws
	        *  
	        AWSCredentials credentials = new BasicAWSCredentials(
					"YourAccessKeyID", 
					"YourSecretAccessKey");
			
			AmazonS3 aws_conn = new AmazonS3Client(credentials);
			*/
	        
	        
				/*questo primo input stream viene direttamente dalla connessione http
	        e lo uso per copiare momentaneamente i dati in una nuova struttura
	        e per costruire i metadata con la dimensione del trasferimento
	         (obbligatoria sennò aws scapoccia)*/
			ObjectMetadata meta =  new ObjectMetadata();
			byte[] bytes = IOUtils.toByteArray(in);
			
			Long contentLength = Long.valueOf(bytes.length);
			meta.setContentLength(contentLength);
			meta.addUserMetadata("URL", URL);
			meta.addUserMetadata("QUERY", query);
			 conn.disconnect();
			/*
			imposto input2 come nuovo input stream per aws e creo il file nel bucket
			 */
	        ByteArrayInputStream input2 = new ByteArrayInputStream(bytes);
			aws_conn.putObject(bucket_name, key_name, input2, meta);

	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
