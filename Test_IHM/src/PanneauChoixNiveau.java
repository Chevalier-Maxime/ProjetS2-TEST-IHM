import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class PanneauChoixNiveau extends JPanel
{
	
	
	private JRadioButton niv1Button;
	private JRadioButton niv2Button;
	private JRadioButton niv3Button;
	
	
	public PanneauChoixNiveau()
	{
		//Niveau 1
		niv1Button = new JRadioButton("Niveau 1");
		niv1Button.setMnemonic(KeyEvent.VK_B);
		//niv1Button.setFont(police);
		niv1Button.setActionCommand("Niveau 1");
		niv1Button.setSelected(true);
		//niv1Button.addActionListener(this);
		this.add(niv1Button);
		
		//Niveau2
		niv2Button = new JRadioButton("Niveau 2");
		niv2Button.setMnemonic(KeyEvent.VK_C);
		//niv2Button.setFont(police);
		niv2Button.setActionCommand("Niveau 2");
		//niv2Button.addActionListener(this);
		this.add(niv2Button);
		
		//Niveau3
		niv3Button = new JRadioButton("Niveau 3");
		niv3Button.setMnemonic(KeyEvent.VK_D);
		//niv3Button.setFont(police);
		niv3Button.setActionCommand("Niveau 3");
		//niv3Button.addActionListener(this);
		this.add(niv3Button);
	
		
		ButtonGroup group = new ButtonGroup();
		group.add(niv1Button);
		group.add(niv2Button);
		group.add(niv3Button);

	}
	
	public JRadioButton obtenirBouton1()
	{
		return this.niv1Button;
	}
	
	public JRadioButton obtenirBouton2()
	{
		return this.niv2Button;
	}
	public JRadioButton obtenirBouton3()
	{
		return this.niv3Button;
	}
}
