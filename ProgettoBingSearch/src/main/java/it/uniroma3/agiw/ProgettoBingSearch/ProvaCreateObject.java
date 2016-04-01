package it.uniroma3.agiw.ProgettoBingSearch;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;

public class ProvaCreateObject {
	//public static final int DEFAULT_STREAM_BUFFER_SIZE = 2000;
	public static void main(String[] args) throws IOException {
		
		
		ArrayList<String> listastringhe = new ArrayList<String>();
		
		for(int i = 0; i<100; i++) listastringhe.add("stupido"+i);
		
		//le mie credenziali...
		AmazonS3 conn = new AmazonS3Client(new ProfileCredentialsProvider());        
		
		//operando in questo modo ,cioè mettendo il documento su un'unica stringa,
		//tutto sembra funzionare
		String pagina = "";
		for(String s : listastringhe) pagina = pagina + s + "\n"; 
			
		ByteArrayInputStream input = new ByteArrayInputStream(pagina.getBytes());
		ObjectMetadata meta =  new ObjectMetadata();
	    //la riga seguente mi dà ancora errore se la attivo, omettendola mi dà un warning
		byte[] bytes = IOUtils.toByteArray(input);
		Long contentLength = Long.valueOf(bytes.length);
		meta.setContentLength(contentLength);
		ByteArrayInputStream input2 = new ByteArrayInputStream(pagina.getBytes());
		//meta.setContentLength(Long.valueOf(IOUtils.toByteArray(input).length));
		conn.putObject("prova-agiw", "stupido.txt", input2, meta);
		//System.out.println(meta.);
		
	}

}
