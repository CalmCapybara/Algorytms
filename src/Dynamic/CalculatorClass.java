package Dynamic;

import java.util.Arrays;
import java.util.Scanner;

class CalculatorClass {
    public static void main(String[] args) {
        new CalculatorClass().run();
    }

    void run() {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        if (i < 3) {
            System.out.println("0");
            System.out.println(i);
        }
        int[] array = new int[i + 1];
        array[1] = 0;
        array[2] = 1;
        array[3] = 1;

        for (int j = 4; j <= i; j++) {
            int[] counts = new int[3];
            counts[0] = j % 3 == 0 ? array[j / 3] : Integer.MAX_VALUE;
            counts[1] = j % 2 == 0 ? array[j / 2] : Integer.MAX_VALUE;
            counts[2] = array[j - 1];
            array[j] = Arrays.stream(counts).min().getAsInt() + 1;
        }
        System.out.println(array[i]);
        int chislo = array[i];
        int[] result = new int[chislo+1];
        for (int j = i, i1 = 0; j > 0; i1++) {
            result[i1] = j;
            while (array[j] >= chislo) {
                if (j == 0) break;
                j--;
            }
            chislo--;
        }
        for (int i1 = result.length - 1; i1 >= 0; i1--) {
            System.out.print(result[i1] + " ");
        }

    }


}
