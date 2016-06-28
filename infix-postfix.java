/* Code by Aaditya Purani*/
import java.util.Scanner;

class Node												//CLASS NODE 
{
   public
	
	char data;											//VARIABLE DATA TO TAKE INTEGER VALUE TO STORE
	Node link;											//OBJECT WHICH  LINK THE NEXT MODE
	
	Node()												//REGULAR CONSTRUCTOR
	{
		data = 0;											//INITIALISING DATA TO ZERO
		link = null;										//INITIALISING LINK TO NULL
	}
	
	Node(char d,Node n)									//PARAMETERISED CONSTRUCTOR
    {
        data = d;										//INITIALISING DATA TO 'd'
		link = n;										//INITIALISING LINK TO 'n'
    }    
 
    void setLink(Node n)								//FUNCTION TO SET LINK
    {	link = n;	}    
 
    void setData(char d)									//FUNCTION TO SET DATA
    {	data = d;	}    
 
    Node getLink()										//FUNCTION TO GET LINK
    {	return link;	}    
 
    char getData()										//FUNCTION TO GET DATA
    {	return data;	}
}

class Stack
{
  
  public
  	  
	Node start;											//OBJECT START TO POINT HEAD NODE
    Node end ;											//OBJECT END TO POINT END NODE
	int size,pos ;									//VARIABLE SIZE TO STORE THE SIZE OF LIST, POS TO TAKE INTERGER POSITION FROM USER
	char output [] = new char[100];
 
    Stack()										//REGULAR CONSTRUCTOR
    {
        start = null;									//INITIALISING START TO NULL
        end = null;										//INITIALISING END TO NULL
        size = 0;									//INITIALISING SIZE TO ZERO
	}

    void push(char val)								//FUNCTION TO INSERT AT BEGINING
    {	
		Node temp = new Node(val, null);    
        size++ ; 
		
        if(start == null) 
        {
            start = temp;
            end = start;
        }
        else 
        {
            temp.setLink(start);
            start = temp;
        }
	}

    char pop()								//FUNCTION TO DELETE AT BEGINING
    {   if(size > 0)
		{	char temp = start.getData();
			start = start.getLink();
			size--; 
			return temp;
		}
		else
		{	System.out.print("\nStack empty....\n");
			return 0;
		}
	}
	
	/*void value()
	{
		int s = size;
		char ans;
		int j=1;
		
		char temp1 = pop();
		int temp2 = pop();
		int temp3 = pop();
		
		for(int i=49; i<58;i++,j++)
			if(temp2 == i)
			{	temp2 = j;
				break;
			}
		for(int i=49; i<58;i++,j++)
			if(temp3 == i)
			{	temp3 = j;
				break;
			}
		
		if(temp1 == '+')
			ans = temp3 + temp2;
		else if(temp1 == '-')
			ans = temp3 - temp2;
		else if(temp1 == '*')
			ans = temp3 * temp2;
		else if(temp1 == '/')
			ans = temp3 / temp2;
		
		push(ans);
	} */
	
	void display()										//FUNCTION FOR DISPLAYING THE LIST
    {	int s=size;
        System.out.print("\nPostfix Expression = ");
        if (size == 0) 
			System.out.print("empty\n");
        else		
        {	Node temp = start;
			while ( s!=0 )
			{
				output[s-1] = temp.getData();
				temp = temp.getLink();
				s--;
			}
		}
		while(s<size)
		{	System.out.print(output[s]+" ");
			s++;
		}
    }
}

class Infix
{
	String infix;
	char ch;
	
	Scanner scan = new Scanner(System.in);
	
	Stack sym = new Stack();
	Stack num = new Stack();
	Stack out = new Stack();
	
   public
   
	void Infix()
	{
		infix = null;
		ch = 0;
	}
	void set_Infix()
	{
		System.out.print("\n Enter Infix Expression:\n ONLY ENTER SINGLE DIGIT NUMBER....\n");
		infix=scan.nextLine();
	}
	
	void get_Infix()
	{
		System.out.print("\nThe infix expression is:\n"+infix+"\n");
	}
	
	void breaking()
	{	
		for(int i=0;i<infix.length();i++)
		{	int alpha1=0, alpha2=0, flag=0;
			ch = infix.charAt(i);
			 
			if(ch == '+' || ch == '-' || ch == '-' || ch == '*' || ch == '/')
			{	if(i<2)
					sym.push(ch);
				else
				{	int s = sym.size;
					while(s > 0)
					{	char temp = sym.pop();
					
						if(ch == '+' || ch == '-')
							alpha1 = 1;
						else
							alpha1 = 2;
						
						if(temp == '+' || temp == '-')
							alpha2 = 1;
						else
							alpha2 = 2;
						
						if(alpha2 >= alpha1)
						{	
							num.push(temp);
							out.push(temp);
							/*out.value(); */
							flag = 1;
						}
						else
						{	
							sym.push(temp);
							sym.push(ch);
							break;
						}
						s--;
					}
					if(flag == 1)
						sym.push(ch);
				}
			}
			else 
			{
				num.push(ch);
				out.push(ch);
			}
		}
		int s = sym.size;
		while(s != 0)
		{
			char ptr = sym.pop();
			num.push(ptr);
			s--;
		}
	}
	
	void dis()
	{
		num.display();
	}
}

class Infix_postfix										//CLASS LIST MAIN BLOCK
{    
    public static void main(String[] args)
    {             
        Infix in = new Infix(); 			//Creating object of class linkedList
		
		in.set_Infix();
		in.breaking();
        in.dis();
    }
}
