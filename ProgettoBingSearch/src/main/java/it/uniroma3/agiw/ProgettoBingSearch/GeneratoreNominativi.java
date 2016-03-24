package it.uniroma3.agiw.ProgettoBingSearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
		String cognome;
		for(String nome:nomi){
			Random rand = new Random();
			int randomNum = rand.nextInt((99 - 0) + 1) + 0;
			cognome = cognomi.get(randomNum);
			nomiCognomi.add(nome+" "+cognome);
		}
		
		for(String x: nomiCognomi)
			System.out.println(x);
		
		System.out.println("Ho generato "+nomiCognomi.size()+" combinazioni");
	}

}
