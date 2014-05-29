import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class BarreDeMenuTowerDefence extends JMenuBar implements ActionListener
{	
	private JMenu towerIUT;
	private JMenuItem JMIscores;
	private JMenuItem JMIregles;
	private JMenuItem JMIoptions;
	private JMenuItem JMIquitter;
	private  MenuIHM partie;
	private JFrame fenetre;
	
	public BarreDeMenuTowerDefence(MenuIHM part, JFrame fen)
	{
		this.partie=part;
		towerIUT = new JMenu("Tower IUT");
	
		this.JMIscores = new JMenuItem("Scores");
		this.JMIscores.addActionListener(this);
		towerIUT.add(this.JMIscores);
	
		this.JMIregles = new JMenuItem("Regles");
		this.JMIregles.addActionListener(this);
		towerIUT.add(this.JMIregles);
	
		this.JMIoptions = new JMenuItem("Options");
		this.JMIoptions.addActionListener(this);
		towerIUT.add(this.JMIoptions);
	
		this.JMIquitter = new JMenuItem("Quitter");
		this.JMIquitter.addActionListener(this);
		towerIUT.add(this.JMIquitter);
		
		this.add(towerIUT);
		
		Font police = new Font("Arial", Font.BOLD, 16);
		towerIUT.setFont(police);
		JMIscores.setFont(police);
		JMIregles.setFont(police);
		JMIoptions.setFont(police);
		JMIquitter.setFont(police);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == JMIoptions) 
		{
			partie.options.afficheOptionIHM();

		} 
		else if (e.getSource() == JMIquitter) 
		{
			fenetre.dispose();
		} 
		else if (e.getSource() == JMIscores) 
		{
			partie.scores.afficherScoreIHM();
		} 
		else if (e.getSource() == JMIregles) 
		{
			partie.regles.afficherReglesIHM();
		}
	}
}
