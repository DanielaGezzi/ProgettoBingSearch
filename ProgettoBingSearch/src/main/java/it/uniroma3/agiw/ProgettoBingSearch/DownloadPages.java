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

	
//	private static final String ACCESS_TOKEN = "***";
	

	/*Metodo che, dato un URL salva il contenuto della pagina in un file di cui indichiamo il path*/
//	public void saveFromUrl(final String filename, final String urlString)throws MalformedURLException, IOException {
//	    BufferedInputStream in = null;
//	    FileOutputStream fout = null;
//	    try {
//	        in = new BufferedInputStream(new URL(urlString).openStream());
//	        fout = new FileOutputStream(filename);
//
//	        final byte data[] = new byte[1024];
//	        int count;
//	        while ((count = in.read(data, 0, 1024)) != -1) {
//	            fout.write(data, 0, count);
//	        }
//	    } finally {
//	        if (in != null) {
//	            in.close();
//	        }
//	        if (fout != null) {
//	            fout.close();
//	        }
//	    }	
//	}

	public void executeDownload() throws IOException, UploadErrorException, DbxException {
		BufferedReader br = new BufferedReader(new FileReader("../ProgettoBingSearch/src/listaResults.txt"));
		String currentLine;		
		/*Mi scorro tutta la lista degli URL e lancio lo scarimento dei file*/
		while ((currentLine = br.readLine()) != null) {
			
			String[] a = currentLine.split("/");			
			/*Il file lo rinomino con l'url*/
			downloadFromURL("/Users/RobertoNunziato/Desktop/Prova/"+a[2]+".html", currentLine);
//			downloadFromURL("/Users/RobertoNunziato/Dropbox/Applicazioni/"+a[2]+".html", currentLine);

		}
	}
	
	public void downloadFromURL(String filename, String URL) throws UploadErrorException, DbxException {
	    URL url;
//	    InputStream is = null;
//	    DataInputStream dis;
//	    String s;
//	    StringBuffer sb = new StringBuffer();
	    
	    //Aggiunto
//		DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
//        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

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
//	        FileMetadata m = client.files().uploadBuilder(filename).uploadAndFinish(in);
	        
	        conn.disconnect();
	    
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    }
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	}

//	public String getNameFromUrl(String url) {
//
//	    int slashIndex = url.lastIndexOf('/');
//	    int dotIndex = url.lastIndexOf('.');
//
//	    System.out.println("url:" + url + "," + slashIndex + "," + dotIndex);
//
//	    if (dotIndex == -1) {
//	        return url.substring(slashIndex + 1);
//	    } else {
//	        try {
//	            return url.substring(slashIndex + 1, url.length());
//	        } catch (StringIndexOutOfBoundsException e) {
//	            return "";
//
//	        }
//	    }
//	}
}
