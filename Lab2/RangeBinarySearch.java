
import java.lang.reflect.Array;
import java.security.Key;
import java.util.*;

public class RangeBinarySearch {

    // Returns the index of the *first* element in terms[] that equals the search
    // key,
    // according to the given comparator, or -1 if there are no matching elements.
    // Complexity: O(log N), where N is the length of the array
    public static int firstIndexOf(Term[] terms, Term key, Comparator<Term> comparator) {
        int pointer1, pointer2, middle, currentKeyIndex, value;
        pointer1 = 0;
        pointer2 = terms.length - 1;
        currentKeyIndex = -1;
        middle = pointer1 + (pointer2 - pointer1) / 2;
        value = comparator.compare(key, terms[middle]);

        if (terms == null || key == null || comparator == null) {
            throw new IllegalArgumentException(
                    "Arguments can not be null values (RangeBinarySearch.java//firstIndexOf)");
        }

        while (pointer1 <= pointer2) {
            if (value == 0) {
                currentKeyIndex = middle;
                pointer2 = middle - 1;
            } else if (value < 0) {
                pointer2 = middle - 1;
            } else {
                pointer1 = middle + 1;
            }
            middle = (pointer1 + pointer2) / 2;
        }

        return currentKeyIndex;

    }

    // Returns the index of the *last* element in terms[] that equals the search
    // key,
    // according to the given comparator, or -1 if there are no matching elements.
    // Complexity: O(log N)
    public static int lastIndexOf(Term[] terms, Term key, Comparator<Term> comparator) {
        int pointer1, pointer2, middle, currentKeyIndex, value;
        pointer1 = 0;
        pointer2 = terms.length - 1;
        middle = (pointer1 + pointer2) / 2;
        currentKeyIndex = -1;
        value = comparator.compare(key, terms[middle]);

        if (terms == null || key == null || comparator == null) {
            throw new IllegalArgumentException(
                    "Arguments can not be null values (RangeBinarySearch.java//lastIndexOf)");
        }

        while (pointer1 <= pointer2) {
            if (value == 0) {
                currentKeyIndex = middle;
                pointer1 = middle + 1;
            } else if (value < 0) {
                pointer2 = middle - 1;
            } else {
                pointer1 = middle + 1;
            }
            middle = (pointer1 + pointer2) / 2;
        }
        return currentKeyIndex;
    }
}
