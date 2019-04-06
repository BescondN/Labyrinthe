package application;

import java.util.List;

public interface Explorable<E> {
	
	public Step<E> getDepart();
	
	public Step<E> getArrivee();
	
	public Boolean estArrivee(Step<E> etape);
	
	public List<Step<E>> getCasesVoisines(Step<E> etape);

}
