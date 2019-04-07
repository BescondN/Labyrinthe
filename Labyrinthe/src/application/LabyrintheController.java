package application;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LabyrintheController {
		
	@FXML
	public Button Lancer;
	
	@FXML	
	public ComboBox Atelier;
	
	@FXML	
	public ComboBox Algo;
	
	@FXML	
	public Label Temps;
	
	private Labyrinthe labyrinthe;
	private Algo algoRecherche;
	
	@FXML
	public void actionLancer (ActionEvent evt){
		
		if(Atelier.getValue() == null)
		{
	    	JOptionPane.showMessageDialog(null,"Sélectionner un atelier !","Labyrinthe", JOptionPane.INFORMATION_MESSAGE);

		}
		
		algoRecherche = new Algo();	
		
		if(Algo.getValue() == null)
		{
	    	JOptionPane.showMessageDialog(null,"Sélectionner un algo de recherche!","Labyrinthe", JOptionPane.INFORMATION_MESSAGE);

		}
		else
		{
			if(Algo.getValue().toString().equals("Largeur"))
			{
				showWay(algoRecherche.Largeur(labyrinthe));
			}
			else if(Algo.getValue().toString().equals("Profondeur"))
			{
				showWay(algoRecherche.Profondeur(labyrinthe));
			}
			else if(Algo.getValue().toString().equals("A*"))
			{
				showWay(algoRecherche.Largeur(labyrinthe));
			}
		}
	}
	
	

	@FXML
	public void actionAtelier (ActionEvent evt){
		
		
		ComboBox selectAtelier = (ComboBox)evt.getSource();
		labyrinthe = new Labyrinthe(selectAtelier.getValue().toString());
		createContent(labyrinthe);
		
	}
	
	
	@FXML
	public void actionAlgo (ActionEvent evt){
		
		if(Atelier.getValue() == null)
		{
	    	JOptionPane.showMessageDialog(null,"Sélectionner aussi un atelier!","Labyrinthe", JOptionPane.INFORMATION_MESSAGE);

		}
		else
		{
			labyrinthe = new Labyrinthe(Atelier.getValue().toString());
			createContent(labyrinthe);
		}
		
		
		
	}
	
		
	/************Affichage du labyrinthe***********/
	@FXML
	public  Pane grid;	
	
	
	public void initialize()
	{
		ObservableList<String> listAtelier = FXCollections.observableArrayList("map.txt","map2.txt","map3.txt","map4.txt","map5.txt","mapEchec.txt");
		ObservableList<String> listAlgo = FXCollections.observableArrayList("Largeur","Profondeur","A*");
		
		Atelier.setItems(listAtelier);
		Algo.setItems(listAlgo);


	}
	
	private void showWay(Step chemin)
	{
       Queue<Step> r = new LinkedList<Step>();
       int[][] tab = labyrinthe.getLabyrinthe();
       long tempsMicro = TimeUnit.NANOSECONDS.toMicros(algoRecherche.getTime());
       Temps.setText("Temps : " + tempsMicro + "us");
		try
		{
			r.add(chemin.Get_Previous_Box());
			Coordonnees en;
			
			while(!r.isEmpty())
			{
				chemin = r.poll();
				
				if(chemin.Get_Previous_Box()!= null)
				{
					r.add(chemin.Get_Previous_Box());
					en = (Coordonnees.generateCoordonnees((int) chemin.Get_Own_Box()));
					allTile[en.getx()][en.gety()].uneCase.setFill(Color.CORAL);
				}
				
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,"Pas de chemin !","Labyrinthe", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private Tile[][] allTile;
	
	 private static final int CASE_SIZE = 15;
	 
	private void createContent(Labyrinthe lab) {
		
        Pane laby = new Pane();
        grid.getChildren().clear();
        
        int[][] tab = lab.getLabyrinthe();
        allTile = new Tile[tab.length][tab[0].length];
        for (int i = 0; i < tab.length; i++) 
        {
            for (int j = 0; j < tab[i].length; j++) 
            {
                Tile tile = new Tile(j, i, tab[i][j]);
                allTile[i][j] = tile;
                laby.getChildren().add(tile);
            }
        }
        
        Coordonnees depart = lab.startingBox;
		Coordonnees arrivee =lab.arrivalBox;
		
        Text textD = new Text("D");

        Text textA = new Text("A");

		allTile[depart.getx()][depart.gety()].uneCase.setFill(Color.LIGHTSKYBLUE);
		allTile[depart.getx()][depart.gety()].getChildren().addAll(textD);
		allTile[arrivee.getx()][arrivee.gety()].uneCase.setFill(Color.GREENYELLOW);
		allTile[arrivee.getx()][arrivee.gety()].getChildren().addAll(textA);
        
        grid.getChildren().add(laby);
    }
	
	private class Tile extends StackPane {
        private int x, y;

        private Rectangle uneCase = new Rectangle(CASE_SIZE,CASE_SIZE);
    
        public Tile(int x, int y, int val) {
            this.x = x;
            this.y = y;
                       
            if(val == 0)
            	uneCase.setFill(Color.TRANSPARENT);

            getChildren().addAll(uneCase);
            uneCase.setStroke(Color.LIGHTGRAY);
            setTranslateX(x * uneCase.getWidth());
            setTranslateY(y * uneCase.getHeight());
            		
        }
    }
	
}
