package application;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class Labyrinthe implements Explorable {
	
	private int labyrinthe[][];
	private int startingBox;
	private int arrivalBox;
	private int adjacentBoxes[];
	
	
	//M�thodes
	
	public Labyrinthe(String fichier) {
		chargerFichier();
	}
	
	public void chargerFichier() {
		Path road = Paths.get("map.txt");
		boolean reponse = Files.exists(road);
		System.out.println(reponse);
		
		
		
	}

	
	
	
	
	
	
	
	
	
	@Override
	public Coordonnees getDepart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coordonnees getArrivee() {
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
