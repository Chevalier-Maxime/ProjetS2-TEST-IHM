package fr.iutval.projetS2.java.ihm;

public class Vague3 extends Vague
{
	
	
	public Vague3()
	{
		tabEnnemi= new Ennemi[16];
		for(int indice=0; indice<10; indice++)
		{
			this.tabEnnemi[indice]=new EnnemiGEA();
		}
		for(int indice=10; indice<15; indice++)
		{
			this.tabEnnemi[indice]=new EnnemiTC();
		}
		this.tabEnnemi[15]=new EnnemiBoss1();
	}

}
