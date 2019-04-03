package application;

import java.util.List;

public interface Explorable<E> {
	
	public Coordonnees getDepart();
	
	public Coordonnees getArrivee();
	
	public Boolean estArrivee();
	
	public List<Step> getCasesVoisines();

}
