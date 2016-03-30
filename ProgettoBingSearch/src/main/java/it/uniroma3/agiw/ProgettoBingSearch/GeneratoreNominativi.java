package it.uniroma3.agiw.ProgettoBingSearch;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GeneratoreNominativi {

	public static void main(String[] args) throws IOException {
		List<String> cognomi = new ArrayList<String>(); //100 cognomi più diffusi in Italia
		List<String> nomi = new ArrayList<String>();    //100 nomi (maschi e femmine) più diffusi in Italia
		List<String> nomiCognomi = new ArrayList<String>();
		String sCurrentLine;
	
		BufferedReader br = new BufferedReader(new FileReader("../ProgettoBingSearch/src/cognomi.txt"));
		while ((sCurrentLine = br.readLine()) != null) {
			cognomi.add(sCurrentLine);
		}
		br = new BufferedReader(new FileReader("../ProgettoBingSearch/src/nomi.txt"));
		while ((sCurrentLine = br.readLine()) != null) {
			nomi.add(sCurrentLine);
		}
		
		//Combino le due liste per avere una lista di coppie nome-cognome(Italiani)
		int iterazioni = 10;
		while(iterazioni>0){
			String cognome;
			for(String nome:nomi){
				Random rand = new Random();
				int randomNum = rand.nextInt((99 - 0) + 1) + 0;
				cognome = cognomi.get(randomNum);
				
				if (!nomiCognomi.contains(nome+" "+cognome))
					nomiCognomi.add(nome+" "+cognome);
					nomiCognomi.add(cognome+" "+nome);
			}
			iterazioni--;
		}
		FileOutputStream stream = new FileOutputStream("../ProgettoBingSearch/src/nomicognomi.txt");
        PrintStream data = new PrintStream(stream);
		for(String x: nomiCognomi){
	        	  data.println(x);
	          }
	    data.close();
	    stream.close();
		
			
		
		System.out.println("Ho generato "+nomiCognomi.size()+" combinazioni");
	}

}
