package application;

/**
 * @author Quentin
 * 02/04/2016 22:24
 */
public class Coordonnees {
	
	private int x,y;
	
	public Coordonnees(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	/* hashcode() Generate a code with coords X and Y
	 * @see java.lang.Object#hashCode()
	 * return ( coordY ) + 10 000 * coordX
	 * limit to a matrix of 10 000 x 10 000
	 */
	public int hashCode() {
		
		int hash = 0;
		
		hash = hash + y;
		hash = hash + ( 10000 * x );
		
		
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
