/*This is programme of doubly linked list by Aaditya Purani. Tested on Linux */

import java.util.Scanner;                                                           // IMPORTING JAVA FILES

class Node												//CLASS NODE 
{
  public int data;											//VARIABLE DATA TO TAKE INTEGER VALUE TO STORE
	Node next;											//OBJECT WHICH LINK THE NEXT MODE
	Node pre;											//OBJECT WHICH LINK THE PREVIOUS NODE
	
	Node()												//REGULAR CONSTRUCTOR
	{
		data=0;											//INITIALISING DATA TO ZERO
		next=null;										//INITIALISING LINK TO NULL
		pre=null;										//INITIALISING LINK TO NULL
	}
	
	Node(int d,Node n,Node p)							//PARAMETERISED CONSTRUCTOR
    {
    data = d;										//INITIALISING DATA TO 'd'
		next = n;										//INITIALISING LINK TO 'n'
		pre = p;										//INITIALISING LINK TO 'P'
    }    
 
    void setNext(Node n)								//FUNCTION TO SET NEXT LINK
    {	next = n;	}    

	void setPre(Node p)									//FUNCTION TO SET PREVIOUS LINK
    {	pre = p;	}    
 
    void setData(int d)									//FUNCTION TO SET DATA
    {	data = d;	}    
 
    Node getNext()										//FUNCTION TO GET NEXT LINK
    {	return next;	}    
 
	Node getPre()										//FUNCTION TO GET PREVIOUS LINK
    {	return pre;	}    
 
    int getData()										//FUNCTION TO GET DATA
    {	return data;	}
}

class Linkedlist
{
  
  public
	
	Scanner scan = new Scanner(System.in);
  
	Node start;											//OBJECT START TO POINT HEAD NODE
    Node end ;											//OBJECT END TO POINT END NODE
	int size,val,pos ;									//VARIABLE SIZE TO STORE THE SIZE OF LIST, VAL TO TAKE INTERGER VALUE FROM USER, POS TO TAKE INTERGER POSITION FROM USER
 
    Linkedlist()										//REGULAR CONSTRUCTOR
    {
        start = null;									//INITIALISING START TO NULL
        end = null;										//INITIALISING END TO NULL
        size = 0;										//INITIALISING SIZE TO ZERO
    }

    void insertAtStart()								//FUNCTION TO INSERT AT BEGINING
    {	System.out.print("Enter integer element to insert:");
		val= scan.nextInt();
		
        Node temp = new Node(val, null, null);    
        size++ ; 
		
        if(start == null) 
        {
            start = temp;
            end = start;
		}
        else 
        {
            temp.setNext(start);
			temp.setPre(null);
			start.setPre(temp);
			start = temp;
        }
		System.out.print("Number inserted....\n");
    }

    void insertAtEnd()									//FUNCTION TO INSERT AT END
    {	System.out.print("Enter integer element to insert:");
		val= scan.nextInt();
		
        Node temp = new Node(val,null, null);
        size++ ;
		
        if(start == null) 
        {
            start = temp;
            end = start;
			start.setPre(null);
        }
        else 
        {
            temp.setPre(end);
			temp.setNext(null);
			end.setNext(temp);
            end = temp;
        }
		
		System.out.print("Number inserted....\n");
    }
	
	void insertAtPosition()								//FUNCTION TO INSERT AT POSITION
    {	Linkedlist list1 = new Linkedlist();
	
		System.out.print("Enter integer position to be insert at:");
		pos= scan.nextInt();
		
        if(pos == 1)									//IF SELECTING POSITION ONE
			list1.insertAtStart();
		
		if(pos == size)									//IF SELECTING POSITION LAST
			list1.insertAtEnd();
		
		if(pos != 1 || pos !=size)						//IF SELECTING POSITION BETWEEN ONE AND LAST
		{	System.out.print("Enter integer element to insert:");
			val= scan.nextInt();
			Node temp = new Node(val, null,null);
			Node temp1 = start;
			pos--;
			for(int i = 1; i < size; i++) 
			{
				if (i == pos) 
				{
					Node temp2 = temp1.getNext() ;
					temp1.setNext(temp);
					temp.setPre(temp1);
					temp.setNext(temp2);
					temp2.setPre(temp);
					break;
				}
				temp1 = temp1.getNext();
			}
			size++ ;
			System.out.print("\nNumber inserted....\n");
		}
    }
	
    void deleteAtFirst()								//FUNCTION TO DELETE AT BEGINING
    {        
        start = start.getNext();
		start.setPre(null);
        size--; 
        System.out.print("\nNumber deleted....\n");
	}

    void deleteAtEnd()									//FUNCTION TO DELETE AT END
    {        
        Node s = start;
        Node t = start;
        while (s != end)
        {
            t = s;
            s = s.getNext();
        }
        end = t;
        end.setNext(null);
        size --;
        System.out.print("\nNumber deleted....\n");
	}

	void deleteAtPosition()								//FUNCTION TO DELETE AT POSITION
	{   System.out.print("Enter integer position to be delete at:");
		pos= scan.nextInt();
		
		if (pos == 1) 									//DELETING FROM POSITION ONE
		{	if (size == 1)
			{	start = null;
				end = null;
				size = 0;
			}
			start = start.getNext();
			start.setPre(null);
			size--; 
		}

        if (pos == size)								//DELETING FROM POSITION LAST
		{	end = end.getPre();
            end.setNext(null);
            size-- ;
        }
		
		Node temp = start;
        pos--;
        for (int i = 1; i < size - 1; i++) 
        {
            if (i == pos) 
            {
                Node temp1 = temp.getNext();
                temp1 = temp1.getNext();
                temp.setNext(temp1);
				temp1.setPre(temp);
                break;
            }
            temp = temp.getNext();
        }
        size-- ;
		System.out.print("\nNumber deleted....\n");
    }
    
