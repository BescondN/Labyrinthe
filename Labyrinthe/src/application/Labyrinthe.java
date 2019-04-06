//=============================================================================//
//                    Name of file   : "Labyrinthe.java"                       //
//                    Author         : Alexandre Farret                        //
//                    Creation date  : 02/04/2019                              //
//                    Last update    : 05/04/2019                              //
//=============================================================================//

package application;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Labyrinthe implements Explorable {
	
	//---- Attributs ----
	private int labyrinthe[][];
	private List<String> lignes;
	private int nbligne;
	private int nbcolone;
	private Coordonnees startingBox;
	private Coordonnees arrivalBox;
	private String NameLab;
	
	//---- Methods ----
	/**
 	* Builder of the Labyrinth
 	* @param file Base file
 	*/
	public Labyrinthe(String file)
	{
		chargerFichier(file);
		labyrinthe = new int[nbligne][nbcolone];
		createLabyrinthe();
		generateStartingBox();
		generateArrivalBox();
	}
	
	/**
	 * Loading the file
	 * @param file Base file
	 */
	public void chargerFichier(String file)
	{
		Path road = Paths.get(file);
		try 
		{
			String start;
			String end;
			String size[];
			lignes = Files.readAllLines(road);
			String info;
			NameLab = lignes.get(0);
			start = lignes.get(1);
			end = lignes.get(2);
			size = lignes.get(3).split("	");
			int taille[] = new int[2];
			taille[0] = Integer.parseInt(size[0]);
			taille[1] = Integer.parseInt(size[1]);
			nbligne = taille[0];
			nbcolone =  taille[1];
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println("ERROR : Le fichier ne s'ouvre pas...");
		}
	}
	
	/**
	 * Creation of the labyrinth
	 */
	public void createLabyrinthe()
	{
		char pointage;
		for (int i=4; i<lignes.size(); i++)
		{
			System.out.println();
			for (int j=0; j<lignes.get(i).length(); j++) {
				pointage = lignes.get(i).charAt(j);

				if (pointage == ' ') {
					labyrinthe[i-4][j] = 0;
				}
				else
				{
					labyrinthe[i-4][j] = 1;
				}
			}
		}
	}
	
	/**
	 * Generate starting box
	 */
	public void generateStartingBox()
	{
		String s_starting[] = lignes.get(1).split("	");
		int starting[] = new int[2];
		starting[0] = Integer.parseInt(s_starting[0]);
		starting[1] = Integer.parseInt(s_starting[1]);
		labyrinthe[starting[0]][starting[1]] = 2;
		startingBox = new Coordonnees(starting[0], starting[1]);
	}
	
	/**
	 * Generate arrival box
	 */
	public void generateArrivalBox()
	{
		String s_arrival[] = lignes.get(2).split("	");
		int arrival[] = new int[2];
		arrival[0] = Integer.parseInt(s_arrival[0]);
		arrival[1] = Integer.parseInt(s_arrival[1]);
		labyrinthe[arrival[0]][arrival[1]] = 3;
		arrivalBox = new Coordonnees(arrival[0], arrival[1]);
	}
	
	/**
	 * Return matrix labyrinth
	 * @return table labyrinth
	 */
	public int[][] getLabyrinthe()
	{
		return labyrinthe;
	}
	
	/**
	 * Return matrix labyrinth
	 * @return table labyrinth
	 */
	public void afficherLabyrinthe()
	{
		for(int i=0; i<nbligne; i++) {
			System.out.println();
			for(int j=0; j<nbcolone; j++) {
				System.out.print(labyrinthe[i][j]);
			}
		}
	}
	
	/**
	 * Return the name of the labyrinth
	 * @return name labyrinth
	 */
	public String getNameLabyrinthe() 
	{
		return NameLab;
	}
	
	
	//public Step aroundBox(int hashCode)
	//{
		//Retourne case voisine
		//Genere un hash code pour chacune
		//Retourne sous forme de step
	//}

		
		


	
	
	//Divers...
	
	@Override
	public Step getDepart() {
		
		//return new Step(startingBox.hashCode());
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Step getArrivee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean estArrivee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getCasesVoisines() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//GénérerDepart
	//GénérerSortie
	//RatournerDépart
	//RetournerSortie
	
	
	
	//Cherche case départ
	//Chercher case d'arrivée
	//getCaseDépart
	//getCaseArrivée
	//getCaseVoisine
	
	
	
}
