package it.uniroma3.agiw.ProgettoBingSearch;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ScaricaPagina {
	
	public static void main (String[] args) throws IOException {
		//------------------------------------------------------------//
		//  JavaGetUrl.java:                                          //
		//------------------------------------------------------------//
		//  A Java program that demonstrates a procedure that can be  //
		//  used to download the contents of a specified URL.         //
		//------------------------------------------------------------//
		//  Code created by Developer's Daily                         //
		//  <a href="http://www.DevDaily.com" title="http://www.DevDaily.com">http://www.DevDaily.com</a>                                   //
		//------------------------------------------------------------//
	    
		//-----------------------------------------------------//
	    //  Step 1:  Start creating a few objects we'll need.
	    //-----------------------------------------------------//
	 	URL u;
	    InputStream is = null;
	    //DataInputStream dis;  //Ho cambiato rispetto al codice originale perchè la classe ha un metodo deprecato
	    String s;
	    
	    //Creo un nuovo file in cui salvo il contenuto della mia pagina Web
	    FileWriter file = new FileWriter("../ProgettoBingSearch/src/pagina.txt");  //li salviamo in .html????

	      	      
	    try {
	    	//------------------------------------------------------------//
	        // Step 2:  Create the URL.                                   //
	        //------------------------------------------------------------//
	        // Note: Put your real URL here, or better yet, read it as a  //
	        // command-line arg, or read it from a file.                  //
	        //------------------------------------------------------------//
	    	u = new URL("http://alvinalexander.com/java/edu/pj/pj010011");
	 
	        //----------------------------------------------//
	        // Step 3:  Open an input stream from the url.  //
	        //----------------------------------------------//
	    	is = u.openStream();         // throws an IOException
	 
	        //-------------------------------------------------------------//
	        // Step 4:                                                     //
	        //-------------------------------------------------------------//
	        // Convert the InputStream to a buffered DataInputStream.      //
	        // Buffering the stream makes the reading faster; the          //
	        // readLine() method of the DataInputStream makes the reading  //
	        // easier.                                                     //
	        //-------------------------------------------------------------//
	    	BufferedReader lines = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	    	// dis = new DataInputStream(new BufferedInputStream(is));
	 
	        //------------------------------------------------------------//
	        // Step 5:                                                    //
	        //------------------------------------------------------------//
	        // Now just read each record of the input stream, and print   //
	        // it out.  Note that it's assumed that this problem is run   //
	        // from a command-line, not from an application or applet.    //
	        //------------------------------------------------------------//
	   	 
	    	while((s = lines.readLine()) != null){
	    	/*Il metodo readLine() di DataInputStream è deprecato, per questo ho
	    	 * usato lo stesso metodo di BufferedReader che invece funziona*/	 	
	    	//while ((s = dis.readLine()) != null) {
	    	    file.write(s);    //Scrivo sul file che ho creato la pagina web
	            System.out.println(s);
	        }
	 
	    	} catch (MalformedURLException mue) {
	    		System.out.println("Ouch - a MalformedURLException happened.");
		        mue.printStackTrace();
		        System.exit(1);
		    } catch (IOException ioe) {
		    	System.out.println("Oops- an IOException happened.");
		    	ioe.printStackTrace();
		    	System.exit(1);
		    } finally {
		     //---------------------------------//
	         // Step 6:  Close the InputStream  //
	         //---------------------------------//
		    	try {
		    		is.close();
		    	} catch (IOException ioe) {
	            // just going to ignore this one
		    	}
		    } // end of 'finally' clause  
	   }
}
