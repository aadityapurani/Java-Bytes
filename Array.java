/*Array program by Aaditya Purani.This include methods: InsertFirst, InsertLast. InsertAtPosition, DeleteFirst, DeleteLast, DeleteAtPosition, SearchByValue, SearchByPosition, Sort, Display, Exit */

import java.util.Scanner;    //importing scanner class

class Array_modify                                               //class Array_modify
{
	public static int add_item(int a[],int i)                  //method for addition   
	{
	   Scanner scan = new Scanner(System.in);                //Defining scanner
		
		int choice,j;                                    //variables 
		
		int a1[] = new int[i+1];                         
		
		System.out.println("Enter choice : ");                  //Will ask use to enter choice
	
		System.out.println("\n1.Add item at first position");
		System.out.println("2.Add item at user's position");
		System.out.println("3.Add item at last position\n");
		
		choice = scan.nextInt();                                 //Input of choice
		
		switch(choice)                                            //switch case
		{
			case 1:                                             //case 1
			
				System.out.println("Enter value : ");         
				
				for(j=0;j<i;j++)                             //for loop
				{
					a1[j+1] = a[j];                     //entering the value at one place ahead of the 
                                                                            //predetermined array
				}
					
				a1[0] = scan.nextInt();                    // value will stored at 0 position in array
				
				System.out.println("\n");                  
				
				for(j=0;j<i+1;j++)                        //printing of it
				{ 
					System.out.println(a1[j]);
				}
				
				break;
				
			case 2:                                           //case 2
				
				int position;
				
				System.out.println("Enter position : ");
				position = scan.nextInt();
					
				System.out.println("Enter value : ");                 
				
				for(j=0;j<position;j++)                    //for loop from 0 to position user selected
				{
					a1[j] = a[j];                     
				}
				
				for(j=(position-1);j<i;j++)                
				{
					a1[j+1] = a[j];
				}
				
				a1[position-1] = scan.nextInt();           //the value would be inserted as position user selected
				
				System.out.println("Your answer is : ");
				System.out.print("\n");
				
				for(j=0;j<i+1;j++)                          //printing of it
				{
					System.out.println(a1[j]);
				}
					
				break;
				
			case 3:                                             //case 3
				
				System.out.println("Enter value : ");    
				
				for(j=0;j<i;j++)                        //for loop value would be entered at last position
				{
					a1[j] = a[j];
				}
				
				a1[i] = scan.nextInt();
				
				System.out.println("\n");              //printing of it
				
				for(j=0;j<i+1;j++)                     
				{
					System.out.println(a1[j]);
				}
				
				break;
		}
	    return 0;
	}
	
public static int delete_item(int a[],int i)                           //method for delete
	{
			Scanner scan = new Scanner(System.in);       //defining scanner
		
			int choice,j;                               //variables
			
			System.out.println("Enter choice : ");
		
			System.out.println("\n1.Delete item at first position");
			System.out.println("2.Delete item at user's position");
			System.out.println("3.Delete item at last position\n");
			
			choice = scan.nextInt();
			
			switch(choice)                                     //switch case
			{
				case 1:                                   //case 1
					
					for(j=0;j<(i-1);j++)       //will delete first position of array and size also becomes 1 less
					{
						a[j] = a[j+1];
					}
					
					System.out.println("Your answer is : ");
					
					for(j=0;j<i-1;j++)           //printing of it
					{
						System.out.println(a[j]);
					}
					
						break;
					
				case 2:                                        //case 2
					
					int position;                        
					
					System.out.println("Enter position : ");
					position = scan.nextInt();					
					
					for(j=(position-1);j<(i-1);j++)              //deleting a element from particular position
					{
						a[j] = a[j+1];
					}
					
					System.out.println("Your answer is : ");            //printing answer
					
					for(j=0;j<i-1;j++)
					{
						System.out.println(a[j]);
					}
					
						break;
						
					case 3:     //case 3
					
					System.out.println("Your answer is : ");     
					
					for(j=0;j<i-1;j++)                                  //deleting the element from last place
					{
						System.out.println(a[j]);
					}
				
						break;
			}		
			return 0;
	}
	
   public static int search_element(int a[],int i)                   //search_element method 
	{
	    Scanner scan = new Scanner(System.in);
		
		int number,flag = 0;                   //flag initialized as zero
		
		System.out.println("Enter number : ");           //input 
		number = scan.nextInt();                
		
		for(int j=0;j<i;j++)                              //for loop
		{
			if(number == a[j])                                                 //if number is found in array 
			{
				System.out.println("Number exists and it's position is : " + (j+1));				
			}
			if(flag==1)                                                        //if not
			{
				System.out.println("Number don't not exist in the array");
                           				
			}	
                        	
			                          //flag will print the error only single time
		}	
	  return 0;		
	}
	
	public static int sort_array(int []a,int i)             //sort_array method
	{
			System.out.println("After sorting your answer is : ");
			
			for(int j=1;j<i;j++)                             //sorting array 
			{
				while(j>0 && a[j]<a[j-1])
				{
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
					j--;
				}
			}
			
			for(int j=0;j<i;j++)
			{
				System.out.println(a[j]);
			}
		return 0;
	}
}
	
public class Array                                                         //Main class Array 
    {
	 public static void main(String []args)
		{
		
			Scanner scan = new Scanner(System.in);       //Defining Scanner
	
			int size;
                        int choice;
			
			System.out.println("Enter size of array : ");        //will ask user how many size he wants to enter
			size = scan.nextInt();
			
			int array[] = new int[size];                      
			
			System.out.println("Enter numbers : ");      //will ask user to enter numbers
			
			for(int i=0;i<size;i++)                     //user can add as many numbers he defined previously
			{
				array[i] = scan.nextInt();
			}
                        
			
			System.out.println("\nEnter Your choice : ");          //asking choice to perform
			
			System.out.println("\n1.Add item in Array");
			System.out.println("2.Delete item from Array");
			System.out.println("3.Search Item from an Array");
			System.out.println("4.Sort Array\n");
                        System.out.println("5.Exit\n");
			
			choice = scan.nextInt();           //taking input scan
			
			Array_modify object = new Array_modify(); //creating object
			
                        
			switch(choice)                     //switch case
			{
				case 1 :
				     object.add_item(array,size);  //case 1 for add_item
                                     break;
				case 2 :
				     object.delete_item(array,size); //case 2 for delete_item
                                     break;
				case 3 :
				     object.search_element(array,size); //case 3 for search_element
                                     break;
				case 4:
				     object.sort_array(array,size);  //case 4 for sort_array
                                     break;
                                case 5:                   //exit 
                                      break;
                        
			}			
		}	
	}
