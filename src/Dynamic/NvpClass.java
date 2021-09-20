package Dynamic;

import java.util.Arrays;
import java.util.Scanner;

class NvpClass {
    public static void main(String[] args) {
        new NvpClass().run();

    }
    void run() {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] A = new int[count];
        for (int i = 0; i < A.length; i++) {
            A[i] = scanner.nextInt();
        }
        int[] answer = NVP(A);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    int[] NVP(int[] array) {
        int[] L = new int[array.length + 1];
        int[] pos = new int[array.length + 1];
        int[] prev = new int[array.length];

        Arrays.fill(L, Integer.MIN_VALUE);
        L[0] = Integer.MAX_VALUE;
        prev[0] = -1;
        int length = 0;

        for (int i = 0; i < array.length; i++) {
            int position = binarySearch(L, array[i]);
            if (position < 0) {
                position = (position + 1) * -1;
            }
            L[position] = array[i];
            pos[position] = i;
            prev[i] = pos[position - 1];
            if (length < position) length = position;

        }
        System.out.println(length);
        int[] answer = new int[length];
        int position = pos[length];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = position + 1;
            position = prev[position];
        }

        return answer;
    }


     int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal >= key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -(low + 1);
    }
}
