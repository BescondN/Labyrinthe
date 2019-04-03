package application;

public interface Explorable<E> {
	
	public void getDepart();
	
	public void getArrivee();
	
	public Boolean estArrivee();
	
	public List<Etape> getCasesVoisines();

}
