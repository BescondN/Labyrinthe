package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Algo<E> {
	
	
	private long time;      
		
	public long getTime()
	{
		return time;
	}
	
	public Step<E> Largeur(Explorable<E> exp)
	{
		long startTime = System.nanoTime();
		HashMap<E,Boolean> marque = new HashMap<E, Boolean>();

		Queue<Step<E>> queue = new LinkedList<Step<E>>();
		
		Step<E> etape = exp.getDepart();
		Step<E> etape2;
		List<Step<E>> casesVoisines;		
		queue.add(etape);
		marque.put(etape.Get_Own_Box(), true);
		
		while (!queue.isEmpty())
		{
			etape = queue.poll();
			casesVoisines = exp.getCasesVoisines(etape);
			
			
			for(int i=0;i<casesVoisines.size();i++)
			{
				etape2 = casesVoisines.get(i);
				
				if(!marque.containsKey(etape2.Get_Own_Box()))
				{
					marque.put(etape2.Get_Own_Box(), true);
					
					queue.add(etape2);
					etape2.Set_Previous_Box(etape);
					if(exp.estArrivee(etape2))
					{
						long stopTime = System.nanoTime();
						this.time = stopTime - startTime;
						return etape2;
					}
				}
				
			}
		}
		long stopTime = System.nanoTime();
		this.time = stopTime - startTime;

		return null;
	}
	public Step<E> Profondeur(Explorable<E> exp)
	{
		long startTime = System.nanoTime();
		int longueur=0;

		Step<E> arrivee = null;
		HashMap<E,Step<E>> marque = new HashMap<E, Step<E>>();
        Stack<Step<E>> stack = new Stack<Step<E>>();
        Step<E> etape = exp.getDepart();
        etape.longueur = longueur;
        marque.put(etape.Get_Own_Box(), etape);
        Step<E> etape2 = null;
        stack.add(etape);
        List<Step<E>> casesVoisines;
                
        while(!stack.isEmpty()){
        	
            longueur++;
        	etape = stack.pop();
        	if((int)etape.Get_Own_Box() == 20001)
			{
				System.out.println("");
			}
        	casesVoisines = exp.getCasesVoisines(etape);
        	for(int i=0;i<casesVoisines.size();i++)
			{
        		etape2 = casesVoisines.get(i);      
        		
        		if(!marque.containsKey(etape2.Get_Own_Box()))
				{
					marque.put(etape2.Get_Own_Box(), etape2);

					stack.push(etape2);
					etape2.longueur = longueur;
					etape2.Set_Previous_Box(etape);
					
					if(exp.estArrivee(etape2))
					{
						arrivee = etape2;
					}
				}
        		else
        		{
        			
        			etape2 = marque.get(etape2.Get_Own_Box());
        			if(etape2.longueur != 0 && etape2.longueur > etape.longueur+1)
                	{
                		etape2.longueur = etape.longueur+1;
        				etape2.Set_Previous_Box(etape);

                	}
        		}
			}
        }
        long stopTime = System.nanoTime();
		this.time = stopTime - startTime;
        return arrivee;
	}
}
