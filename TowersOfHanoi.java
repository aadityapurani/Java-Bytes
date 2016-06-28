/*Tower of Hanoi by Aaditya Purani(1401083). Tested on windows*/

import java.util.*;                                    //importing lib files
public class TowersOfHanoi {                           //class TowerOfHanoi

    public void nums(int n, String start, String aux, String end)
  {
       if (n == 1)  //if n ==1
                   {
                     System.out.println(start + " -> " + end);  //will print that start position will go to an end position
                   }
       else 
       {
           nums(n - 1, start, end, aux);                     
           System.out.println(start + " -> " + end);
           nums(n - 1, aux, start, end); 
       }
   }

   public static void main(String[] args)
   {
       TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
       System.out.print("Hello !! Welcome to tower of Hanoi game\n");
       System.out.print("Dear User, Enter number of discs: ");
       Scanner scanner = new Scanner(System.in);
       int discs = scanner.nextInt();
       towersOfHanoi.nums(discs, "A", "B", "C");
   }
}
