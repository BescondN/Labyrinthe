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
	
	
	//Méthodes
	
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

	//Créer Labyrinthe
	//Cherche case départ
	//Chercher case d'arrivée
	//Charge fichier
	//getCaseDépart
	//getCaseArrivée
	//getCaseVoisine
	
	
	
}
