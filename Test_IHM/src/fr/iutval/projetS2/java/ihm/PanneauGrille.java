package fr.iutval.projetS2.java.ihm;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;


public class PanneauGrille extends JPanel
{	
	public final static int NOMBRE_COLONNE=30;
	public final static int NOMBRE_LIGNE=30;
	private ArrayList<JButton> chemin;
	private JButton[][] grille;
	
	public PanneauGrille(ArrayList<Case> route)
	{
		this.setBackground(Color.WHITE);
		this.setLayout(new GridLayout(30, 30));
		this.grille=new JButton[NOMBRE_LIGNE][NOMBRE_COLONNE];
		this.chemin=new ArrayList<JButton>();
		
		for (int i = 0; i < NOMBRE_LIGNE; i++) 
		{
			for (int j = 0; j < NOMBRE_COLONNE; j++) 
			{
				boolean appartienAuChemin=false;
				for(int indice=0; indice<route.size(); indice++)
				{
					if(route.get(indice).obtenirPosiCase().obtenirPositionColonne()==j)
					{
						if(route.get(indice).obtenirPosiCase().obtenirPositionLigne()==i)
						{
							appartienAuChemin=true;
						}
					}
							
				}
				if(appartienAuChemin==true)
				{
					this.grille[i][j]= new BouttonAvecPosition(j,i);
					this.grille[i][j].setBackground(Color.BLACK);
					this.add(this.grille[i][j]);
					this.chemin.add(this.grille[i][j]);
				}
				else
				{
					this.grille[i][j]=new BCase(i, j);
					this.add(this.grille[i][j]);
				}
				
			}
		}
	}
	public void cheminNeutre(int colonne, int ligne)
	{
		this.grille[ligne][colonne].setBackground(Color.BLACK);
	}
	public void changerEtatButon(Ennemi ennemi, int colonne, int ligne)
	{
		if(ennemi.obtenirNomEnnemi()=="gea")
		{
			for(int indice=0; indice<this.chemin.size(); indice++)
			{
				if((((BouttonAvecPosition)this.chemin.get(indice)).obtenirLigne()== ligne)&& (((BouttonAvecPosition)this.chemin.get(indice)).obtenirColonne() == colonne))
				{
					this.chemin.get(indice).setBackground(Color.GREEN);
					break;
				}
			}
		}
		if (ennemi.obtenirNomEnnemi()=="tc")
		{
			for(int indice=0; indice<this.chemin.size(); indice++)
			{
				if((((BouttonAvecPosition)this.chemin.get(indice)).obtenirLigne()== ligne)&& (((BouttonAvecPosition)this.chemin.get(indice)).obtenirColonne() == colonne))
				{
					this.chemin.get(indice).setBackground(Color.BLUE);
					break;
				}
			}
		}
		if (ennemi.obtenirNomEnnemi()=="boss1")
		{
			for(int indice=0; indice<this.chemin.size(); indice++)
			{
				if((((BouttonAvecPosition)this.chemin.get(indice)).obtenirLigne()== ligne)&& (((BouttonAvecPosition)this.chemin.get(indice)).obtenirColonne() == colonne))
				{
					this.chemin.get(indice).setBackground(Color.ORANGE);
					break;
				}
			}
		}
		if (ennemi.obtenirNomEnnemi()=="boss2")
		{
			for(int indice=0; indice<this.chemin.size(); indice++)
			{
				if((((BouttonAvecPosition)this.chemin.get(indice)).obtenirLigne()== ligne)&& (((BouttonAvecPosition)this.chemin.get(indice)).obtenirColonne() == colonne))
				{
					this.chemin.get(indice).setBackground(Color.RED);
					break;
				}
			}
		}
	}
	
	public ArrayList<JButton> obtenirChemin()
	{
		return this.chemin;
	}
	
	public JButton[][] obtenirGrille()
	{
		return this.grille;
	}
	
	

}