    void display()										//FUNCTION FOR DISPLAYING THE LIST
    {
        System.out.print("\nDoubly Linked List = ");
        if (size == 0) 
			System.out.print("empty\n");
        
		if (start.getNext() == null) 
            System.out.println(start.getData()+" ");
        
		Node temp = start;
        System.out.print(start.getData()+" <-> ");
        temp = start.getNext();
        while (temp.getNext() != null)
        {
            System.out.print(temp.getData()+" <-> ");
            temp = temp.getNext();
        }
        System.out.print(temp.getData()+ "\n");
    }
	
	void search()										//FUNCTION TO SEARCH BY VALUE FROM LIST
	{	int i=1;
		System.out.print("Enter integer element to be search:");
		val= scan.nextInt();
		
		Node s = start;
        while (s != end)
        {	if(s.getData()==val)
            {
				System.out.print("Searched number is on "+i);
				break;
			}
            s = s.getNext();
			i++;
        }
		if(s.getData()==val)
        	System.out.print("Searched number is on "+i++);
	}
	
	void sort()											//FUNCTION TO SORT THE LIST IN INCEASING ORDER(NOT WORKING)
	{	Node temp = start;
		Node ptr = start;
		Node npt = new Node();
		int s = size; ;
		
		for(int i=1;i<size;i++)
		{	for(int j=1;j<s;j++)
			{	ptr=ptr.getPre();
				int c = temp.getData();
				int d = ptr.getData();
				if(c < d)
				{	npt.data = temp.data;
					temp.data = ptr.data;
					ptr.data = npt.data;
				}
			}
			s--;
			temp=temp.getPre();
			ptr=temp;
		}
	}
	
	void reverse()										//FUNCTION FOR REVERSE THE LIST
	{	Node temp = null;
		Node current = start;
		Node ptr = null;
				
		while(current.getNext() != null)				//WHILE LOOP EXECUTES TILL SIZE-1
		{
			temp = new Node(current.getData(),null,null);	//FOLLOWING INSERTION AT END BUYT WITH REVERSED LINK
			
			if(ptr == null) 
			{	ptr = temp;
				ptr.setNext(null);
			}	
			else 
			{
				temp.setNext(ptr);
				temp.setPre(null);
				ptr.setPre(temp);
				ptr = temp;
			}
			current=current.getNext();
		}
		temp = new Node(current.getData(),null,null);	//FOR THE LAST LINK
		
		temp.setNext(ptr);
		temp.setPre(null);
		ptr.setPre(temp);
		ptr = temp;
		
		start = ptr;									//CHANGING THE START LINK
		System.out.print("List Reversed....\n");
    }
}

class Doublylist										//CLASS LIST MAIN BLOCK
{    
    public static void main(String[] args)
    {             
        Linkedlist list = new Linkedlist(); 			//Creating object of class linkedList
        
		Scanner scan = new Scanner(System.in);
		
		int ch;
        
        do												//DO WHILE LOOP
        {
			System.out.println("\n\t\tMenu");			//MENU
			System.out.println("\n\t1.Insert At First");
			System.out.println("\n\t2.Insert At Last");
			System.out.println("\n\t3.Insert At Position");
			System.out.println("\n\t4.Delete At First");
			System.out.println("\n\t5.Delete At Last");
			System.out.println("\n\t6.Delete At Position");
			System.out.println("\n\t7.Display");
			System.out.println("\n\t8.Search");
			System.out.println("\n\t9.Sorting");
			System.out.println("\n\t10.Reverse The List");
			System.out.println("\n\t11.Exit");
			System.out.print("\n\tEnter your choice:");
			ch=scan.nextInt();
			switch(ch)
			{
				case 1:		//CALLING INSERT AT BEGINING FUNCTION
					list.insertAtStart( );                     
					break;
				
				case 2 : 	//CALLING INSERT AT END FUNCTION
					list.insertAtEnd();
					break;                         
            	case 3 : 	//CALLING INSERT AT POSITION FUNCTION
					list.insertAtPosition();
					break;                         
            
				case 4 : 	//CALLING DELETE AT BEGINING FUNCTION
					list.deleteAtFirst();
					break;                         

				case 5 : 	//CALLING DELETE AT END FUNCTION
					list.deleteAtEnd();
					break;                         
    
				case 6 : 	//CALLING DELETE AT POSITION FUNCTION
					list.deleteAtPosition();
					break;                         
            
				case 7 : 	//CALLING DISPLAYING FUNCTION
					list.display();
					break;                         
				
				case 8 : 	//CALLING SEARCHING FUNCTION
					list.search();
					break;                         

				case 9 : 	//CALLING SORT FUNCTION
					list.sort();
					break;
				
				case 10:	//CALLING REVERSE FUNCTION
					list.reverse();
					break;
            }
        } while (ch!=11);	//CONDITION UNTILL OPTION 10 i.e EXIT OPTION IS NOT SELECTED
    }
}
