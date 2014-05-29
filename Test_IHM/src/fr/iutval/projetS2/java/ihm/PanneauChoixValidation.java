package fr.iutval.projetS2.java.ihm;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class PanneauChoixValidation extends JPanel implements ActionListener
{
	private JButton valider;
	private JButton annuler;
	private PanneauChoixNiveau niveauPanneau;
	private PanneauChoixPseudo pseudo;
	private JFrame fenetre;
	private String nomJoueur;
	private int niveau;
	private JeuxIHM partie;
	public PanneauChoixValidation(PanneauChoixNiveau niv,PanneauChoixPseudo nom, JFrame fen)
	{
		
		this.pseudo=nom;
		this.niveauPanneau=niv;
		this.fenetre=fen;
		this.valider = new JButton("Valider");
		//this.valider.setFont(police);
		this.valider.addActionListener(this);
		
		
		this.annuler = new JButton("Annuler");
		//this.annuler.setFont(police);
		this.annuler.addActionListener(this);
		
		this.add(valider);
		this.add(annuler);
	}
	
	public void actionPerformed(ActionEvent e) 
	{	
		if (e.getSource() == valider) 
		{
			int niveauChoisi = 1;
			boolean choix1 = niveauPanneau.obtenirBouton1().isSelected();
			if (choix1 == true) 
			{
				niveauChoisi = 1;
			}
			boolean choix2 = niveauPanneau.obtenirBouton2().isSelected();
			if (choix2 == true) 
			{
				niveauChoisi = 2;
			}
			boolean choix3 = niveauPanneau.obtenirBouton3().isSelected();
			if (choix3 == true) 
			{
				niveauChoisi = 3;
			}
			this.niveau=niveauChoisi;
			this.nomJoueur= this.pseudo.obtenirPseudo().getText().toString();
			SwingUtilities.invokeLater(new JeuxIHM(nomJoueur,niveau));
			fenetre.dispose();
		} 
		else if (e.getSource() == annuler) 
		{
			fenetre.dispose();
		}
	}

}
