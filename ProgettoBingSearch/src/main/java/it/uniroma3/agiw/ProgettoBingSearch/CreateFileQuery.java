package it.uniroma3.agiw.ProgettoBingSearch;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

public class CreateFileQuery {
	
	private FileWriter listaQuery;
	private FileWriter prova;
	
	public CreateFileQuery() throws IOException{
		this.listaQuery = new FileWriter("../ProgettoBingSearch/src/listaQuery.txt");
		this.prova = new FileWriter("../ProgettoBingSearch/src/prova.txt");
	}
	
	public void writeFileQuery(String query,JSONObject aQuery, JSONObject aResult) throws IOException {;
		this.listaQuery.write(query+"\t"+aQuery.get("uri")+"\t"+aResult.get("Url")+"\n");
		this.prova.write(aResult.get("Url")+"\n");
	}

	public FileWriter getListaQuery() {
		return listaQuery;
	}

	public void setListaQuery(FileWriter listaQuery) {
		this.listaQuery = listaQuery;
	}
}
