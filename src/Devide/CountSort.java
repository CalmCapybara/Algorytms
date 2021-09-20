package Devide;

import java.util.Arrays;
import java.util.Scanner;

class CountSort {
    public static void main(String[] args) {
        new CountSort().run();
    }

    void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] arrCount = new int[11];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            int chislo = arr[i];
            arrCount[chislo]++;
        }
        for (int i = 1; i < 10; i++) {
            int chislo = i;
            int predChislo = i - 1;
            arrCount[chislo] += arrCount[predChislo];
        }
        int[] arrResult = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int chislo = arr[i];
            int countChislo = arrCount[chislo];
            arrResult[countChislo - 1] = arr[i];
            arrCount[chislo]--;
        }
        for (int i : arrResult) {
            System.out.print(i + " ");
        }
    }
}
