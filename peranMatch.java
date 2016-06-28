/*Programme of parenthesis matching by aadityapurani(1401083) */
import java.util.*;

//import Infix.Link;

//import Infix.Link;
class Link
{
	public  char info;
	public Link link;
}

class Stack
{
	public Link Top=null;
	public int size=0;
	public void push(char pushed_item) // put item on top of stack
	{ 
		Scanner sc =new Scanner(System.in);
		Link tmp=new Link();
		tmp.info=pushed_item;
		tmp.link=Top;
		Top=tmp;
		//System.out.println("Pushed item :"+(char)Top.info);
		size++;  

	}
	public char peek_n_element(int pos1) // return item at index n
	{
		Link current = Top;//intalization of current pointer as Top
		double i;

		for(i=pos1;i>0;i--)//loop for geting upto position
		{
			current=current.link;//incrementing pointer
			if(current==null)//if  statement for if some one enter position out of index then it will return
			{
				System.out.println("There are less then "+pos1+" elements");
				return 0 ;
			}
		}

		char tmp1=(char)current.info;
		return tmp1;
	}
	/*public void post_push(double pushed_item) // put item on top of stack
	{ 
		Scanner sc =new Scanner(System.in);
		Link tmp=new Link();
		tmp.info=pushed_item;
		tmp.link=Top;
		Top=tmp;
		System.out.println("Answer :"+pushed_item);
		size++;  

	}*/
	/*public double post_pop()
	{
		Link tmp=Top;
		if(Top==null)
		{
			System.out.println("Stack is empty\n");
		}
		else
		{
			tmp=Top;
			System.out.println("poped item is "+tmp.info);
			Top=Top.link;
			size--;
		}

		return tmp.info;

	}*/
	public double size() // return size
	{
		return size;
	}
	

	public char pop() // take item from top of stack
	{
		Link tmp=Top;
		if(Top==null)
		{
			//System.out.println("Stack is empty\n");
		}
		else
		{
			tmp=Top;
			System.out.print("poped item " +tmp.info);
			Top=Top.link;
			size--;
		}
		char tmp1=tmp.info;

		return tmp1;

	}
	public boolean isEmpty() // true if stack is empty
	{
		if(Top==null)
			return true;
		else
			return false;
	}
}
 class PerMat
{
	 Stack stk=new Stack();
	 void PerMa(){
		 Scanner scan=new Scanner(System.in);
     System.out.println("Parenthesis Matching Test\n");
     System.out.println("Enter expression");
     String exp = scan.next();        
     int len = exp.length();
     System.out.println("\nMatches and Mismatches:\n");
     
     for (int i = 0; i < len; i++)
     {    
    	 char ch ;
         ch = exp.charAt(i);
         if (ch == '(')
         {
             stk.push(ch);
            
         }
         else if (ch == ')')
         {
             try
             {
                stk.pop() ;
                 System.out.println(" index "+(i+1)+" matched with "+ch);
             }
             catch(Exception e)
             {
                 System.out.println(" index "+(i+1)+" is unmatched");
             }
         }            
     }
    		 for (int i = 0; i < len; i++)
    	     {    
    	    	 char ch ;
    	         ch = exp.charAt(i);
    	         if (ch == '{')
    	         {
    	             stk.push(ch);
    	            
    	         }
    	         else if (ch == '}')
    	         {
    	             try
    	             {
    	                stk.pop() ;
    	                 System.out.println(" index "+(i+1)+" matched with "+ch);
    	             }
    	             catch(Exception e)
    	             {
    	                 System.out.println(" index "+(i+1)+" is unmatched");
    	             }
    	         }            
    	     }
    		 for (int i = 0; i < len; i++)
    	     {    
    	    	 char ch ;
    	         ch = exp.charAt(i);
    	         if (ch == '[')
    	         {
    	             stk.push(ch);
    	            
    	         }
    	         else if (ch == ']')
    	         {
    	             try
    	             {
    	                stk.pop() ;
    	                 System.out.println(" index "+(i+1)+" matched with "+ch);
    	             }
    	             catch(Exception e)
    	             {
    	                 System.out.println(" index "+(i+1)+" is unmatched");
    	             }
    	         }            
    	     }
     while (!stk.isEmpty() )
     {
    	 int j=0;
    	 
         System.out.println(stk.peek_n_element(j)+" is unmatched");
         j++;
         break;
        
     }
 }
}
public class PeranMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PerMat pem=new PerMat();
		pem.PerMa();
		}

}
