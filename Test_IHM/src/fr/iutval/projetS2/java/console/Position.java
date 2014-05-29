package fr.iutval.projetS2.java.console;
/**
 * Donne la position d'une case ou d'une tour
 * 
 * @author prinsacn
 * 
 */

public class Position {

	/**
	 * Num�ro de la ligne
	 */
	private int posiLigne;
	/**
	 * Num�ro de la colonne
	 */
	private int posiColonne;
	

	/**
	 * Permet d'initialiser une position
	 * 
	 * @param posiLigne
	 * @param posiColonne
	 */
	public Position(int posiLigne, int posiColonne) 
	{
		this.posiLigne = posiLigne;
		this.posiColonne = posiColonne;
	}
	
	/**
	 * Retourne le num�ro de colonne
	 */
	public int obtenirPositionColonne() {
		return this.posiColonne;
	}
	
	public boolean equals(Position posi)
	{
		if(this.posiColonne==posi.obtenirPositionColonne())
		{
			if(this.posiLigne==posi.obtenirPositionLigne())
				return true;
		}
		return false;
	}
	/**
	 * Retourne le num�ro de ligne
	 */
	public int obtenirPositionLigne() {
		return this.posiLigne;
	}
}