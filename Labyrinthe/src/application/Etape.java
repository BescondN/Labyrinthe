package application;

/**
 * @author Quentin
 * 02/04/2016 22:24
 */
public class Etape {

	int coordX;
	int coordY;
	
	/* hashcode() Generate a code with coords X and Y
	 * @see java.lang.Object#hashCode()
	 * return ( coordY ) * 42 + coordX
	 */
	@Override
	public int hashCode() {
		
		int hash = 0;
		
		hash = hash + coordY;
		hash = hash * 42 + coordX;
		
		return hash;
	}
}
