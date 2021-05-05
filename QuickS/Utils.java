// Provides a function for converting an array to a string;
public class Utils {
    public static String toString(int[] array, int lo, int hi) {
        if (lo > hi) return "empty array";
        StringBuilder sb = new StringBuilder("{" + array[lo]);
        for (int i = lo+1; i <= hi; i++) {
            sb.append(", ");
            sb.append(array[i]);
        }
        sb.append("}");
        return sb.toString();
    }

    public static String toString(int[] array) {
        return toString(array, 0, array.length-1);
    }
}
