// A version of merge sort that prints out what's going on.
// Provides a main method so you can compile and run the file.
import java.util.*;

public class Quick {
    public static void main(String[] args) {
        int[] array = {53,88,32,44,23,90,67,71,42};
        sort(array);
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(int[] a) {
        sort(a, 0, a.length - 1, 0);
        assert isSorted(a, 0, a.length - 1);
    }

    private static void print(int depth, String string) {
        for (int i = 0; i < depth*2; i++) System.out.print(' ');
        System.out.print(string);
    }

    private static void println(int depth, String string) {
        print(depth, string + "\n");
    }

    // quicksort the subarray from a[lo] to a[hi]
    public static void sort(int[] a, int lo, int hi, int depth) { 
        print(depth, "Sorting " + Utils.toString(a, lo, hi));
        if (hi <= lo) {
            System.out.println(" - base case");
            return;
        }

        int j = partition(a, lo, hi);
        println(depth, "Partitioned into " + Utils.toString(a, lo, j-1) + ", " + a[j] + ", " + Utils.toString(a, j+1, hi));
        sort(a, lo, j-1, depth+1);
        System.out.println("");
        sort(a, j+1, hi, depth+1);
        assert isSorted(a, lo, hi);

        println(depth, "Result is " + Utils.toString(a, lo, hi));
    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        System.out.println(" using " + a[lo] + " as pivot element");

        // a[lo] is unique largest element
        while (a[++i] < v) {
            if (i == hi) { exch(a, lo, hi); return hi; }
        }

        // a[lo] is unique smallest element
        while (v < a[--j]) {
            if (j == lo + 1) return lo;
        }

        // the main loop
        while (i < j) {
            exch(a, i, j);
            while (a[++i] < v) ;
            while (v < a[--j]) ;
        }

        // put partitioning item v at a[j]
        exch(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

   /***************************************************************************
    *  Helper sorting functions.
    ***************************************************************************/
    
    // exchange a[i] and a[j]
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (a[i] < a[i-1]) return false;
        return true;
    }
}


