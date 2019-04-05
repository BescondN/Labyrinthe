//=============================================================================//
//                    Name of file   : "Coordonnees.java"                      //
//                    Author         : Quentin Lamoure                         //
//                    Co-author      : Alexandre Farret                        //
//                    Creation date  : 02/04/2019                              //
//                    Last update    : 05/04/2019                              //
//=============================================================================//

package application;

public class Coordonnees {
	//---- Attributs ----
	private int x, y, hashcode;
	
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
 	* Builder of the Labyrinth
 	* @param hashcode matrix number hashcode
 	*/
	public Coordonnees(int hashcode)
	{
		this.hashcode = hashcode;
	}

	/**
 	* Generate a code with coords X and Y (limit to a matrix of 10 000 x 10 000)
 	* @return (coordY) + 10 000 * coordX
 	*/
	public int generateHashcode()
	{
		hashcode = y;
		hashcode = hashcode + ( 10000 * x );
		return hashcode;
	}
	
	/**
	 * Decode() generate coords X and Y with a hashcode
	 * @param hash is a hashcode
	 * @return {coordX, coordY}
	 */
	public int[] generateCoordonnees(int hash) {
		
		x = hash % 10000;
		y = (hash - x) / 10000;
		int[] coordonnees = {x, y};
		return coordonnees;
	}
}
