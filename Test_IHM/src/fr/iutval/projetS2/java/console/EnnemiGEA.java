package fr.iutval.projetS2.java.console;

public class EnnemiGEA extends Ennemi
{	
	public final static Case CASE_PAR_DEFAUT_DEPART=new Case(14,0);
	
	public EnnemiGEA()
	{
		super("gea", 5, 1, CASE_PAR_DEFAUT_DEPART,10);
		
	}
	


}
