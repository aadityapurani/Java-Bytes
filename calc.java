/*Programmed by Aaditya Purani */
/* Simple Calculator */
import java.util.*;   //Importing
 
class Function                      //public class Function 
{
   public void add(double x, double y)             // function for adding
    {
        double answer = x+y; 
        System.out.print("\nThe sum is " +answer+"\n");        
    }

    public void sub(double x, double y)             //function for substraction
    {
        double answer = x-y;      
    System.out.print("\nThe Substraction is " +answer+"\n");        
    }

    public void multiply(double x, double y)       // function for multiplication
    {
        double answer = x*y;     
System.out.print("\nThe Multiplication is " +answer+"\n");        
    }

   public void divide(double x, double y)         //function for division
    {
        double answer = x/y;        
    System.out.print("\nThe division is " +answer+"\n");  
    }



    public void square(double x)
    {
    double answer=x*x;
    System.out.print("\nThe square of 1st number is " +answer+"\n");  
    }
    
    public void square1(double y)
    {
    double answer=y*y;
    System.out.print("\nThe square of 2nd number is " +answer+"\n");  
    }

     public void sqrt(double x) //Method for square root of a number
     {
         double answer=Math.sqrt(x);
         System.out.print("\nThe square root of 1st number is " +answer+"\n");  
     } 

     public void sqrt1(double y) //Method for square root of a number
     {
         double answer=Math.sqrt(y);
         System.out.print("\nThe square root of 2st number is " +answer+"\n");  
     } 

  public void modulo(double x, double y)         //function for modulo
    {
        double answer = x%y;        
    System.out.print("\nThe modulo is " +answer+"\n");  
    }

}

class Calc{

public static void main(String[] args) {
    Scanner S = new Scanner(System.in);
    Function f = new Function();
    double m, n;
    int o;
    double answer = 0;
 System.out.print("\n\nWelcome to Calculator\n\n");
while(true){
 System.out.print("Enter value of number 1:\n");
  m = S.nextDouble();
 System.out.print("Enter value of number 2:\n");
  n = S.nextDouble(); 
   

System.out.print("\nDear user, please make the choice from below:\n");
System.out.print("\nEnter 1 for addition");
System.out.print("\nEnter 2 for substraction");
System.out.print("\nEnter 3 for multiplication");
System.out.print("\nEnter 4 for division");
System.out.print("\nEnter 5 for square");
System.out.print("\nEnter 6 for square root");
System.out.print("\nEnter 7 for Modulo\n");
System.out.print("\nEnter 8 for exit\n");

o=S.nextInt();

switch(o) {
            case 1 : f.add(m,n);
                      break;

            case 2 : f.sub(m,n);
                      break;

            case 3: f.multiply(m,n);
                      break;

            case 4: f.divide(m,n);
                      break;
         
            case 5: f.square(m);
                    f.square1(n);
                    break;
    
            case 6: f.sqrt(m);
                    f.sqrt(n);
                    break;
            
            case 7: f.modulo(m,n);
                    break;
            
            case 8:   System.exit(0);
}
}
}
}
                      
