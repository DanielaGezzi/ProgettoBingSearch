package it.uniroma3.agiw.ProgettoBingSearch;

public class Documento {
	
	private String content;
	private String URL;
	private String query;
	
	public Documento (String content, String URL, String query){
		this.content = content;
		this.URL = URL;
		this.query = query;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	@Override
	public String toString() {
		return "Documento [content=" + content + ", URL=" + URL + ", query="
				+ query + "]";
	}
	
	

}
