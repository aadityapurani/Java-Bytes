import java.util.Scanner;
class Calculation
{	
	int b,c,n,i,m;

	Scanner input = new Scanner (System.in);
	int a[];
	void intro()
	{	
		System.out.println("Enter size of the list which you want to keep....");
		m = input.nextInt();
		a = new int [m];
		System.out.println("Enter number of nubers you want to add first (You can add within the limit you have chosen for the list)....");
		n = input.nextInt();	
		for (i=0 ; i<n ; i++)
		{
			System.out.println("Enter "+ (i+1) +"th Number you want to add:  ");
			a[i]=input.nextInt();
		}
	}	
	
	void add_at_first()
	{
		System.out.println("Enter Number you want to add:  ");
		b = input.nextInt();
		for (i=n ; i>0 ; i--)
		{
			a[i] = a[i-1];
		}
		a[0]=b;
		n++;
	}	
	void add_at_postion()
	{
		System.out.println("Enter Number you want to add:  ");
		System.out.println("Enter Number of position where you want to add:  ");
		c = input.nextInt();
		for (i=n ; i>c ; i--)
		{
			a[i] = a[i-1];
		}
		a[c]=b;
		n++;
	}
	void add_a_last()
	{
		System.out.println("Enter Number you want to add:  ");
		b = input.nextInt();
		
		a[n]=b;
		n++;
	}	
	void delete_at_first()
	{
		for(i=0;i<(n-1);i++)
		{
			a[i] = a[i+1];
		}
		n--;
	}
	void delete_at_position()
	{
		System.out.println("Enter Number of position where you want to delete:  ");
		b = input.nextInt();
		for (i=(b-1);i<(n-1);i++)
		{
			a[i] = a[i+1];
		}
		n--;
	}
	void delete_at_last()
	{
		n--;
	}	
	void search()
	{
		System.out.println("Enter Number of position where you want to search a number:  ");
		b = input.nextInt();
		System.out.println("The number at "+b+"th position is:  "+a[b]);
	}
	void display()
	{
		for (i=0;i<n;i++)
		{	System.out.print("  "+a[i]); }
	}		
}

class List
{
public static void main(String[] args)
{
	Scanner input = new Scanner (System.in);
	int choice;	
	
	Calculation t = new Calculation();

	t.intro();
	
	do{
	
		System.out.println("\n\n\t\t\t\t\tMAIN MENU...: ");
		System.out.println("1.Add at first");
		System.out.println("2.Add at position");
		System.out.println("3.Add at last");
		System.out.println("4.Delete at first");
		System.out.println("5.Delete at position");
		System.out.println("6.Delete at last");
		System.out.println("7.Search");
		System.out.println("8.Display");
		System.out.println("9.Exit");
		System.out.println("Enter Your choice...: ");
		choice = input.nextInt();
	
		switch (choice)
		{
			case 1:
			{
				t.add_at_first();
				break;
			}
			case 2:
			{
				t.add_at_postion();
				break;
			}
			case 3:
			{
				t.add_a_last();
				break;
			}
			case 4:
			{
				t.delete_at_first();
				break;
			}
			case 5:
			{
				t.delete_at_position();
				break;
			}
			case 6:
			{
				t.delete_at_last();
				break;
			}
			case 7:
			{
				t.search();
				break;
			}
			case 8:
			{
				t.display();
				break;
			}
		}
	}while (choice <= 8);
}
}
