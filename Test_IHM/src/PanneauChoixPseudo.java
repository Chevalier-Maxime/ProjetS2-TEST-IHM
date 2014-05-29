import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PanneauChoixPseudo extends JPanel
{
	private JLabel Pseudo;
	private JTextField pseudochoix;
	
	public PanneauChoixPseudo()
	{
		pseudochoix = new JTextField();
		//pseudochoix.setFont(police);
		pseudochoix.setPreferredSize(new Dimension(100, 30));
		this.Pseudo = new JLabel("Pseudo");
	
		this.add(Pseudo);
		this.add(pseudochoix);
	}
	
	public JTextField obtenirPseudo()
	{
		return this.pseudochoix;
	}
}
