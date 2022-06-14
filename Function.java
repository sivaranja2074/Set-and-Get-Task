package Task_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Function<K,V> {

	myMap<K,V> map;
	
	Function()
	{
		map=new myMap<>();
		
	}
	public void set(String comment)	
	{
	  String[] arr = comment.split(" ");
	   K Key=(K) arr[1];
	   V Value=(V) arr[2];
		map.put(Key, Value);
		 
	}
	public V get(K Key)
	{  

		V value= map.get(Key);
		
		return value;
	}
	
	public int count(String comment)
	{ 
		String[] arr = comment.split(" ");
		V value=(V)arr[1];
		int count=0;
		for(int i=0;i<map.getValues().length;i++)
		{    Node tempnode=map.getValues()[i];
			if(tempnode!=null)
			{
				while(tempnode!=null)
				{     
					
					
					if(tempnode.value!=null && tempnode.value.equals(value))
					{
						count++;	
					}
						
					tempnode=tempnode.next;
				}
				
			}
			
			
		}
		return count;
	}

	public boolean unset(K Key)
	{
		if(!map.containsKey(Key))
		{
			return false ;
		}
	
		map.remove(Key);
		return true;	
	}
	public String update(String comment)
	{
		String[] arr = comment.split(" ");
		K Key=(K) arr[1];
		V Value=(V) arr[2];
		if(map.containsKey(Key))
		{	
			map.put(Key, Value);	
			return "Update";
		}
		 return "No variable named '"+Key+"'";	
			
	}
	 public String printKey()
	    {
		 for(int i=0;i<map.getValues().length;i++)
			{    Node<K,V> tempnode=map.getValues()[i];
			  
				if(tempnode!=null)
				{
					while(tempnode!=null)
					{

			            System.out.println("key: " + tempnode.key);
						tempnode=tempnode.next;
					}
				}	
			}
		return null;
		
   }
	 public String printValues()
	    {
		 for(int i=0;i<map.getValues().length;i++)
			{    Node<K,V> tempnode=map.getValues()[i];
			  
				if(tempnode!=null)
				{
					while(tempnode!=null)
					{

			            System.out.println("Value: " + tempnode.value);
						tempnode=tempnode.next;
					}
				}	
			}
		return null;
		
}

     public void commit(Function newmap)
     {
    	 for(int i=0;i<newmap.map.getValues().length;i++)
 		{    Node<K,V> tempnode=newmap.map.getValues()[i];
 			
 				while(tempnode!=null)
 				{
 					map.put(tempnode.key, tempnode.value);
 					tempnode=tempnode.next;
 				}
 		}
 				
 		}
    	  public void uncommit(Function newmap)
    	     {
    	    	 for(int i=0;i<newmap.map.getValues().length;i++)
    	 		{    Node<K,V> tempnode=newmap.map.getValues()[i];
    	 			
    	 				while(tempnode!=null)
    	 				{
    	 					map.remove(tempnode.key);
    	 					tempnode=tempnode.next;
    	 				}
    	 				
    	 		}
    	    	 
    	 
//    	 for(Map.Entry<String, Integer> a:newmap.map.entrySet())
//    	 {
//    		 map.put(a.getKey(), a.getValue());
//    	 }
     }
     
      
    
  
}