package application;

/**
 * @author Quentin
 * 02/04/2016 22:24
 */
public class Coordonnees {
	

	public int x;
	public int y;
	public int hashcode;
	
	
	
	//---- Methods ----
	/**
 	* Builder of the Labyrinth
 	* @param x matrix number x
 	* @param y matrix number y
 	*/
	public Coordonnees(int x, int y)
	{
		this.x = x;
		this.y = y;
		generateHashcode();
	}
	
	

	/**
 	* Generate a code with coords X and Y (limit to a matrix of 10 000 x 10 000)
 	* @return (coordY) + 10 000 * coordX
 	*/
	public void generateHashcode()
	{
		int hashcode = y;
		hashcode += ( 10000 * x );
		this.hashcode = hashcode;
	}
	
 	
	
	/**
	 * Decode() generate coords X and Y with a hashcode
	 * @param hash is a hashcode
	 * @return {coordX, coordY}
	 */
	public static Coordonnees generateCoordonnees(int hash) {
		
		int y = hash % 10000;
		int x = (hash - y) / 10000;
		return new Coordonnees(x,y);
	}
	
	/**
	 * Return x
	 * @return x
	 */
	public int getx()
	{
		return x;
	}
	
	/**
	 * Return y
	 * @return y
	 */
	public int gety()
	{
		return y;
	}
	
	/**
	 * Return Hash Code
	 * @return Hash Code
	 */
	public int gethashCode()
	{
		return hashcode;
	}
}
