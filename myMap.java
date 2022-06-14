package Task_5;


class Node<K,V>
{
	K key;
	V value;
	Node<K,V> next;
	Node(K Key,V Value)
	{
		this.key=Key;
		this.value=Value;
		this.next=null;
	}
}
public class myMap<K,V> {
	 private  int MAX_CAPACITY=16;
	private Node<K,V> values[];//Linked List

	myMap()
     {
    	 values=new Node[MAX_CAPACITY];
     }
     
     
     public int getIndex(K Key)
     {
    	 int hashCode=Key.hashCode();
    	 
    	 int index=(hashCode & 0x7FFFFFFF)%(MAX_CAPACITY);
		 return index;
    	 
     }
     public Node<K,V>[] getValues() {
 		return values;
 	}
  
	public void put(K Key,V Value)
     {
    	 int index=getIndex(Key);
    	 Node<K,V> node=values[index];
    	  
    	 if(node==null)
    	 {
    		 node=new Node<K, V>(Key,Value);
    		 values[index]=node;
    	 }else
    	 {
    		 Node<K,V> tempnode=node;
        	 while(tempnode!=null)
        	 {
        		 K tempkey=node.key;
        		 if(Key.equals(tempkey))
        		 { 
        			 tempnode.value=Value;
        			 return;
        		 }
        		 tempnode=tempnode.next;
        	 }
        	 Node<K,V> newnode=new Node<K, V>(Key,Value);
        	 node.next=newnode;
    	 }  	 
     }
     public V get(K Key)
     {
    	 int index=getIndex(Key);
    	 Node<K,V> node=values[index];
    	 Node<K,V> tempnode=node;
    		 while(tempnode!=null)
    		 {
    			 if(tempnode.key.equals(Key))
    			 {
    				 return  tempnode.value;
    				
    		    }
    			 tempnode=tempnode.next;
    		 }
			return null;
     }
     public boolean containsKey(K Key)
     {
    	 int index=getIndex(Key);
    	 Node<K,V> node=values[index];
    
    	 while(node!=null)
    	  {
    		 if(node.key.equals(Key))
    		 {
    			 return true;
    		 } 
    		 node=node.next;
    	   }
    	 
    	 return false;
     }
     public boolean containsValue(V value)
     {
    	 
    	for(int i=0;i<MAX_CAPACITY;i++)
    	 {
    	   Node<K,V> node=values[i];
    	
	    	 while(node!=null)
	    	   {
	    		 if(node.value==value)
	    		 {return true;} 
	    		 node=node.next;
	    	   }
    	 }
    	 return false;
     }
     public boolean remove(K Key)
     {
    	 int index=getIndex(Key);
    	 Node<K,V> node=values[index];
    	 if(node==null)
    	 {
    		 return false;
    	 }else
    	 {
    		 while(node!=null)
    		 {
    			 if(node.key.equals(Key))
        		 {
    				 node.value=null;
    				 node=node.next;
    				 return true;
            	 }

    		 }
    	 }
		return false;
    	 
     }
     
}
     
     
