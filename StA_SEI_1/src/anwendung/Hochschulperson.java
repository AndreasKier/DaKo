package anwendung;

/*soll es evtl. noch abstrakte Klassen, interfaces, überladene Methoden geben???
 * 
 */

public class Hochschulperson {//implements Person, Cloneable{ //Cloneable notwenig??
	private Hochschule hochschule;
	private String name;
    private String email;
    private Adresse adresse;
    private int id; 
    private int counter; //soll erhöht werden, sobald ein Buch eingeliehen wird
    
    //getter
    public Adresse getAdresse() {
 	   return adresse;
    }
    
    public String getName() {
    	return name;
    }
    
    public Hochschule getHochschule() {
    	return hochschule;
    }
    
    public String getEMail() {
    	return email;
    }
    
    public int getID() {
    	return id;
    }
    
    //setter
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEMail(String email) {
 	   this.email = email;
    }
    
    public void setAdresse(String strasse, String hausnr, int plz, String ort) throws AdressException {
 	   adresse = new Adresse (strasse, hausnr, plz, ort);
    }
    
    public void setHochschule(Hochschule hochschule) {
    	this.hochschule = hochschule;
    }
    
    public void setID(int id) {
    	this.id = id;
    }
    
    
    public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	//leerer Konstruktor
    public Hochschulperson() {
    }
    
    //Konstruktor ohne Adresse
    public Hochschulperson (int id, String name, String email, Hochschule hochschule, int counter) throws NullPointerException {
    	if(name != null && id != 0 && email != null && hochschule != null) {
    		this.id = id;
    		this.name = name;
    		this.email = email;
    		this.hochschule = hochschule;
    		this.counter = counter;
    	}
    	else 
    		throw new NullPointerException("Es wurden nicht alle Felder ausgefüllt");	
    }
    
    //Konstruktor ohne Adresse, ohne id
    public Hochschulperson (String name, String email, Hochschule hochschule, int counter) throws NullPointerException {
    	if(name != null && email != null && hochschule != null) {
    		this.name = name;
    		this.email = email;
    		this.hochschule = hochschule;
    		this.counter = counter;
    	}
    	else 
    		throw new NullPointerException("Es wurden nicht alle Felder ausgefüllt");	
    }
    
    //Konstruktor mit Adresse
    public Hochschulperson (int id, String name, String email, Hochschule hochschule, String strasse, String hausnr, int plz, String ort, int counter) throws AdressException, NullPointerException {
    	if(id != 0 && name != null && strasse != null && hausnr != null && plz != 0 && ort != null && email != null && hochschule != null) {
    		this.id = id;
    		this.name = name;
    		this.adresse = new Adresse(strasse, hausnr, plz, ort); 
    		this.email = email;
    		this.hochschule = hochschule;
    		this.counter = counter;
    		}
    	else 
    		throw new NullPointerException("Es wurden nicht alle Felder ausgefüllt");
    }
    
    //Konstruktor mit Adresse ohne id
    public Hochschulperson (String name, String email, Hochschule hochschule, String strasse, String hausnr, int plz, String ort, int counter) throws AdressException, NullPointerException {
    	if(name != null && strasse != null && hausnr != null && plz != 0 && ort != null && email != null && hochschule != null) {
    		this.name = name;
    		this.adresse = new Adresse(strasse, hausnr, plz, ort); 
    		this.email = email;
    		this.hochschule = hochschule;
    		this.counter = counter;
    		}
    	else 
    		throw new NullPointerException("Es wurden nicht alle Felder ausgefüllt");
    }
    
    public boolean ausleihen(int counter){
    	if(counter < 2) {
//    		counter++;
    		return true;
    	}
    	else
    		return false;
    }
    
    public int ausgeliehen(int counter) {
    	counter++;
    	return counter;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((hochschule == null) ? 0 : hochschule.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	//vergleichen ob Person bereits im System gespeichert ist
	//vergleich von adresse, email, hochschule und name nicht berücksichtigt werden id und counter!
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hochschulperson other = (Hochschulperson) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (hochschule != other.hochschule)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
    
    
    
    
    
    //
    
//    	if(vollstName != null) {
//    		if(ort != null){
//    		this.id = id;
//    		this.vollstName = vollstName;
//    		this.telefonnr = telefonnr;
//    		this.adresse = new Adresse(strasse, hausnr, plz, ort.toString());
//    		this.hochschule = hochschule;
//    		}
//    		else 
//    			throw new AdressException("Es wurde kein Ort angegeben!");
//    	}
//    	else
//    	throw new NullPointerException("Es wurde kein Name eingegeben!\n");	
 //   }
    
    /*Methode ausleihen
    
    
    */
    
    //Arrayliste für die Bücher, die Studenten/Professoren ausleihen können
    //für Assosation ein Student kann mehrere Bücher ausleihen
    //wieder löschen, da bücher in die tabelle geschrieben werden!!!!
//    private ArrayList<Buchexemplar> buchliste = new ArrayList<Buchexemplar>();
    
    //Methode ausleihen: wenn student weniger als 2 buecher hat, dann darf er ausleihen =?> bei buch methode ausleihen
    // prüft ob buch ausleihbar ist
//    public void ausleihen(Buchexemplar buchex) throws NullPointerException {
//    	if(zähler < 2) {
//    		buchex.ausleihen();
//    		zähler++;
//    		//Array wird wieder entfernt, da es spaeter dafuer eine Tabelle gibt
//    		buchliste.add(buchex);
//    	}
//    	else
//    		throw new NullPointerException("Die maximale Anzahl an ausleibaren Büchern wurde überschritten.\nBuch konnten nicht ausgeliehen werden");
//    }
//    
//    //Buch zurückgeben?
//    public void zurueckgeben(Buch buch) {
//    	buchexemplar.zurueckgeben();
//    	zähler--;
//    	//spaeter entfernen, da es dann eine Tabelle dafuer gibt
//    	buchliste.remove(buch);
//    }
//    
//    
//    
//    @Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
//		result = prime * result + ((email == null) ? 0 : email.hashCode());
//		result = prime * result + ((hochschule == null) ? 0 : hochschule.hashCode());
//		result = prime * result + id;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Hochschulperson other = (Hochschulperson) obj;
//		if (adresse == null) {
//			if (other.adresse != null)
//				return false;
//		} else if (!adresse.equals(other.adresse))
//			return false;
//		if (email == null) {
//			if (other.email != null)
//				return false;
//		} else if (!email.equals(other.email))
//			return false;
//		if (hochschule != other.hochschule)
//			return false;
//		if (id != other.id)
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}
//
//	public String getDetails() {
//    	String result = "Name: "+ name;
//    	
////    	if(hochschule != null) {
////    		result += "\nHochschule: " + hochschule; 
////    	}
////       
////    	if(telefonnr != null) { 
////            result += "\nTelefonnummer: " + telefonnr; 
////    	}
////         
////        if(adresse != null){
////             result += " \nAdresse: \n" + adresse.toString();
////         }
//        result +="\nID: " + id;
//        result +="\nZähler: " + zähler;
//         
//         return result; 
//    }
    /*
    //Interface
	public String getAssignment()  {
		if(hochschule != null) {
			return vollstName + ", " +hochschule;
	    }
		else
			return vollstName + " (keine Angabe zur Hochschule)";
	}*/

}
