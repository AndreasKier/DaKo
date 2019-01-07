package anwendung;

public class Professor extends Hochschulperson {
	private Fakultaet fakultaet;

    //Konstruktor ohne Adresse
    public Professor(int id, String name, String email, Hochschule hochschule, Fakultaet fakultaet, int counter) throws NullPointerException {
       super(id, name, email, hochschule,counter);
       this.fakultaet = fakultaet;
    }
    
  //Konstruktor ohne Adresse und ohne ID
    public Professor(String name, String email, Hochschule hochschule, Fakultaet fakultaet, int counter) throws NullPointerException {
       super(name, email, hochschule, counter);
       this.fakultaet = fakultaet;
    }

    //Konstruktor mit Adresse
   public Professor(int id, String name, String email, Hochschule hochschule, Fakultaet fakultaet, String strasse, String hausnr, int plz, String ort, int counter) throws AdressException, NullPointerException {    
        super(id, name, email, hochschule, strasse, hausnr, plz, ort, counter);
        this.fakultaet = fakultaet; 
   }
   
   //Konstruktor mit Adresse ohne ID
   public Professor(String name, String email, Hochschule hochschule, Fakultaet fakultaet, String strasse, String hausnr, int plz, String ort, int counter) throws AdressException, NullPointerException {    
        super(name, email, hochschule, strasse, hausnr, plz, ort, counter);
        this.fakultaet = fakultaet; 
   }


   //getter/setter
   public Fakultaet getFakultaet() {
	   return fakultaet;
   }
   
   public void setFakultaet(Fakultaet fakultaet) {
	   this.fakultaet = fakultaet;
   }
	
   /*public String getDetails() {
	   if(fakultaet != null) {
		   return super.getDetails()+ "\nFakultaet: " + fakultaet;
	   }
	   else
		   return super.getDetails()+ "\nkeine Angabe zur Fakultaet.";
   }
   public String getAssignment() {
	   if(fakultaet != null) {
		   return super.getAssignment()+ "\nFakultaet: " + fakultaet;
	   }
	   else
		   return super.getAssignment()+ "\nkeine Angabe zur Fakultaet";
   }*/

}
