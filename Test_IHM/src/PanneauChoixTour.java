import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Jeu_Console.EnumTour;


public class PanneauChoixTour extends JPanel implements ActionListener
{
	private JButton Tower1;
	private JButton Tower2;
	private JButton Tower3;
	private MenuIHM partie;
	private EnumTour typeTour= EnumTour.petiteTour; 
	
	public PanneauChoixTour( MenuIHM partie)
	{
		this.Tower1 = new JButton(new ImageIcon("docs/Tower1.png"));
		this.Tower1.addActionListener(this);
		this.Tower2 = new JButton(new ImageIcon("docs/Tower2.png"));
		this.Tower2.addActionListener(this);
		this.Tower3 = new JButton(new ImageIcon("docs/Tower3.png"));
		this.Tower3.addActionListener(this);
		this.setBackground(Color.GRAY);
		this.add(this.Tower1);
		this.add(this.Tower2);
		this.add(this.Tower3);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == Tower1) 
		{
			this.typeTour = EnumTour.petiteTour;
		} 
		else if (e.getSource() == Tower2) 
		{
			this.typeTour = EnumTour.moyenneTour;
		} 
		else if (e.getSource() == Tower3) 
		{
			this.typeTour = EnumTour.grosseTour;
		}
	}
}
