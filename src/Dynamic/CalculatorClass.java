package Dynamic;

import java.util.Scanner;

class CalculatorClass {
     public static void main(String[] args) {
         new CalculatorClass().run();
     }

     void run() {
         Scanner scanner = new Scanner(System.in);
         int i = scanner.nextInt();
         System.out.println(F(i));

     }

     int F (int i) {
         if (i == 1 || i == 2 || i ==3) return 1;
         else {
             int count_3 = i % 3 == 0 ? F(i/3) : Integer.MAX_VALUE - 1;
             int count_2 = i % 2 == 0 ? F(i/2) : Integer.MAX_VALUE - 1;
             int count_1 = F(i - 1);
             return Math.min(count_1 + 1, Math.min(count_2 + 1, count_3 + 1));
         }
     }
}
