/*
Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.
*/

public class Solution {
	public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
	    int carga = 1;
	    int index = a.size();
	    
	    while(--index >= 0)
	    {
	        
	        Integer act = a.get(index);
	        act+=carga;
	        carga = 0;
	        Integer assign;
	        if(act == 10)
	        {
	            a.set(index, 0);
	            carga = 1;
	        }
	        else
	        {
	            a.set(index, act);
	            index = -1;
	        }
	    }
	    ArrayList<Integer> resp = new ArrayList<Integer>();
	    
	    if(carga == 1)
	    {
	        resp.add(1);
	    }
	    boolean empezado = false;
	    for(int i = 0; i < a.size(); i++)
	    {
	        Integer act = a.get(i);
	        if( (!empezado && act != 0) || empezado)
	        {
	            empezado = true;
	            resp.add(act);
	        }
	    }
	    if(!empezado)
	    {
	        for(int i = 0; i < a.size(); i++)
	        {
	            resp.add(0);
	        }
        }
	    return resp;
	}
}
