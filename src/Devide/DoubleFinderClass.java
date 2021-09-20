package Devide;

import java.util.Arrays;
import java.util.Scanner;

class DoubleFinderClass {
    public static void main(String[] args) {
        new DoubleFinderClass().run();
    }

    void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        int[] B = new int[k];
        for (int i = 0; i < k; i++) {
            B[i] = scanner.nextInt();
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            stringBuilder.append(doubleFinder(A, B[i])).append(" ");
        }
        System.out.println(stringBuilder);

    }
    public int doubleFinder(int[] A, int k) {
        int left = 0;
        int right = A.length-1;

        while (right >= left) {
            int aMid = (left + right) >> 1;
            if(k == A[aMid]) {
                return aMid + 1;
            } else if(k < A[aMid]) {
                right = aMid - 1;
            } else {
                left = aMid +1;
            }
        }

        return -1;
    }

}
