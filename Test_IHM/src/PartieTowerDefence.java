import java.util.ArrayList;




public class PartieTowerDefence implements ControleDeLaPartie
{
	public final static int NOMBRE_COLONNE=30;
	public final static int NOMBRE_LIGNE=30;
	
	private Case[][] grille;
	private ArrayList<Case> chemin;
	private ArrayList<Vague> vagueNiveau;
	private ArrayList<Ennemi> EnnemiPresent;
	private Joueur joueurPartie;
	private int vie;
	
	 public PartieTowerDefence(String nom,int niveau)
	 {
		 this.grille= new Case[NOMBRE_LIGNE][NOMBRE_COLONNE];
		 for(int colonne=0; colonne<NOMBRE_COLONNE; colonne++)
		 { 
			for(int ligne=0; ligne<NOMBRE_LIGNE; ligne++)
			{
				this.grille[ligne][colonne]=new Case(ligne,colonne);
			}
		 }
		 this.chemin=new ArrayList<Case>();
		 this.EnnemiPresent = new ArrayList<Ennemi>();
		 this.vagueNiveau= new ArrayList<Vague>();
		 if(niveau==1)
		 {
			this.vagueNiveau.add(0, new Vague1());
			this.vagueNiveau.add(1, new Vague1());
			this.vagueNiveau.add(2, new Vague1());
			this.vagueNiveau.add(3, new Vague2());			
		 }
		 if(niveau==2)
		 {
			this.vagueNiveau.add(0, new Vague1());
			this.vagueNiveau.add(1, new Vague1());
			this.vagueNiveau.add(2, new Vague2());
			this.vagueNiveau.add(3, new Vague2());
			this.vagueNiveau.add(4, new Vague2());
			this.vagueNiveau.add(6, new Vague3());
		 }
		 if(niveau==3)
		 {
			this.vagueNiveau.add(0, new Vague1());
			this.vagueNiveau.add(1, new Vague1());
			this.vagueNiveau.add(2, new Vague1());
			this.vagueNiveau.add(3, new Vague3());
			this.vagueNiveau.add(4, new Vague2());
			this.vagueNiveau.add(6, new Vague2());
			this.vagueNiveau.add(7, new Vague2());
			this.vagueNiveau.add(8, new Vague4()); 
		 }
		 this.joueurPartie=new Joueur(nom);
		 this.vie=20;
		 
	 }
	 
	 public ArrayList<Case> definirChemin(Case[][] map)
	 {
		 ArrayList<Case> route=new ArrayList<Case>();
		
		for(int indice=0; indice<4; indice++)
		{
			this.grille[14][indice].changerPosiEtat(Etat.CHEMIN);
			route.add(map[14][indice]);
		}
		for(int indice=13; indice>4; indice--)
		{
			this.grille[indice][3].changerPosiEtat(Etat.CHEMIN);
			route.add(map[indice][3]);
		}
		for(int indice=4; indice<15; indice++)
		{
			this.grille[5][indice].changerPosiEtat(Etat.CHEMIN);
			route.add(map[5][indice]);
		}
		for(int indice=6; indice<25; indice++)
		{
			this.grille[indice][14].changerPosiEtat(Etat.CHEMIN);
			route.add(map[indice][14]);
		}
		for(int indice=15; indice<27; indice++)
		{
			this.grille[24][indice].changerPosiEtat(Etat.CHEMIN);
			route.add(map[24][indice]);
		}
		for(int indice=23; indice>13; indice--)
		{
			this.grille[indice][26].changerPosiEtat(Etat.CHEMIN);
			route.add(map[indice][26]);
		}
		for(int indice=27; indice<30; indice++)
		{
			this.grille[14][indice].changerPosiEtat(Etat.CHEMIN);
			route.add(map[14][indice]);
		}
		return route;
	 }
	 @Override
	 public Case[][] obtenirGrille()
	 {
		 return this.grille;
	 }
	 @Override
	 public ArrayList<Case> obtenirChemin()
	 {
		 return this.chemin;
	 }
	 
	 @Override
	 public void changerChemin(ArrayList<Case> nouveauChemin)
	 {
		 this.chemin.removeAll(this.chemin);
		 this.chemin=nouveauChemin;
	 }
	 public void mettreAjourVie(int viePerdue)
	 {
		 this.vie=this.vie+viePerdue;
	 }
	 
	 public ArrayList<Ennemi> obtenirListeEnnemiPresent()
	 {
		 return this.EnnemiPresent;
	 }
	 public int obtenirVie()
	 {
		 return this.vie;
	 }
	 
	 public ArrayList<Vague> obtenirTabDeVague()
	 {
		 return this.vagueNiveau;
	 }
	
	 @Override
	 public void lancerUnTour(int nbTour)
		{
			boolean finDuTour=false;
			int numTour=0;
			int numEnnemi=0;
			
			/*this.carteDeLaPartie.changerChemin();*/
			
				while((finDuTour==false)&&(this.vie>0))
				{
					if (numEnnemi==this.vagueNiveau.get(nbTour).obtenirTabEnnemi().length)
					{
						if(this.EnnemiPresent.size()==0)
						{
							System.out.println("Fin du tour");
							finDuTour=true;
							break;
						}
					}
					if ((numTour%2==0)&&(numEnnemi<this.vagueNiveau.get(nbTour).obtenirTabEnnemi().length))
					{
						this.vagueNiveau.get(nbTour).lancerUnEnnemi(numEnnemi, EnnemiPresent, this.grille);
						numEnnemi++;
					}
					/*for(int indice=0; indice<this.listeTour.size(); indice++)
					{
						//this.listeTour.get(indice).attaquer(ennemiAfficher, this.carteDeLaPartie, this.joueurDeLaPartie);
					}*/
					this.vagueNiveau.get(nbTour).faireAvancerLaVague(EnnemiPresent, this.grille, this.chemin);
					numTour++;
					
				}
				
			}
	
	 

}
