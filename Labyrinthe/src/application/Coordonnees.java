package application;

/**
 * @author Quentin
 * 02/04/2016 22:24
 */
public class Coordonnees {

	int coordX;
	int coordY;
	
	/* hashcode() Generate a code with coords X and Y
	 * @see java.lang.Object#hashCode()
	 * return ( coordY ) + 1000 * coordX
	 */
	@Override
	public int hashCode() {
		
		int hash = 0;
		
		hash = hash + coordY;
		hash = hash + ( 1000 * coordX );
		
		
		return hash;
	}
}
