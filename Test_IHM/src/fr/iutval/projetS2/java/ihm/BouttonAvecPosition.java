package fr.iutval.projetS2.java.ihm;
import javax.swing.JButton;


public class BouttonAvecPosition extends JButton
{
	private int colonne;
	private int ligne;
	
	public BouttonAvecPosition(int j, int i)
	{
		this.colonne=j;
		this.ligne=i;
		this.setEnabled(false);
	}
	
	public int obtenirColonne()
	{
		return this.colonne;
	}
	
	public int obtenirLigne()
	{
		return this.ligne;
	}
}
