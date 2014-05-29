import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;


public class FenetreChoixDuNiveauEtPseudo 
{
	
	private PanneauChoixNiveau niveau;
	private PanneauChoixPseudo pseudo;
	private PanneauChoixValidation validation;
	
	private JFrame fentrePseudo;
	public FenetreChoixDuNiveauEtPseudo()
	{
		this.fentrePseudo=new JFrame();
		this.niveau= new PanneauChoixNiveau();
		this.pseudo= new PanneauChoixPseudo();
		this.validation= new PanneauChoixValidation(this.niveau, this.pseudo, fentrePseudo);
		
		
		fentrePseudo.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		fentrePseudo.setSize(600, 500);
		fentrePseudo.setResizable(true);
		fentrePseudo.setLocationRelativeTo(null);
		fentrePseudo.setLayout(new BorderLayout());
		
		fentrePseudo.add(this.niveau, BorderLayout.NORTH);
		fentrePseudo.add(this.pseudo, BorderLayout.CENTER);
		fentrePseudo.add(this.validation, BorderLayout.SOUTH);
		
		this.fentrePseudo.setVisible(true);
 
	}
	
	
}
