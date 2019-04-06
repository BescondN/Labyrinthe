package application;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Algo {
	
	public <E> Step<E> Largeur(Explorable<E> exp)
	{
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
						return etape2;
					}
				}
				
			}
		}
		return null;
	}
}
