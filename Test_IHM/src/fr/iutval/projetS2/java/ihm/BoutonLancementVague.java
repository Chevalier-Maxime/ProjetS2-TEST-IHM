package fr.iutval.projetS2.java.ihm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class BoutonLancementVague extends JButton implements ActionListener
{
	private PartieTowerDefence partie;
	private int numVague;
	private PanneauGrille map;

	public BoutonLancementVague(PartieTowerDefence p, int vague, String nom, PanneauGrille carte) 
	{
		super(nom);
		this.partie=p;
		this.numVague=vague;
		this.map=carte;
		this.addActionListener(this);
	}
	
	public void changerNumVague(int num)
	{
		this.numVague=num;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		boolean finDuTour=false;
		int numTour=0;
		int numEnnemi=0;

		while((finDuTour==false)&&(this.partie.obtenirVie()>0))
		{
			
			if (numEnnemi==this.partie.obtenirTabDeVague().get(this.numVague).obtenirTabEnnemi().length)
			{
				if(this.partie.obtenirListeEnnemiPresent().size()==0)
				{
					finDuTour=true;
					break;
				}
			}
			if ((numTour%2==0)&&(numEnnemi<this.partie.obtenirTabDeVague().get(this.numVague).obtenirTabEnnemi().length))
			{
				this.partie.obtenirTabDeVague().get(this.numVague).lancerUnEnnemi(numEnnemi, this.partie.obtenirListeEnnemiPresent(), this.partie.obtenirGrille());
				Ennemi ennemiAafficher=this.partie.obtenirListeEnnemiPresent().get(this.partie.obtenirListeEnnemiPresent().size()-1);
				this.map.changerEtatButon(this.partie.obtenirListeEnnemiPresent().get(this.partie.obtenirListeEnnemiPresent().size()-1), 14, 0);
				numEnnemi++;
			}
			/*for(int indice=0; indice<this.listeTour.size(); indice++)
			{
				//this.listeTour.get(indice).attaquer(ennemiAfficher, this.carteDeLaPartie, this.joueurDeLaPartie);
			}*/
			this.partie.obtenirTabDeVague().get(this.numVague).faireAvancerLaVague(this.partie.obtenirListeEnnemiPresent(), this.partie.obtenirGrille(), this.partie.obtenirChemin());
			for(int indice=0;indice<this.map.obtenirChemin().size(); indice++)
			{
				this.map.cheminNeutre(((BouttonAvecPosition)this.map.obtenirChemin().get(indice)).obtenirColonne(), ((BouttonAvecPosition)this.map.obtenirChemin().get(indice)).obtenirLigne());
			}
			for(int indice=0; indice<this.partie.obtenirListeEnnemiPresent().size(); indice++)
			{
				int posiLigne=this.partie.obtenirListeEnnemiPresent().get(indice).obtenirCase().obtenirPosiCase().obtenirPositionLigne();
				int posiColonne=this.partie.obtenirListeEnnemiPresent().get(indice).obtenirCase().obtenirPosiCase().obtenirPositionColonne();
				
				
				for (int index = 0; index < this.map.obtenirChemin().size(); index++) 	
				{
					if ((((BouttonAvecPosition)this.map.obtenirChemin().get(index)).obtenirLigne()== posiLigne)&& (((BouttonAvecPosition)this.map.obtenirChemin().get(index)).obtenirColonne() == posiColonne)) 
					{
	
							this.map.changerEtatButon(this.partie.obtenirListeEnnemiPresent().get(indice),posiColonne,posiLigne );
							break;

					}
				}
			}
			
			numTour++;
				
		}
	}
}
