package search;
import java.util.ArrayList;

public class Page {
	
	 private String title;
	 private int id;
	 private StringBuffer text;
	 ArrayList<String> infobox;
	 ArrayList<String> outlinks;
	 ArrayList<String> category;
	 
	 Page()
	 {
		 text = new StringBuffer();
	 }

    public String getTitle() {
		return title;
	 }
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public StringBuffer getText() {
		return text;
	}
	public void setText(StringBuffer text) {
		this.text = text;
	}
}

