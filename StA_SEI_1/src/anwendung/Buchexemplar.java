package anwendung;

/*
 * buchexemplar erbt noch von Buch
 * muss noch umgeändert werden, 
 * ohne Vererbung!!!
 */

public class Buchexemplar extends Buch{
	private int id_bex;
	private int seriennr; 
	private Status status; 
	
	//leerer Konstruktro
	public Buchexemplar() {
		super();
	}
	
	//Konstruktor mit idex 
	public Buchexemplar(int id, int id_bex, String titel, String autor, String isbn, Status status, int seriennr) {
		super(id, titel, autor, isbn);
		this.id_bex = id_bex;
		this.seriennr = seriennr; 
		this.status = status; 
	}
	
	//Konstruktor
	public Buchexemplar(int id, String titel, String autor, String isbn, Status status, int seriennr) {
		super(id, titel, autor, isbn);
		this.seriennr = seriennr; 
		this.status = status;
	}
	
	//Konstruktor ohne ID
	public Buchexemplar(String titel, String autor, String isbn, Status status, int seriennr) {
		super(titel, autor, isbn);
		this.seriennr = seriennr; 
		this.status = status;
	}

	public int getSeriennr() {
		return seriennr;
	}

	public void setSeriennr(int seriennr) {
		this.seriennr = seriennr;
	}
	
	public int getId_bex() {
		return id_bex;
	}

	public void setId_bex(int id_bex) {
		this.id_bex = id_bex;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	//Buch ausleihen
	public boolean ausleihen(Status sta) {
		if(status == Status.nicht_ausleihbar) {
//			System.out.println("Diese Buch kann nicht ausgeliehen werden. Es ist nur für die Benutzung im Lesesaal bestimmt!");
			return false;
		}
		if(status == Status.ausgeliehen) {
//			System.out.println("Dieses Buch kann nicht ausgeliehen werden. Der Status des Buchs ist bereits ausgeliehen!");
			return false;
		}
		if(status == status.ausleihbar) {
//			setStatus(Status.ausgeliehen);
			return true;
		}
		else
    		throw new NullPointerException("Fehler beim bestimmen des Status");
	}
	
	public Status ausgeliehen() {
		Status s = Status.ausgeliehen;
		return s;
	}
	
	public void zurueckgeben() throws NullPointerException {
		if(status == Status.ausgeliehen)
			setStatus(Status.ausleihbar);
		if(status == Status.nicht_ausleihbar || status == Status.ausgeliehen) {
			System.out.println("Fehler! Buch ist bereits in der Bibliothek vorhanden.");
		}
	}
}
