package fr.iutval.projetS2.java.console;



public class EnnemiBoss1 extends Ennemi
{
	public final static Case CASE_PAR_DEFAUT_DEPART=new Case(14,0);
	
	public EnnemiBoss1()
	{
		super("boss1", 60, 2, CASE_PAR_DEFAUT_DEPART,100);
		
	}


}
