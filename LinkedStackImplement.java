/* Coded by Aaditya Purani */
package Stack;
 
import java.util.Scanner;
import java.lang.*;
import java.*;
 

class Node
{
    protected int data;
    protected Node link;
	
    public Node()
    {
        link = null;
        data = 0;
    }    
    public Node(int d,Node n)
    {
        data = d;
        link = n;
    }    
   
    public void setLink(Node n)
    {
        link = n;
    }    
 
    public void setData(int d)
    {
        data = d;
    }    
    
    public Node getLink()
    {
        return link;
    }    
    
    public int getData()
    {
        return data;
    }
}
 

class linkedList
{
    protected Node start;
    protected Node end ;
    public int size ;
 
    
    public linkedList()
    {
        start = null;
        end = null;
        size = 0;
    }
  
    public int getSize()
    {
        return size;
    }   
   
   
    public void insertAtEnd(int val)
    {
        Node nptr = new Node(val,null);    
        size++ ;    
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        else 
        {
            end.setLink(nptr);
            end = nptr;
        }
    }
   
    
	
		public void deleteLast()
	{ 
		
            Node s = start;
            Node t = start;
            while (s != end)
            {
                t = s;
                s = s.getLink();
            }
            end = t;
            end.setLink(null);
            size --;
            return;
	}
	
		public void insertAtPos(int val , int pos)
	    {
	        Node nptr = new Node(val, null);                
	        Node ptr = start;
	        pos = pos - 1 ;
	        for (int i = 1; i < size; i++) 
	        {
	            if (i == pos) 
	            {
	                Node tmp = ptr.getLink() ;
	                ptr.setLink(nptr);
	                nptr.setLink(tmp);
	                break;
	            }
	            ptr = ptr.getLink();
	        }
	        size++ ;
	    }
    
    public void display()
    {
        System.out.println("\nSingly Linked List = ");
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }    
        if (start.getLink() == null) 
        {
            System.out.println(start.getData() );
            return;
        }
        Node ptr = start;
        System.out.println(start.getData());
        ptr = start.getLink();
        while (ptr.getLink() != null)
        {
            System.out.println(ptr.getData());
            ptr = ptr.getLink();
        }
        System.out.println(ptr.getData()+ "\n");
    }
	
    
    public void peak()
	{
            System.out.println(start.getData() );
            return;    
	}
	
    public void search(int pos)
	{
		Node ptr = start;
		if(pos==1)
		{
			System.out.print(ptr.getData()+ "\n");
		}
		else
		{
			pos=pos-1;
			for (int i =1; i<size;i++) 
			{
				if (i == pos) 
				{
					Node tmp = ptr.getLink();
					
					System.out.print(tmp.getData()+ "\n");
					
				}
				ptr = ptr.getLink();
			}
		}	
	}
}
 

public class LinkedStackImplement
{    
    public static void main(String[] args)
    {             
        Scanner scan = new Scanner(System.in);
        linkedList list = new linkedList(); 
        System.out.println("Singly Linked List Test\n");          
        char ch;
		int choice;
        do
        {
            System.out.println("\nSingly Linked List Operations\n");
            System.out.println("1. push");
			System.out.println("2. pop");
			System.out.println("3. change");
			System.out.println("4. peak");
			System.out.println("5. Search");
			System.out.println("6. Display");
			System.out.println("0. Exit");
			
			choice = scan.nextInt();            
            switch (choice)
            {                              
            case 1: 
                System.out.println("Enter integer element to insert");
                list.insertAtEnd( scan.nextInt() );  				
				list.display();	
                break;                         
            
            case 2: 
                list.deleteLast();
				list.display();
				break;
				
            case 3: 
                System.out.println("Enter integer element to insert");
                int num = scan.nextInt() ;
                System.out.println("Enter position");
                int pos = scan.nextInt() ;
                if (pos <= 1 || pos > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.insertAtPos(num, pos);
				    list.display();
                break;
                
            case 4:
				list.peak();
				break;
			
            case 5:
				System.out.println("Enter position you want to Search");
				int search = scan.nextInt() ;
				list.search(search);
				break;
				
            case 6:	
				list.display();
				break;
			
			case 0:
			  break;
			  
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }    
        } while (choice!=0);               
    }
}
