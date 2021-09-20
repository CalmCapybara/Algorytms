package Dynamic;

import java.util.Arrays;
import java.util.Scanner;

class RedactionLength {
    public static void main(String[] args) {
        new RedactionLength().run();
    }

    void run() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] lineA = line.toCharArray();
        line = scanner.nextLine();
        char[] lineB = line.toCharArray();


//        char[] lineA = {'m', 'a', 'm', 'a'};
//        char[] lineB = {'p', 'a', 'p', 'a'};
        System.out.println(redactionLength(lineA,lineB));


    }


    int redactionLength(char[] A, char[] B) {
        int lines = A.length + 1;
        int columns = B.length + 1;



        int[][] dArray = new int[lines][columns];

        for (int i = 0; i < dArray.length; i++) {
            Arrays.fill(dArray[i], Integer.MAX_VALUE);
        }


        for (int i = 0; i < lines; i++) {
            dArray[i][0] = i;
        }
        for (int i = 0; i < columns; i++) {
            dArray[0][i] = i;
        }



        for (int i = 1; i < lines; i++) {
            for (int j = 1; j < columns; j++) {
                int k = Math.min(dArray[i-1][j], Math.min(dArray[i-1][j-1], dArray[i][j-1]));
                dArray[i][j] = diff(A[i-1],B[j-1]) + k;
            }
        }

        for (int[] ints : dArray) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        return dArray[lines - 1][columns - 1];
    }

    int diff(char A, char B) {
        if (A == B) return 0;
        return 1;
    }



}
