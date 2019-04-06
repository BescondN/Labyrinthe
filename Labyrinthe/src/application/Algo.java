package application;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Algo<E> {
	
	
	HashMap<E,Boolean> marque = new HashMap<E, Boolean>();
	
	public Step<E> Largeur(Explorable<E> exp)
	{
		
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
						marque.clear();
						return etape2;
					}
				}
				
			}
		}
		return null;
	}
	public Step<E> Profondeur(Explorable<E> exp)
	{
        
        Stack<Step<E>> stack = new Stack<Step<E>>();
        Step<E> etape = exp.getDepart();
        marque.put(etape.Get_Own_Box(), true);
        Step<E> etape2;
        stack.add(etape);
        
        List<Step<E>> casesVoisines;		

        while(!stack.isEmpty()){
        	etape = stack.pop();
        	casesVoisines = exp.getCasesVoisines(etape);
        	for(int i=0;i<casesVoisines.size();i++)
			{
        		etape2 = casesVoisines.get(i);
        		if(!marque.containsKey(etape2.Get_Own_Box()))
				{
					marque.put(etape2.Get_Own_Box(), true);
					
					stack.add(etape2);
					etape2.Set_Previous_Box(etape);
					if(exp.estArrivee(etape2))
					{
						marque.clear();
						return etape2;
					}
				}
			}
        }
        return null;
    }
}
