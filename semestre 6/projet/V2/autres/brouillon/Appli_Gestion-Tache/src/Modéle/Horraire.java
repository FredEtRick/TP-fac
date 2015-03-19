package Modle;

import java.util.Date;

public class Horraire {
	private int heure; 
	private int minute; 
	
	Horraire(){}; 
	Horraire(int h,int min){
		heure=h; 
		minute=min; 
	}
	public String toString(){
		return this.heure+":"+this.minute; 
	}
}
