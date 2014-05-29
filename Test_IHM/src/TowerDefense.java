import java.util.Scanner;

import javax.swing.SwingUtilities;


public class TowerDefense {


	public static void main(String[] args) {

		
		final Scanner reader = new Scanner(System.in, "UTF-8");
		boolean choixInterface = false;
		String consoleOuGraph = "";
		while (!choixInterface) {
			System.out
					.println("Choix du type d'interface\n --------\n 1 Console\n 2 Graphique\n --------\n Votre choix ? ");
			consoleOuGraph = reader.nextLine();
			if ((consoleOuGraph.equalsIgnoreCase("1"))
					|| (consoleOuGraph.equalsIgnoreCase("2"))) {
				choixInterface = true;
			}
		}
		if (consoleOuGraph.equalsIgnoreCase("2")) {
			SwingUtilities.invokeLater(new MenuIHM());
		} else if (consoleOuGraph.equalsIgnoreCase("1")) {
			System.out.println("non disponible pour le moment");
		}
	}

}