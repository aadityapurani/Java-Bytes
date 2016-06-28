/*Programme by Aaditya Purani */
import java.util.Scanner;

class Node												//CLASS NODE 
{
   public
	
	int data;											//VARIABLE DATA TO TAKE INTEGER VALUE TO STORE
	Node link;											//OBJECT WHICH  LINK THE NEXT MODE
	
	Node()												//REGULAR CONSTRUCTOR
	{
		data=0;											//INITIALISING DATA TO ZERO
		link=null;										//INITIALISING LINK TO NULL
	}
	
	Node(int d,Node n)									//PARAMETERISED CONSTRUCTOR
    {
        data = d;										//INITIALISING DATA TO 'd'
		link = n;										//INITIALISING LINK TO 'n'
    }    
 
    void setLink(Node n)								//FUNCTION TO SET LINK
    {	link = n;	}    
 
    void setData(int d)									//FUNCTION TO SET DATA
    {	data = d;	}    
 
    Node getLink()										//FUNCTION TO GET LINK
    {	return link;	}    
 
    int getData()										//FUNCTION TO GET DATA
    {	return data;	}
}

class Linkedlist
{
  
  	public
  
	Scanner scan = new Scanner(System.in);
  
	Node start;											//OBJECT START TO POINT HEAD NODE
  	Node end ;											//OBJECT END TO POINT END NODE
	int size,val,pos ;									//VARIABLE SIZE TO STORE THE SIZE OF LIST, VAL TO TAKE INTERGER VALUE 													  FROM USER, POS TO TAKE INTERGER POSITION FROM USER
 
    	Linkedlist()										//REGULAR CONSTRUCTOR
    	{
        	start = null;									//INITIALISING START TO NULL
        	end = null;										//INITIALISING END TO NULL
        	size = 0;										//INITIALISING SIZE TO ZERO
    	}

    	void enque()								//FUNCTION TO ENQUE
    	{	
		System.out.print("Enter integer element to insert:");
		val= scan.nextInt();
		
        	Node temp = new Node(val,null);    
       		size++ ;
		
        	if(start == null) 
        	{
            		start = temp;
            		end = start;
        	}
        	else 
        	{
            		end.setLink(temp);
            		end = temp;
        	}
		System.out.print("Number inserted....\n");
    	}

 
    	void deque()									//FUNCTION TO DEQUE
    	{        
        	start = start.getLink();
        	size--; 
        	System.out.print("\nNumber deleted....\n");
	}

	void peak()
	{
		System.out.print("the number top of que is : " + start.getData() +"\n");
	}

    	void display()										//FUNCTION FOR DISPLAYING THE LIST
    	{
        	int s=size;
        	System.out.print("\nStack = ");
        	if (size == 0) 
			System.out.print("empty\n");
        	else		
        	{	
			Node temp = start;
			while ( s!=0 )
			{
				System.out.print(temp.getData()+" ");
				temp = temp.getLink();
				s--;
			}
		}
    	}	
}
 
class Que_singly												//CLASS LIST MAIN BLOCK
{    
    	public static void main(String[] args)
    	{             
        	Linkedlist list = new Linkedlist(); 			//Creating object of class linkedList
        
		Scanner scan = new Scanner(System.in);
		
		int ch;
        
        do												//DO WHILE LOOP
        {
			System.out.println("\n\t\tMenu");			//MENU
			System.out.println("\n\t1.Enque");
			System.out.println("\n\t2.Deque");
			System.out.println("\n\t3.Peak");
			System.out.println("\n\t4.Display");
			System.out.println("\n\t5.Exit");
			System.out.print("\n\tEnter your choice:");
			ch=scan.nextInt();
			switch(ch)
			{
				case 1:		
					list.enque( );                     
					break;
				
				case 2 : 	
					list.deque();
					break;                         
            			case 3 : 	
					list.peak();
					break;                         
            
				case 4 : 	
					list.display();
					break;  
            }
        } while (ch<=4);	//CONDITION UNTILL OPTION 5 i.e EXIT OPTION IS NOT SELECTED
    }
}
//END OF PROGRAM
