package anwendung;

public class Adresse  {//implements Cloneable { Cloneable notwenig?
		private String strasse;
	    private String hausnr;
	    private int plz;
	    private String ort;

	    //leerer Konstruktor
	    public Adresse() {}
	    
	    //Konstruktor
	    public Adresse(String strasse, String hausnr, int plz, String ort) throws AdressException {
	    	/*if(ort != null) { //oder so: */if(ort != null  && strasse != null && hausnr != null && plz != 0) {
	    		this.strasse = strasse;
	    		this.hausnr = hausnr;
	    		this.plz = plz;
	    		this.ort = ort;
	    	}
	    	else
	    		throw new AdressException ("Adresse wurde nicht vollständig eingegeben!\n");
	    }

	    public String getStrasse(){
	    	return strasse;
	    }
	    
	    public String getHausnr(){
	    	return hausnr;
	    }
		    
	    public int getPlz(){
	    	return plz;
	    }
		    
	    public String getOrt(){
	    	return ort;
	    }
	    
		public void setStrasse(String strasse){
		   this.strasse = strasse;
		}
		    
	     public void setHausnr(String hausnr){
		   this.hausnr = hausnr;
		 }
		    
		 public void setPlz(int plz) {
		   this.plz = plz;
		 }
		    
		  public void setOrt(String ort) {
		    this.ort = ort;
	      }
		  
		  public Adresse clone() 
				  throws CloneNotSupportedException {
			  return (Adresse)super.clone();
		  }

		  //Adresse
		  public String toString(){
		    return strasse + " " + hausnr + "\n" + plz + " " +ort;
		  }

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((hausnr == null) ? 0 : hausnr.hashCode());
			result = prime * result + ((ort == null) ? 0 : ort.hashCode());
			result = prime * result + plz;
			result = prime * result + ((strasse == null) ? 0 : strasse.hashCode());
			return result;
		}

		
		//vergleichen der Adresse: hausnr, ort, plz und strasse wird vergliechen
//		@Override
		public boolean equalsAdr(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Adresse other = (Adresse) obj;
			if (hausnr == null) {
				if (other.hausnr != null)
					return false;
			} else if (!hausnr.equals(other.hausnr))
				return false;
			if (ort == null) {
				if (other.ort != null)
					return false;
			} else if (!ort.equals(other.ort))
				return false;
			if (plz != other.plz)
				return false;
			if (strasse == null) {
				if (other.strasse != null)
					return false;
			} else if (!strasse.equals(other.strasse))
				return false;
			return true;
		}
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  /*
		@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			
			if (getClass() != obj.getClass())
				return false;
			
			Adresse other = (Adresse) obj;
			
			if (hausnr == null) {
				if (other.hausnr != null)
					return false;
			} else if (!hausnr.equals(other.hausnr))
				return false;
			
			if (ort == null) {
				if (other.ort != null)
					return false;
			} else if (!ort.equals(other.ort))
				return false;
			
			if (plz != other.plz)
				return false;
			
			if (strasse == null) {
				if (other.strasse != null)
					return false;
			} else if (!strasse.equals(other.strasse))
				return false;
			
			return true;
		}*/
}
