/*Java program to implement singly Linked List, By Aaditya purani
Tested on Linux. So in this programme, we are telling the user to add some elements or to subtract elements
at specific/first/last position. The programme has a sorting option which sorts the unsorted elements and keep them aligned
Note: for adding at position you need to specify position in between the number of elements not more than it*/


import java.util.Scanner;   //importing scanner
import java.lang.*;         //importing libs
import java.*;
 
/*  Class Node  */
class Node                 //class node 
{
    protected int data;           //node is of two parts data
    protected Node link;          // and link
	
    public Node()              //constructor for Node
    {
        link = null;
        data = 0;
    }    
    public Node(int d,Node n)  //parameterized constructor for Node
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
 

class linkedList               //Class linked list . here our methods goes
{
    protected Node start;       //start of node
    protected Node end ;        //end of node
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
    public void insertAtStart(int val)
    {
        Node nptr = new Node(val, null);    
        size++ ;    
        if(start == null)  //if start is NULL
        {
            start = nptr;      //then it wont work
            end = start;
        }
        else 
        {
            nptr.setLink(start); //else it will keep on adding to 1st position
            start = nptr;
        }
    }
    /*  Function to insert an element at end  */
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
    /*  Function to insert an element at position  */
    public void insertAtPos(int val , int pos)
    {
        Node nptr = new Node(val, null);                
        Node ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size; i++) 
        {
            if (i == pos) 
            {
                Node tmp = ptr.getLink();
                ptr.setLink(nptr);
                nptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size++ ;
    }
    /*  Function to delete an element at position  */
    public void deleteAtPos(int pos)
    {        
        if (pos == 1) 
        {
            start = start.getLink();
            size--; 
            return ;
        }
        if (pos == size) 
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
        Node ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++) 
        {
            if (i == pos) 
            {
                Node tmp = ptr.getLink();
                tmp = tmp.getLink();
                ptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size-- ;
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
        System.out.println("\nHere is your Singly Linked List = ");  
        if (size == 0)                //if you havent added any elements then it will print empty
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
        System.out.println(ptr.getData()+ "\n");      //it will print the complete element set
    }
	
	public void search(int pos)    //method for search 
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
	
	public void sorting()   //method for sorting
	{
		Node point;
		Node temp;
		Node min;
		for(point=start;(point.getLink()).getLink()!=null;point=point.getLink())
		{
			min = point.getLink();
			for(temp=point.getLink();temp!=null;temp=temp.getLink())
			{
				if(temp.getData()<min.getData())
					min = temp;
			}
			if(min.getData()<point.getData())
			{
				int swap;
				swap = min.getData();
				min.setData(point.getData());
				point.setData(swap);
			}
		}
	}
	
	
}
 
/*  Class SinglyLinkedList  */
public class SinglyLinkedList
{    
    public static void main(String[] args)
    {             
        Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedList */
        linkedList list = new linkedList(); 
        System.out.println("\n\nSingly Linked list programme");
        System.out.println("By Aaditya Purani(1401083)\n");          
        char ch;
		//int chioce=0;
		int choice;
        /*  Perform list operations  */
        do
        {
            System.out.println("+++[[[Singly Linked List Operations are given below]]]+++\n");
            System.out.println("\nDear user, please select any one of these");
            System.out.println("1. insert at First");
            System.out.println("2. insert at End");
            System.out.println("3. insert at position");
			System.out.println("4. delete at first");
			System.out.println("5. delete at position");
			System.out.println("6. delete at Last ");
			System.out.println("7. Display");
			System.out.println("8. Search");
			System.out.println("9. Sorting");
            System.out.println("0. Exit");
            
                      
            choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                list.insertAtStart( scan.nextInt() ); 
				list.display();
                break;                          
            case 2 : 
                System.out.println("Enter integer element to insert");
                list.insertAtEnd( scan.nextInt() );  
					
				list.display();	
                break;                         
            case 3 : 
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
            case 4 : 
                list.deleteFirst(1);
				list.display();
				break;
            case 5 : 
				System.out.println("Enter position");
                int p = scan.nextInt() ;
                if (p < 1 || p > list.getSize())
                    System.out.println("Invalid position\n");
                else
                    list.deleteAtPos(p);
				
				list.display();
                break;                   
            case 6 : 
				list.deleteLast();
				list.display();
				break;
			case 7:
				/*  Display List  */ 
				list.display();
				break;
			case 8:
				System.out.println("Enter position you want to Search");
				int search = scan.nextInt() ;
				list.search(search);
				break;
			case 9:
				list.sorting();
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
