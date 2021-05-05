import java.util.Arrays;

public class Autocomplete {
    private Term[] dictionary;

    // Initializes the dictionary from the given array of terms.
    public Autocomplete(Term[] dictionary) {
        this.dictionary = dictionary;
        sortDictionary();
    }

    // Sorts the dictionary in *case-insensitive* lexicographic order.
    // Complexity: O(N log N), where N is the number of terms
    private void sortDictionary() {

        Arrays.sort(dictionary,Term.byLexicographicOrder());
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    // Complexity: O(log N + M log M), where M is the number of matching terms
    public Term[] allMatches(String prefix) {
        Term pre = new Term(prefix,0);

        int firstindex = RangeBinarySearch.firstIndexOf(dictionary,pre,Term.byPrefixOrder(prefix.length()));

        Term [] terms = new Term[numberOfMatches(prefix)];
        for (int i=0 ; i<terms.length; i++){

            terms[i] = dictionary[firstindex+i];

        }
        Arrays.sort(terms,Term.byReverseWeightOrder());
        return terms;
    }

    // Returns the number of terms that start with the given prefix.
    // Complexity: O(log N)
    public int numberOfMatches(String prefix) {
        Term pre = new Term(prefix,0);
        int firstindex = RangeBinarySearch.firstIndexOf(dictionary,pre,Term.byPrefixOrder(prefix.length()));
        int lastindex = RangeBinarySearch.lastIndexOf(dictionary,pre,Term.byPrefixOrder(prefix.length()));
        if (lastindex-firstindex==0)
            return 0;
        return lastindex-firstindex+1;
    }

}
