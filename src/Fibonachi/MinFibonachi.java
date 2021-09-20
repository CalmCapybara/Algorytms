/*
Даны целые числа 1 <= n =<  10^{18} и
2 <= m =<  10^{5}
необходимо найти остаток от деления n-го числа Фибоначчи на m
 */
package Fibonachi;

import java.util.Scanner;

class MinFibonachi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        if (n == 1 || n == 2) {
            System.out.println(1);
            return;
        }

        long[] massivDeliteley = new long[]{0, 1, 1};
        long period = 0;
        long result = 0;
        do {
                massivDeliteley[0] = massivDeliteley[1];
                massivDeliteley[1] = massivDeliteley[2];
                massivDeliteley[2] = (massivDeliteley[0] + massivDeliteley[1]) % m;
                period++;
            }
            while (massivDeliteley[1] != 1 || massivDeliteley[2] != 1) ;
            massivDeliteley = new long[]{0, 1, 1};
            long stopper = n % period;
            if (stopper <= 2) {
                result = massivDeliteley[(int) stopper];
                System.out.println(result);
                return;
            }
            for (int i = 3; i <= stopper; i++) {
                massivDeliteley[0] = massivDeliteley[1];
                massivDeliteley[1] = massivDeliteley[2];
                massivDeliteley[2] = (massivDeliteley[0] + massivDeliteley[1]) % m;
            }
            System.out.println(massivDeliteley[2]);
        }

    }
