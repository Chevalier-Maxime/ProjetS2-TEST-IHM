package fr.iutval.projetS2.java.ihm;
import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * 
 * @author Groupe 10
 * 
 */
public abstract class Ennemi {
	public final static Position POSITION_DE_FIN = new Position(14, 29);

	private Case caseEnnemi;
	private String nomEnnemi;
	private int vie_Ennemi;
	private int pointDegats;
	private int scoreGagne;

	/**
	 * Constructeur ennemi
	 * 
	 * @param nom
	 * @param vie
	 * @param degat
	 * @param posiDepart
	 */
	public Ennemi(String nom, int vie, int degat, Case caseDepart, int score) {
		caseEnnemi = caseDepart;
		nomEnnemi = nom;
		vie_Ennemi = vie;
		pointDegats = degat;
		scoreGagne = score;
	}

	public Case obtenirCase() {
		return this.caseEnnemi;
	}

	public void changerCaseEnnemi(Case nvCase) {
		this.caseEnnemi = nvCase;
	}

	public int obtenirVie() {
		return this.vie_Ennemi;
	}

	public int obtenirPtDegats() {
		return this.pointDegats;
	}
	
	public String obtenirNomEnnemi()
	{
		return this.nomEnnemi;
	}

	public void avancer(ArrayList<Case> chemin, Case[][] carte) {

		int caseEnnemiPositionLigne = this.caseEnnemi.obtenirPosiCase().obtenirPositionLigne();
		int caseEnnemiPositionColonne = this.caseEnnemi.obtenirPosiCase().obtenirPositionColonne();
		carte[caseEnnemiPositionLigne][caseEnnemiPositionColonne].changerPosiEtat(Etat.CHEMIN);

		for (int indice = 0; indice < chemin.size(); indice++) 
		{
			if ((chemin.get(indice).obtenirPosiCase().obtenirPositionLigne() == caseEnnemiPositionLigne)&& (chemin.get(indice).obtenirPosiCase().obtenirPositionColonne() == caseEnnemiPositionColonne)) 
			{
				if (indice +1< chemin.size()) 
				{
					caseEnnemiPositionLigne = chemin.get(indice + 1).obtenirPosiCase().obtenirPositionLigne();
					caseEnnemiPositionColonne = chemin.get(indice + 1).obtenirPosiCase().obtenirPositionColonne();
					carte[caseEnnemiPositionLigne][caseEnnemiPositionColonne].changerPosiEtat(Etat.ENNEMI);
					this.changerCaseEnnemi(chemin.get(indice + 1));
					break;
				}
			}
		}
	}

	public void testVictoireEnnemie(PartieTowerDefence partieDonnee) 
	{
		if (this.obtenirCase().obtenirPosiCase().obtenirPositionLigne() == 14) 
		{
			if (this.obtenirCase().obtenirPosiCase().obtenirPositionColonne() == 29) 
			{
				partieDonnee.obtenirListeEnnemiPresent().remove(partieDonnee.obtenirListeEnnemiPresent().indexOf(this));
				partieDonnee.mettreAjourVie(-this.pointDegats);
			}
		}
	}

	public void testMortEnnemie(Case[][] carteJeu,ArrayList<Ennemi> listeEnnemiAffiche, Joueur joueur) 
	{
		if (this.vie_Ennemi <= 0) 
		{
			listeEnnemiAffiche.remove(listeEnnemiAffiche.indexOf(this));
			joueur.mettreAJourScore(this.scoreGagne);
		}

	}

	public void perdreVie(int degats) 
	{
		this.vie_Ennemi = this.vie_Ennemi - degats;
	}

}
