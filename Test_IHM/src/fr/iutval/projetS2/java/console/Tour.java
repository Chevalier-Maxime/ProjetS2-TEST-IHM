package fr.iutval.projetS2.java.console;
import java.util.ArrayList;

/**
 * Définition d'une tour
 * 
 * @author prinsacn
 * 
 */

public class Tour
{

	private int perimettreAttaque;
	private int prix;
	private int puissanceAttaque;
	private int pointDeVie;
	private EnumTour typeTour;
	private Case caseTour;

	private final static int PERIMETRE_PETITE_TOUR = 1;
	public final static int PRIX_PETITE_TOUR = 5;
	private final static int PUISSANCE_ATTAQUE_PETITE_TOUR = 2;
	private final static int POINT_DE_VIE_PETITE_TOUR = 5;

	private final static int PERIMETRE_MOYENNE_TOUR = 4;
	public final static int PRIX_MOYENNE_TOUR = 10;
	private final static int PUISSANCE_ATTAQUE_MOYENNE_TOUR = 5;
	private final static int POINT_DE_VIE_MOYENNE_TOUR = 10;

	private final static int PERIMETRE_GRANDE_TOUR = 4;
	public final static int PRIX_GRANDE_TOUR = 25;
	private final static int PUISSANCE_ATTAQUE_GRANDE_TOUR = 15;
	private final static int POINT_DE_VIE_GRANDE_TOUR = 15;

	/**
	 * Permet de creer une nouvelle tour
	 * @param typeTour Type de la tour à creer (Petite, Moyenne ou grande)
	 * @param positionTour position où l'on souhaite creer la tour
	 * @throws CasePleineException si la case est pleine on ne peut pas creer de tour
	 */
	public Tour(EnumTour typeTour, Case positionTour, Joueur joueur, Map carte)
			throws CasePleineException, ArgentInsuffisant
	{ 
		if (positionTour.obtenirCaseEtat() == Etat.VIDE)
		{
		carte.map[positionTour.obtenirPosiCase().obtenirPositionLigne()][positionTour.obtenirPosiCase().obtenirPositionColonne()].changerPosiEtat(Etat.TOUR);
		

			if (typeTour == EnumTour.petiteTour)
			{
				if (joueur.obtenirQtArgent()>=PRIX_PETITE_TOUR)
				{
				this.caseTour = positionTour;
				this.perimettreAttaque = PERIMETRE_PETITE_TOUR;
				this.prix = PRIX_PETITE_TOUR;
				this.puissanceAttaque = PUISSANCE_ATTAQUE_PETITE_TOUR;
				this.pointDeVie = POINT_DE_VIE_PETITE_TOUR;
				joueur.enleverArgent(PRIX_PETITE_TOUR);
				
				
				
				}
				else
					throw new ArgentInsuffisant();
			}
			else if (typeTour == EnumTour.moyenneTour)
			{
				if (joueur.obtenirQtArgent()>=PRIX_MOYENNE_TOUR)
				{
				this.caseTour = positionTour;
				this.perimettreAttaque = PERIMETRE_MOYENNE_TOUR;
				this.prix = PRIX_MOYENNE_TOUR;
				this.puissanceAttaque = PUISSANCE_ATTAQUE_MOYENNE_TOUR;
				this.pointDeVie = POINT_DE_VIE_PETITE_TOUR;
				joueur.enleverArgent(PRIX_MOYENNE_TOUR);
				}
				else
					throw new ArgentInsuffisant();
			}
			else if (typeTour == EnumTour.grosseTour)
			{
				if (joueur.obtenirQtArgent()>=PRIX_GRANDE_TOUR)
				{
				this.caseTour = positionTour;
				this.perimettreAttaque = PERIMETRE_GRANDE_TOUR;
				this.prix = PRIX_GRANDE_TOUR;
				this.puissanceAttaque = PUISSANCE_ATTAQUE_GRANDE_TOUR;
				this.pointDeVie = POINT_DE_VIE_GRANDE_TOUR;
				joueur.enleverArgent(PRIX_GRANDE_TOUR);
				}
				else
					throw new ArgentInsuffisant();
			}
			
			
			
		}
		else
			throw new CasePleineException();
	}

	
	public void suppressionTour()
	{
		this.caseTour.changerPosiEtat(Etat.VIDE);
		/**TODO Comment supprimer ma tour ?*/
		//this.finalize();
	}

	public void attaquer(ArrayList<Ennemi> tabEnnemi, Map mapDePartie, Joueur joueur)
	{
		ArrayList<Case> listeCaseAction=this.caseTour.trouverCaseAdjacentes(this.perimettreAttaque,mapDePartie);
		for (int indice=0; indice<listeCaseAction.size(); indice++)
		{
			if(listeCaseAction.get(indice).obtenirCaseEtat()==Etat.ENNEMI)
			{
				for(int index=0; index<tabEnnemi.size(); index++)
				{
					if(listeCaseAction.get(indice).obtenirPosiCase()==tabEnnemi.get(index).obtenirCase().obtenirPosiCase())
					{
						tabEnnemi.get(index).perdreVie(this.puissanceAttaque);
						tabEnnemi.get(index).testMortEnnemie(mapDePartie, tabEnnemi, joueur );
					}
				}
			}
		}
		

	}

}
