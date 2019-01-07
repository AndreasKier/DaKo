package anwendung;

public class Student extends Hochschulperson {
	private Studiengruppe studiengruppe;
	private int matrikelnr;
    
	//leerer Konstruktor
	public Student() {
	}
	
    //Konstruktor ohne Adresse
    public Student (int id, String name, String email, Hochschule hochschule, Studiengruppe studiengruppe, int matrikelnr, int counter) throws NullPointerException {
    	super(id, name, email, hochschule, counter);
    	this.studiengruppe = studiengruppe;
    	this.matrikelnr = matrikelnr; 
    	//this.matrikelnr = Integer.parseInt(matrikelnr); //felder wird ausgegeben bei eingabe von Buchstaben
    }
    
    //Konstruktor ohne Adresse ohne ID
    public Student (String name, String email, Hochschule hochschule, Studiengruppe studiengruppe, int matrikelnr, int counter) throws NullPointerException {
    	super(name, email, hochschule, counter);
    	this.studiengruppe = studiengruppe;
    	this.matrikelnr = matrikelnr; 
//    	this.matrikelnr = Integer.parseInt(matrikelnr); //felder wird ausgegeben bei eingabe von Buchstaben
    }
    
    //Konstruktor mit Adresse
    public Student(int id, String name, String email, Hochschule hochschule, Studiengruppe studiengruppe, int matrikelnr, String strasse, String hausnr, int plz, String ort, int counter) throws AdressException, NullPointerException{
    	super(id, name, email, hochschule, strasse, hausnr, plz, ort, counter);
    	this.studiengruppe = studiengruppe;
    	this.matrikelnr = matrikelnr; 
//    	this.matrikelnr = Integer.parseInt(matrikelnr);
    }
    
    //Konstruktor mit Adresse ohne ID
    public Student(String name, String email, Hochschule hochschule, Studiengruppe studiengruppe, int matrikelnr, String strasse, String hausnr, int plz, String ort, int counter) throws AdressException, NullPointerException{
    	super(name, email, hochschule, strasse, hausnr, plz, ort, counter);
    	this.studiengruppe = studiengruppe;
    	this.matrikelnr = matrikelnr; 
    }
    
   //getter/setter
   public Studiengruppe getStudiengruppe() {
	   return studiengruppe;
   }
   
   public int getMatrikelnr() {
	   return matrikelnr;
   }
   
   public void setStudiengruppe(Studiengruppe studiengruppe) {
	   this.studiengruppe = studiengruppe;
   }
   
   public void setMatrikelnr(int matrikelnr) {
	   this.matrikelnr = matrikelnr;
   }

   @Override
   public int hashCode() {
	   final int prime = 31;
	   int result = super.hashCode();
	   result = prime * result + matrikelnr;
	   result = prime * result + ((studiengruppe == null) ? 0 : studiengruppe.hashCode());
	   return result;
   }

//   @Override
   public boolean equalsst(Object obj) {
	   super.equals(obj);
	   if (this == obj)
		   return true;
	   if (!super.equals(obj))
		   return false;
	   if (getClass() != obj.getClass())
		   return false;
	   Student other = (Student) obj;
	   if (matrikelnr != other.matrikelnr)
		   return false;
	   if (studiengruppe != other.studiengruppe)
		   return false;
	return true;
}
   
   
   
//   public String getDetails() {
//	   if(studiengruppe != null) {
//		   return super.getDetails()+ "\nStudiengruppe: " + studiengruppe;
//	   }
//	   else
//		   return super.getDetails()+ "\nkeine Angabe zur Studiengruppe.";
//   }
//   
//   public String getAssignment() {
//	   if(studiengruppe != null) {
//		   return super.getAssignment()+ "\nStudiengruppe: " + studiengruppe;
//	   }
//	   else
//		   return super.getAssignment()+ "\nkeine Angabe zur Studiengruppe";
//   }

}
