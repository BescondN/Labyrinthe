package application;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class Labyrinthe implements Explorable {
	
	private int labyrinthe[][];
	private List<String> lignes;
	private int nbligne;
	private int nbcolone;
	private int startingBox;
	private int arrivalBox;
	private int adjacentBoxes[];
	private String NameLab;
	
	//M�thodes
	
	public Labyrinthe() {
		chargerFichier();
		labyrinthe = new int[nbligne][nbcolone];
		createLabyrinthe();
		System.out.println("TERMINE");
	}
	
	public void chargerFichier() {
		Path road = Paths.get("map.txt");
		try {
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
		catch (Exception e){
			System.out.println(e);
			System.out.println("ERROR : Le fichier ne s'ouvre pas...");
		}
		
		
		
	}

	public void createLabyrinthe() {
		char pointage;
		for (int i=4; i<lignes.size(); i++)
		{
			System.out.println();
			for (int j=0; j<lignes.get(i).length(); j++) {
				pointage = lignes.get(i).charAt(j);
				if (pointage == '-') {
					labyrinthe[i][j] = 1;
					System.out.print("1");
				}
				if (pointage == ' ') {
					labyrinthe[i][j] = 0;
					System.out.print("0");
				}
				if (pointage == '|') {
					
					labyrinthe[i][j] = 1;
					System.out.print("1");
				}
				if (pointage == '+') {
					labyrinthe[i][j] = 1;
					System.out.print("1");
				}
			}
		}
	}

	@Override
	public Step getDepart() {
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
	
	
	
	
	
	


	//Cr�er Labyrinthe
	//Cherche case d�part
	//Chercher case d'arriv�e
	//Charge fichier
	//getCaseD�part
	//getCaseArriv�e
	//getCaseVoisine
	
	
	
}
