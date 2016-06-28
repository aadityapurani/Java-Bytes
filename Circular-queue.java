/*Programme by Aaditya Purani Tested on backbox */
import java.util.Scanner;

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
  
  public Scanner scan = new Scanner(System.in);
  
	Node front;											//OBJECT START TO POINT HEAD NODE
  Node rear;											//OBJECT END TO POINT END NODE
	int size,val,pos,length ;									//VARIABLE SIZE TO STORE THE SIZE OF LIST, VAL TO TAKE INTERGER VALUE FROM USER, POS TO TAKE INTERGER POSITION FROM USER
 
    Linkedlist()										//REGULAR CONSTRUCTOR
    {
        front = null;									//INITIALISING START TO NULL
        rear = null;										//INITIALISING END TO NULL
        size = 0;										//INITIALISING SIZE TO ZERO
    }
	
	void length()
	{
		System.out.print("Enter length of the circular queue:");
		length = scan.nextInt();
	}
	
    void enqueue()								//FUNCTION TO INSERT AT BEGINING
	{	if(length != size)	
		{	System.out.print("Enter integer element to insert:");
			val= scan.nextInt();
			
			Node temp = new Node(val, null, null);    
			size++ ; 
			
			if(front == null) 
			{
				front = temp;
				rear = front;
			}
			else 
			{
				front.setNext(temp);
				front.setPre(null);
				temp.setPre(front);
				temp.setNext(null);
				front = temp;
			}
			System.out.print("Number inserted....\n");
			if(length == size)
			{	front.setNext(rear);
				rear.setPre(front);
			}
		}
		else
			System.out.print("Cannot add more elements....");
    }

    void dequeue()									//FUNCTION TO DELETE AT END
    {   if(length != size && size != 1)
		{	rear = rear.getNext();
			rear.setPre(null);
			size --;
			System.out.print("\nNumber deleted....\n");
		}
		else if(length == size)
		{	front.setNext(null);
			rear.setPre(null);
			rear = rear.getNext();
			rear.setPre(null);
			size--;
			System.out.print("\nNumber deleted....\n");
		}
		else if(size == 1)
		{	
			front = null;
			rear = null;
			size = 0;
			System.out.print("\nNumber deleted....\n");
		}
		else
			System.out.print("\nEmpty....\n");
	}

    void peak()
	{	System.out.print("\nTop element of circular queue:"+front.getData());	}
	
	void display()										//FUNCTION FOR DISPLAYING THE LIST
    {
        System.out.print("\nCircular Queue = ");
        if (size == 0) 
			System.out.print("empty\n");
        
		if(length != size && size>0)
		{	Node temp = rear;
			while (temp.getNext() != null)
				{
					System.out.print(temp.getData()+" <-> ");
					temp = temp.getNext();
				}
				System.out.print(temp.getData()+ "\n");
		}
		else
		{	Node temp = rear;
			int s = length;
			while(s != 0)
			{	System.out.print(temp.getData()+" <-> ");
				temp = temp.getNext();
				s--;
			}
		}
    }
}

class Circular_queue										//CLASS LIST MAIN BLOCK
{    
    public static void main(String[] args)
    {             
        Linkedlist list = new Linkedlist(); 			//Creating object of class linkedList
        
		Scanner scan = new Scanner(System.in);
		
		int ch;
		
		list.length();
        
        do												//DO WHILE LOOP
        {
			System.out.println("\n\t\tMenu");			//MENU
			System.out.println("\n\t1.Enqueue");
			System.out.println("\n\t2.Dequeue");
			System.out.println("\n\t3.Peak");
			System.out.println("\n\t4.Display");
			System.out.println("\n\t5.Exit");
			System.out.print("\n\tEnter your choice:");
			ch=scan.nextInt();
			switch(ch)
			{
				case 1:		//CALLING INSERT AT BEGINING FUNCTION
					list.enqueue();                     
					break;
				
				case 2 : 	//CALLING INSERT AT END FUNCTION
					list.dequeue();
					break;                         
            	case 3 : 	//CALLING INSERT AT POSITION FUNCTION
					list.peak();
					break;                         
            
				case 4 : 	//CALLING DELETE AT BEGINING FUNCTION
					list.display();
					break;                         

			}
        } while (ch!=11);	//CONDITION UNTILL OPTION 10 i.e EXIT OPTION IS NOT SELECTED
    }
}
