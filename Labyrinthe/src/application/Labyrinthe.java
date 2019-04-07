package application;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Labyrinthe implements Explorable<Step<Integer>> {
	
	private int labyrinthe[][];
	private List<String> lignes;
	private int nbligne;
	private int nbcolone;
	public Coordonnees startingBox;
	public Coordonnees arrivalBox;
	private String NameLab;
	
	/**
 	* Builder of the Labyrinth
 	* @param file Base file
 	*/
	public Labyrinthe(String file) {
		chargerFichier(file);
		labyrinthe = new int[nbligne][nbcolone];
		createLabyrinthe();
	}
	
	/**
	 * Loading the file
	 * @param file Base file
	 */
	public void chargerFichier(String file) {
		Path road = Paths.get("Labyrinthe/"+file);
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
			
			String startX,startY, endX, endY;
			
			startX = start.split("	")[0];
			startY = start.split("	")[1];
			
			endX = end.split("	")[0];
			endY = end.split("	")[1];
			
			startingBox = new Coordonnees(Integer.parseInt(startX), Integer.parseInt(startY));
			arrivalBox = new Coordonnees(Integer.parseInt(endX), Integer.parseInt(endY));

			
			
		}
		catch (Exception e){
			System.out.println(e);
			System.out.println("ERROR : Le fichier ne s'ouvre pas...");
		}
	}
	
	/**
	 * Creation of the labyrinth
	 */
	public void createLabyrinthe() {
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
	
	/*
	 * Turn the labyrinth upside down
	 */
	public int[][] getLabyrinthe() {
		return labyrinthe;
	}

	@Override
	public Step getDepart() {
		

		return new Step<Integer>(startingBox.gethashCode());
	}

	@Override
	public Step getArrivee() {
		
		return new Step<Integer>(arrivalBox.gethashCode());
	}

	@Override
	public Boolean estArrivee(Step etape) {
		
		Coordonnees coor = Coordonnees.generateCoordonnees((int) etape.Get_Own_Box());
		if(coor.getx() == arrivalBox.getx() && coor.gety() == arrivalBox.gety())
		{
			return true;
		}
		return false;
	}

	@Override
	public List getCasesVoisines(Step etape) {
		
		List<Step<Integer>> adjacentsBoxes = new ArrayList<Step<Integer>>();
		Coordonnees currentStep = (Coordonnees.generateCoordonnees((int)etape.Get_Own_Box()));
		
		if(currentStep.getx()>0)
		{
			if(labyrinthe[currentStep.getx()-1][currentStep.gety()] == 0)
			{
				adjacentsBoxes.add(new Step<Integer>(new Coordonnees(currentStep.getx()-1, currentStep.gety()).gethashCode()));
			}
		}
		if(currentStep.getx()<labyrinthe.length-1)
		{
			if(labyrinthe[currentStep.getx()+1][currentStep.gety()] == 0)
			{
				adjacentsBoxes.add(new Step<Integer>(new Coordonnees(currentStep.getx()+1, currentStep.gety()).gethashCode()));
			}
		}
		if(currentStep.gety()>0)
		{
			if(labyrinthe[currentStep.getx()][currentStep.gety()-1] == 0)
			{
				adjacentsBoxes.add(new Step<Integer>(new Coordonnees(currentStep.getx(), currentStep.gety()-1).gethashCode()));
			}
		}
		if(currentStep.gety()<labyrinthe[0].length-1)
		{
			if(labyrinthe[currentStep.getx()][currentStep.gety()+1] == 0)
			{
				adjacentsBoxes.add(new Step<Integer>(new Coordonnees(currentStep.getx(), currentStep.gety()+1).gethashCode()));
			}
		}
		return adjacentsBoxes;
	}

	@Override
	public void setLongueurArrivee(Step etape) {
		
		Coordonnees coor = Coordonnees.generateCoordonnees((int) etape.Get_Own_Box());
		
		etape.setLongueurArrivee(Math.abs(coor.getx()-arrivalBox.getx())+Math.abs(coor.gety()-arrivalBox.gety()));
		
	}
	
	
	
}
