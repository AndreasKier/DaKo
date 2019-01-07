package anwendung;

/*Buch ist noch als Oberklasse festgelegt
 * muss noch in Buchtyp umgewandelt werden
 */

public class Buch {
	private int id;
	private String titel;
	private String autor;
	private String isbn;
	
	//Konstruktor
	
	//leerer Konstruktor
	public Buch() {
	}
	
	//Fehler anzeigen, falls nicht alle Datenelemente eingegeben wurden
	public Buch (int id, String titel, String autor, String isbn) {
		this.id = id;
		this.titel = titel;
		this.autor = autor;
		this.isbn = isbn;
	}
	
	//Konstruktro ohne ID
	public Buch (String titel, String autor, String isbn) {
		this.titel = titel;
		this.autor = autor;
		this.isbn = isbn;
	}

	//getter/setter
	public int id() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getISBN() {
		return isbn;
	}

	public void setISBN(String isbn) {
		this.isbn = isbn;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	//Assosation:

	public String getDetails() {
    	String result = "Titel: "+ titel;
    	result += "\nID: " + id; 
        result += "\nAutor: " + autor; 
    	result += "\nISBN: " + isbn;
        
        return result; 
    }
	
	/*public 
	 * if(status equals 'ausleihbar')
	 * dann darf status von ausleihbar auf ausgeliehen geändert werden
	 * falls status nicht ausleihbar ist, darf buch nicht ausgeliehen werden, 
	 * sondern nur in den Lesesaal mitgenommen werden
	 * else
	 * 		throw new Exeption ("Buch darf nicht ausgeliehen werden!\n");
	 * 
	 */
}
