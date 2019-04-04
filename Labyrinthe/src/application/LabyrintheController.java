package application;

	import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
	import javafx.geometry.Pos;
	import javafx.scene.layout.GridPane;

public class LabyrintheController {
		
	@FXML
	public Button Lancer;
	
	@FXML	
	public ComboBox Atelier;
	
	@FXML	
	public ComboBox Algo;
	
	@FXML
	public void actionLancer (ActionEvent evt){
		
	}
	
	ObservableList<String> listAtelier = FXCollections.observableArrayList("Atelier1","Atelier3");
	ObservableList<String> listAlgo = FXCollections.observableArrayList("Algo1","Algo2");

	@FXML
	public void actionAtelier (ActionEvent evt){
		
	}
	
	
	@FXML
	public void actionAlgo (ActionEvent evt){
		
	}
	
		
	/************Affichage du labyrinthe***********/
	@FXML
	public  GridPane grid;	
	
	
	public  void Affichage() {
	
		int[][] tab = { { 1,1,1,0 }, { 0,0,0,1 }, { 0,1,0,0 }, { 1,1,0,1 } };

		grid.setPrefHeight(200);
		grid.setPrefWidth(200);
		grid.setHgap(0);
		grid.setVgap(0);
	    
		int u = tab.length;
		for (int i = 0; i<u; i++)
		{
			int[] e = tab[i];
			for (int a = 0; a < e.length; a++)
			{

				TextField tf = new TextField();
				tf.setPrefSize(200/4, 200/4);
				tf.setEditable(false);
				tf.setText("");
				
				if(e[a]==1) {
					tf.setStyle("-fx-control-inner-background: black;");
					grid.add(tf, i, a);
				} else
				{
				    tf.setStyle("-fx-control-inner-background: white;");
					grid.add(tf, i, a);
				}
			}
		}
	}
	public void initialize()
	{
		Affichage();
		Atelier.setItems(listAtelier);
		Algo.setItems(listAlgo);


	}
	
}
