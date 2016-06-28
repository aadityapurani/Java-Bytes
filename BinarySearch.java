/* Java Binary Search */
/*Coded by Aaditya Purani */

import java.util.Scanner;

class Node												//CLASS NODE 
{
   public int data;											//VARIABLE DATA TO TAKE INTEGER VALUE TO STORE
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
  
  public Scanner scan = new Scanner(System.in);
  
	Node front;											//OBJECT START TO POINT HEAD NODE
    Node rear;											//OBJECT END TO POINT END NODE
	int size,val,x ;									//VARIABLE SIZE TO STORE THE SIZE OF LIST, VAL TO TAKE INTERGER VALUE FROM USER, POS TO TAKE INTERGER POSITION FROM USER
 
    Linkedlist()										//REGULAR CONSTRUCTOR
    {
        front = null;									//INITIALISING START TO NULL
        rear = null;										//INITIALISING END TO NULL
        size = 0;										//INITIALISING SIZE TO ZERO
    }
	
	void get()
	{
		System.out.print("Enter number of elements to insert:");
		size= scan.nextInt();
		System.out.print("\n");
		insert();
	}
	
    void insert()											//FUNCTION TO PUSH
    {	int s = 0;
		while(s != size)
		{	System.out.print("Enter integer element to insert:");
			val= scan.nextInt();
			
			Node temp = new Node(val, null);    
			
			if(front == null) 
			{
				front = temp;
				rear = front;
			}
			else 
			{
				rear.setLink(temp);
				rear = temp;
			}
			System.out.print("\n");
			s++;
		}
    }
	
	int get_Value(int m)
	{	int i = 1;
		Node temp = front;
		while(i <= m)
		{
			if(i == m)
			{	int a = temp.getData();
				return a;
			}
			i++;
			temp = temp.getLink();
		}
		return -1;
	}
	
	void search()
	{
		int b = 1, t = size, flag = 0, mid;
		
		System.out.print("Enter integer element to be searched:");
		x = scan.nextInt();
		
		while(flag == 0 && b<=t)
		{
			mid = (b+t)/2;
			int c = get_Value(mid);
			if( c== -1)
				break;
			if(x > c)
				b = mid + 1;
			else if(x < c)
				t = mid - 1;
			else
				flag = 1;
		}
		
		if(flag == 1)
			System.out.print("\nFound....\n");
		else
			System.out.print("\nNot Found....\n");
	}
}
 
class Binary_search												//CLASS LIST MAIN BLOCK
{    
    public static void main(String[] args)
    {             
        Linkedlist list = new Linkedlist(); 			//Creating object of class linkedList
        
		Scanner scan = new Scanner(System.in);
		
		int ch;
        
		list.get();
		list.search();
	}
}
