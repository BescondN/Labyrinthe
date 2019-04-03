package application;

/**
 * @author Quentin
 * 02/04/2016 22:24
 */
public class Coordonnees {
	

	/* hashcode() Generate a code with coords X and Y
	 * @see java.lang.Object#hashCode()
	 * return ( coordY ) + 10 000 * coordX
	 * limit to a matrix of 10 000 x 10 000
	 */
	public static int hashCode(int coordX, int coordY) {
		
		int hash = 0;
		
		hash = hash + coordY;
		hash = hash + ( 10000 * coordX );
		
		
		return hash;
	}
	
	/**Decode() generate coords X and Y with a hashcode
	 * @param hash is a hashcode (int)
	 * @return {coordX, coordY} (int)
	 */
	public static int[] DeCode(int hash) {
		
		int coordX = hash % 10000;
		int coordY = (hash - coordX) / 10000;
		int[] result = {coordX, coordY};
		return result;
	}
}
