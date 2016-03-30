package it.uniroma3.agiw.ProgettoBingSearch;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

public class CreateFile {
	
	private FileWriter listaQuery;
	
	public CreateFile() throws IOException{
		this.listaQuery = new FileWriter("../ProgettoBingSearch/src/listaQuery.txt");
	}
	
	public void writeFile(String text) throws IOException{
		this.listaQuery.write(text);
	}
	
	public FileWriter getListaQuery() {
		return listaQuery;
	}

	public void setListaQuery(FileWriter listaQuery) {
		this.listaQuery = listaQuery;
	}

	public void writeFile(String query,JSONObject aQuery, JSONObject aResult) throws IOException {
		this.listaQuery.write(query+"\t"+aQuery.get("uri")+"\t"+aResult.get("Url")+"\n");
	}
}
