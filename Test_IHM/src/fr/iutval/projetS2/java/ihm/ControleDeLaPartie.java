package fr.iutval.projetS2.java.ihm;
import java.util.ArrayList;




public interface ControleDeLaPartie 
{
	public ArrayList<Case> obtenirChemin();
	
	public ArrayList<Case> definirChemin(Case[][] map);
	
	public Case[][] obtenirGrille();
	
	public void changerChemin(ArrayList<Case> nouveauChemin);
	
	public void lancerUnTour(int nbTour);
	
	public int obtenirVie();
	
	public ArrayList<Vague> obtenirTabDeVague();

}
