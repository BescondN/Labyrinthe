package application;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class Labyrinthe implements Explorable {
	
	private int labyrinthe[][];
	private int nbligne;
	private int nbcolone;
	private int startingBox;
	private int arrivalBox;
	private int adjacentBoxes[];
	private String NameLab;
	
	
	//Méthodes
	
	public Labyrinthe() {

	}
	
	public void chargerFichier() {
		Path road = Paths.get("map.txt");
		try {
			String start;
			String end;
			String taille;
			List<String> lignes = Files.readAllLines(road);
			String info;
			NameLab = lignes.get(0);
			start = lignes.get(1);
			end = lignes.get(2);
			taille = lignes.get(3);
			
			//for (String iterateur : lignes) {
			//	info = iterateur; }
		}
		catch (Exception e){
			System.out.println("ERROR : Le fichier ne s'ouvre pas...");
		}
		
		
		
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
