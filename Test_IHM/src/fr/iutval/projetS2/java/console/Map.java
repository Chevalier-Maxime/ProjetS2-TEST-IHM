package fr.iutval.projetS2.java.console;
import java.util.ArrayList;
import java.io.Console;

public class Map
 {
	
	public final static int NOMBRE_COLONNE=30;
	public final static int NOMBRE_LIGNE=30;
	
	
	
	/** Tableau de case quiformelamap. */
	public Case[][] map ;
	/**
	 * liste de case repr�sentant le chemin le plus court
	 */
	public ArrayList<Case> cheminLePlusCourt;
	
	public ArrayList<Case> chemin;
	
	/** Constructeurpermettant d'initialiser laMapavecunetaillede 50/50 */
	public Map()
	{
		map= new Case[NOMBRE_LIGNE][NOMBRE_COLONNE]; 
		this.chemin=new ArrayList<Case>();
		
		for(int colonne=0; colonne<NOMBRE_COLONNE; colonne++)
		 { 
			for(int ligne=0; ligne<NOMBRE_LIGNE; ligne++)
			{
				map[ligne][colonne]=new Case(ligne,colonne);
			}
		 }
		for(int indice=0; indice<4; indice++)
		{
			this.map[14][indice].changerPosiEtat(Etat.CHEMIN);
			this.chemin.add(map[14][indice]);
			
		}
		for(int indice=13; indice>4; indice--)
		{
			this.map[indice][3].changerPosiEtat(Etat.CHEMIN);
			this.chemin.add(map[indice][3]);
		}
		for(int indice=4; indice<15; indice++)
		{
			this.map[5][indice].changerPosiEtat(Etat.CHEMIN);
			this.chemin.add(map[5][indice]);
		}
		for(int indice=6; indice<25; indice++)
		{
			this.map[indice][14].changerPosiEtat(Etat.CHEMIN);
			this.chemin.add(map[indice][14]);
		}
		for(int indice=15; indice<27; indice++)
		{
			this.map[24][indice].changerPosiEtat(Etat.CHEMIN);
			this.chemin.add(map[24][indice]);
		}
		for(int indice=23; indice>13; indice--)
		{
			this.map[indice][26].changerPosiEtat(Etat.CHEMIN);
			this.chemin.add(map[indice][26]);
		}
		for(int indice=27; indice<30; indice++)
		{
			this.map[14][indice].changerPosiEtat(Etat.CHEMIN);
			this.chemin.add(map[14][indice]);
		}
		
		/*try{this.cheminLePlusCourt= this.definitionChemin(this.map[14][0]);}catch (CheminInfesable e){}*/
	}
	
	
	/** affichemamapen console */
	public void afficherMap()
	 {

		for(int colonne=0; colonne<NOMBRE_COLONNE; colonne++)
		 { 
			for(int ligne=0; ligne<NOMBRE_LIGNE; ligne++)
			{
				System.out.print(map[ligne][colonne]);
			}
			System.out.println("\n");
		 }
	 }
	/*public void changerChemin() 
	{
		this.cheminLePlusCourt.removeAll(cheminLePlusCourt);
		this.cheminLePlusCourt= this.definitionChemin(this.map[14][0]);
	}*/
	
	/** choisislaprochaine case pour lechemin */

	/*public CaseAvecParent ChoixProchaineCase(ArrayList<CaseAvecParent> listeCase)
	{
		int coutF=listeCase.get(0).obtenirCoutDAcces()+listeCase.get(0).obtenirCoutDArrivee();
		CaseAvecParent suivCase=listeCase.get(0);
		for(int indice=1; indice<listeCase.size(); indice++)
		{
			if ((listeCase.get(indice).obtenirCoutDAcces()+listeCase.get(indice).obtenirCoutDArrivee())<coutF)
			{
				coutF=listeCase.get(indice).obtenirCoutDAcces()+listeCase.get(indice).obtenirCoutDArrivee();
				suivCase=listeCase.get(indice);
			}
		}
		return suivCase;
	}*/
	
	/**Permetdedefinirlecheminle plus court*/
	/*public ArrayList<Case> definitionChemin(Case caseDeDepart) 
	{

		ArrayList<CaseAvecParent> listeCaseTraitee= new ArrayList<CaseAvecParent>();//closeListe
		ArrayList<CaseAvecParent> listeCaseATraitee= new ArrayList<CaseAvecParent>();//openListe
		ArrayList<Case>chemin= new ArrayList();//cheminFinal
		
		boolean fin=false;
		
		int coutFinal=0;
		
		int indiceBis=1;
		
		Case CaseFin=this.map[14][29];
		
		CaseAvecParent prochaineCase=new CaseAvecParent(14, 0,caseDeDepart, 0,290);//initialisationdeprochaine case avec parent
		
		Case caseParentSansParent=this.map[0][0];//initialisation case parent
		
		CaseAvecParent caseParentAvecParent;
		
		
		

		listeCaseATraitee.add(0, prochaineCase);
		
		for(int indice=0; indice<prochaineCase.trouverCaseAdjacentesAvecParent().size(); indice++ )
		{
			if ((this.map[prochaineCase.trouverCaseAdjacentesAvecParent().get(indice).obtenirPosiCase().obtenirPositionLigne()][prochaineCase.trouverCaseAdjacentesAvecParent().get(indice).obtenirPosiCase().obtenirPositionColonne()].obtenirCaseEtat()==Etat.VIDE))
			{
				listeCaseATraitee.add(listeCaseATraitee.size(),prochaineCase.trouverCaseAdjacentesAvecParent().get(indice));
			}
		}
		
		listeCaseTraitee.add(0,prochaineCase);
		listeCaseATraitee.remove(0);
		
		while (fin==false)
		{
			prochaineCase=ChoixProchaineCase(listeCaseATraitee);
			listeCaseATraitee.remove(listeCaseATraitee.indexOf(prochaineCase));
			listeCaseTraitee.add(listeCaseTraitee.size(),prochaineCase);
			
			if ((listeCaseTraitee.get(listeCaseTraitee.size()-1).obtenirPosiCase().obtenirPositionLigne()==14)&&(listeCaseTraitee.get(listeCaseTraitee.size()-1).obtenirPosiCase().obtenirPositionColonne()==29))
			{
				fin=true;
			}
			else
			{
				prochaineCase.ajoutDesCarreAdjacent(listeCaseATraitee, this);
		
			}
		}
		
		caseParentSansParent=this.map[listeCaseTraitee.get(listeCaseTraitee.size()-1).obtenirParentAvecParent().obtenirPosiCase().obtenirPositionLigne()][listeCaseTraitee.get(listeCaseTraitee.size()-1).obtenirParentAvecParent().obtenirPosiCase().obtenirPositionColonne()];
		
		caseParentAvecParent=listeCaseTraitee.get(listeCaseTraitee.size()-1).obtenirParentAvecParent();
		
		chemin.add(0,CaseFin);
		while (!(chemin.contains(caseDeDepart)))
		{
			
			chemin.add(indiceBis,caseParentSansParent);
			caseParentAvecParent=(CaseAvecParent) caseParentAvecParent.obtenirParent();
			if (caseParentAvecParent!=null)
				caseParentSansParent=this.map[caseParentAvecParent.obtenirPosiCase().obtenirPositionLigne()][caseParentAvecParent.obtenirPosiCase().obtenirPositionColonne()];
			
			
			indiceBis++;
			
		}
		
		
		return chemin;
		

	}*/
	
	/**Changer l'etatdela case ousetrouve l'ennemi*/
	public void afficherEnnemi(Ennemi ennemiAAfficher)
	{
		this.map[ennemiAAfficher.obtenirCase().obtenirPosiCase().obtenirPositionLigne()][ennemiAAfficher.obtenirCase().obtenirPosiCase().obtenirPositionColonne()].changerPosiEtat(Etat.ENNEMI);
	}
	
	public void effacerEnnemi(Ennemi ennemiAEffacer)
	{
		this.map[ennemiAEffacer.obtenirCase().obtenirPosiCase().obtenirPositionLigne()][ennemiAEffacer.obtenirCase().obtenirPosiCase().obtenirPositionColonne()].changerPosiEtat(Etat.CHEMIN);
	}
	
	
	
}

