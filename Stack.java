/* Java Program to Implement Singly Linked List by Aaditya Purani*/
 
import java.util.Scanner;
import java.lang.*;
import java.*;
 
/*  Class Node  */
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
    //  Function to set link to next Node  
    public void setLink(Node n)
    {
        link = n;
    }    
    //  Function to set data to current Node  
    public void setData(int d)
    {
        data = d;
    }    
    //  Function to get link to next node  
    public Node getLink()
    {
        return link;
    }    
    //  Function to get data from current Node  
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
 
    /*  Constructor  */
    public linkedList()
    {
        start = null;
        end = null;
        size = 0;
    }
   /*  Function to get size of list  */
    public int getSize()
    {
        return size;
    }   
    /*  Function to insert an element at begining  */
   
    /*  Function to insert an element at end  */
    public void insertAtStart(int val)
    {
        Node nptr = new Node(val, null);    
        size++ ;    
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        else 
        {
            nptr.setLink(start);
            start = nptr;
        }
    }
    /*  Function to insert an element at position  */
   
    /*  Function to delete an element at position  */
   
	
		public void deleteFirst(int pos)
	{ 
			if (pos == 1) 
        {
            start = start.getLink();
            size--; 
            return ;
        }
	}
		
	
    /*  Function to display elements  */
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
	
	
}
 
/*  Class Stack  */
public class Stack
{    
    public static void main(String[] args)
    {             
        Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedList */
        linkedList list = new linkedList(); 
        System.out.println("Singly Linked List Test\n");          
        char ch;
		//int chioce=0;
		int choice;
        /*  Perform list operations  */
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
                list.insertAtStart( scan.nextInt() );  
				list.display();	
                break;                         
            case 2: 
                list.deleteFirst(1);
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
			case 6:
				
				list.display();
				break;
			case 5:
				System.out.println("Enter position you want to Search");
				int search = scan.nextInt() ;
				list.search(search);
				break;
			case 4:
				list.peak();
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
