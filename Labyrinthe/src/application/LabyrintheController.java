package application;

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
import javafx.scene.shape.Rectangle;

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
		Affichage(labyrinthe);
		
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
			Affichage(labyrinthe);
		}
		
		
		
	}
	
		
	/************Affichage du labyrinthe***********/
	@FXML
	public  GridPane grid;	
	
	
	public  void Affichage(Labyrinthe lab) {
	
		

		grid.getChildren().clear();
		int[][] tab = lab.getLabyrinthe();

			    
		 for(int i = 0; i < tab.length; i++)
		 {
             for(int j = 0; j < tab[i].length; j++)
             {
                 TextField tf = new TextField();
                 tf.setPrefSize(50,50);
                 tf.setMaxSize(50,50);
                 tf.setEditable(false);
                 if(tab[i][j] == 1)
                 {
                     tf.setStyle("-fx-control-inner-background: black");
                 }
           
   
                 
            	 grid.add(tf, j, i);
             }
		 }
		Coordonnees depart = lab.startingBox;
		Coordonnees arrivee =lab.arrivalBox;

		((TextField)grid.getChildren().get(depart.getx()*(tab[0].length)+depart.gety())).setStyle("-fx-control-inner-background: green");
		((TextField)grid.getChildren().get(arrivee.getx()*(tab[0].length)+arrivee.gety())).setStyle("-fx-control-inner-background: red");
		
	}
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
					
					((TextField)grid.getChildren().get(en.getx()*(tab[0].length)+en.gety())).setStyle("-fx-control-inner-background: blue");
				}
				
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,"Pas de chemin !","Labyrinthe", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
}
