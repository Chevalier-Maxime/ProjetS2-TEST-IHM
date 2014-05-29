import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JPanel;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * T�che g�rant l'IHM (cr�ation, affichage)
 * 
 */
public class JeuxIHM implements Runnable, ActionListener, KeyListener {
	private JFrame fenetre;
	
	private JDialog fenetreNiveauEtPseudo;
	
	private BoutonLancementVague lancerVague;
	
	private BarreDeMenuTowerDefence barreDeMenu;
	
	private MenuIHM partie;
	
	private PanneauChoixTour listeTour;
	
	private PanneauGrille grille;
	
	private ControleDeLaPartie jeu; 

	public JeuxIHM(String nomJoueur, int niv) 
	{
		this.jeu=new PartieTowerDefence(nomJoueur, niv);
	}

	private void initialiserLInterfaceGraphique() {
		
		this.fenetre = new JFrame();

		//Ajout du menu dans la fenetre
		this.barreDeMenu= new BarreDeMenuTowerDefence(partie, fenetre);
		this.fenetre.setJMenuBar(barreDeMenu);
		this.fenetre.setTitle("TowerIUT");
		this.fenetre.setSize(740, 1000);
		this.fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


		this.jeu.changerChemin(this.jeu.definirChemin(this.jeu.obtenirGrille()));
		this.listeTour= new PanneauChoixTour(this.partie);
		this.grille= new PanneauGrille(this.jeu.obtenirChemin());
		this.lancerVague = new BoutonLancementVague((PartieTowerDefence) this.jeu, 0, "lancer vague",this.grille);
		this.lancerVague.addActionListener(this);

		//

		JSplitPane splitPaneBas = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPaneBas.add(this.lancerVague);
		splitPaneBas.add(this.listeTour);
		splitPaneBas.setEnabled(false);
		splitPaneBas.setBorder(null);
		splitPaneBas.setResizeWeight(0.3);
		splitPaneBas.setDividerSize(0);
		
		
		JSplitPane Jeu = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		Jeu.add(this.grille);
		Jeu.add(splitPaneBas);
		Jeu.setEnabled(false);
		Jeu.setBorder(null);
		Jeu.setResizeWeight(0.8);
		Jeu.setDividerSize(0);
		
		// Verouillage des dimensions de la fen�tre
		this.fenetre.setResizable(true);


		this.fenetre.setContentPane(Jeu);
		this.fenetre.setVisible(true);

		

	}

	public void run() 
	{
		this.initialiserLInterfaceGraphique();
	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}

	public void actionPerformed(ActionEvent e) {
		
			/*BCase bcase = (BCase) e.getSource();
			System.out.println("Ligne : " + bcase.obtenirLigne()
					+ " Colonne : " + bcase.obtenirColonne());
			if (bcase.obtenirType() != null) {

			} else {
				bcase.poserTour(typeTour);
			}
			System.out.println("Type : " + bcase.obtenirType());*/
		
	}
}
