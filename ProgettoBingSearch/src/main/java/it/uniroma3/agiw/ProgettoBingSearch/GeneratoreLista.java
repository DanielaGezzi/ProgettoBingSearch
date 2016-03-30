package it.uniroma3.agiw.ProgettoBingSearch;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;;

public class GeneratoreLista {
	private ArrayList<String> lista;
	
	public void creaLista() throws IOException{
    	String currentLine;
    	BufferedReader br = new BufferedReader(new FileReader("../ProgettoBingSearch/src/ing2.txt"));
    	while ((currentLine = br.readLine()) != null) {
    		this.lista.add(currentLine);
    	}
	}
	
	public ArrayList<String> getLista() throws IOException {
		this.creaLista();
		return this.lista;
	}
}
