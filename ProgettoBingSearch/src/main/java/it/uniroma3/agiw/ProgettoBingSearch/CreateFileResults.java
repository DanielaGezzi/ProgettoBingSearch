package it.uniroma3.agiw.ProgettoBingSearch;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

public class CreateFileResults {

	private FileWriter listaResults;
	
	public CreateFileResults() throws IOException{
		this.listaResults = new FileWriter("../ProgettoBingSearch/src/listaResults.txt");
	}
	
	public void writeFileResults(JSONObject aResult) throws IOException {
		System.out.println(aResult.get("Url"));
		this.listaResults.write(""+aResult.get("Url")+"\n");
	}

	public FileWriter getListaResults() {
		return listaResults;
	}

	public void setListaResults(FileWriter listaResults) {
		this.listaResults = listaResults;
	}

}
