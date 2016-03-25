package it.uniroma3.agiw.ProgettoBingSearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFromFile {

	public static void main(String[] args) {
		
		try (BufferedReader br = new BufferedReader(new FileReader("../ProgettoBingSearch/src/prova.txt"))){
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		
		} 
	}
}
	