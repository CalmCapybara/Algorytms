package Devide;

import java.util.*;

class QuickSort {
    public static void main(String[] args) {
        new QuickSort().run();
    }

    void run() {
        Scanner scanner = new Scanner(System.in);
        int linesAmount = scanner.nextInt();
        int dotsAmount = scanner.nextInt();
        int[] lineLeftDots = new int[linesAmount];
        int[] lineRightDots = new int[linesAmount];
        for (int i = 0; i < linesAmount; i++) {
            lineLeftDots[i] = scanner.nextInt();
            lineRightDots[i] = scanner.nextInt();
        }


//        long start = System.nanoTime();
        if(linesAmount > 1) {
            quickSort(lineLeftDots, 0, linesAmount - 1);
            quickSort(lineRightDots, 0, linesAmount - 1);
        }
        System.out.println(Arrays.toString(lineLeftDots));
        System.out.println(Arrays.toString(lineRightDots));


//        System.out.println(Arrays.toString(lineLeftDots));
//        System.out.println(Arrays.toString(lineRightDots));

//        Arrays.sort(lineLeftDots);
//        Arrays.sort(lineRightDots);


//
//        long end = System.nanoTime();
//        long traceTime = end - start;
//        System.out.println((float) traceTime / 1000000000);



        for (int i = 0; i < dotsAmount; i++) {
            int dot = scanner.nextInt();
            int countR = 0;
            int countL = 0;
            int count = 0;

            countL = doubleFinderLeft(lineLeftDots, dot);
            countR = doubleFinderRight(lineRightDots, dot);
            count = countL - countR;
            System.out.print(count + " ");
        }

    }

    public int doubleFinderLeft(int[] A, int k) {
        int left = 0;
        int right = A.length - 1;
        int mid = (left + right) / 2;
        if (k >= A[right]) return A.length;
        if (k < A[0]) return 0;
        while (right > left) {
            if (k >= A[mid]) {
                left = mid + 1;
                mid = (left + right) / 2;
            } else if (k < A[mid]) {
                right = mid;
                mid = (left + right) / 2;
            }
        }
        return mid;
    }

    public int doubleFinderRight(int[] A, int k) {
        int left = 0;
        int right = A.length - 1;
        int mid = (left + right) / 2;
        if (k > A[right]) return A.length;
        if (k < A[0]) return 0;
        while (right > left) {
            if (k > A[mid]) {
                left = mid + 1;
                mid = (left + right) / 2;
            } else if (k <= A[mid]) {
                right = mid;
                mid = (left + right) / 2;
            }
        }
        return mid;
    }

    public void quickSort(int[] array, int left, int right) {
//        int p = left + new Random().nextInt(right - left);
        int p = right;
//        System.out.println(p);
        int i = left, j = right;
        while (i <= j) {
            while (array[i] < array[p]) {
                i++;
            }
            while (array[j] > array[p]) {
                j--;
            }
            if (i <= j) {
//                if (i < j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
//                }
                i++;
                j--;
            }

        }
        if (left < j) quickSort(array, left, j);
        if (i < right) quickSort(array, i, right);
    }
}
