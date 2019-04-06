//=============================================================================//
//                    Name of file   : "TULabyrinthe.java"                     //
//                    Author         : Alexandre Farret                        //
//                    Creation date  : 02/04/2019                              //
//                    Last update    : 03/04/2019                              //
//=============================================================================//

package application;
import javafx.application.Application;

public class TULabyrinthe {
	
	public static void main(String[] args) 
	{
		Labyrinthe lab = new Labyrinthe("map.txt");
		lab.afficherLabyrinthe();

	}
}
