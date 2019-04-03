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
	 * return ( coordY ) + 10 000 * coordX
	 * limit to a matrix of 10 000 x 10 000
	 */
	@Override
	public int hashCode() {
		
		int hash = 0;
		
		hash = hash + coordY;
		hash = hash + ( 10000 * coordX );
		
		
		return hash;
	}
}
