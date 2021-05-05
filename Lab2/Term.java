
import java.util.Comparator;


public class Term {
    private String word;
    private long weight;

    // Initializes a term with a given word and weight.
    public Term(String word, long weight) {
        this.word = word;
        this.weight = weight;
    }

    public Term(int i, int weight2) {
	}

	// Gets the word.
    public String getWord() {
        return word;
    }

    // Gets the weight.
    public long getWeight() {
        return weight;
    }

    // Extracts a prefix from the word.
    public String getPrefix(int len) {
        char [] ch = word.toCharArray();
        String str = "";
        if (len<ch.length){
        for (int i = 0 ; i<len ; i++){

            str=str+ch[i];

        }
        return str;}
        else  return word;
    }

    // Compares the two terms in case-insensitive lexicographic order.
    public static Comparator<Term> byLexicographicOrder() {
        Comparator<Term> c = new Comparator<Term>() {
            @Override
            public int compare(Term o1, Term o2) {
                String str1 = o1.word;
                String str2 = o2.word;
                int res = str1.compareToIgnoreCase(str2);
                return res;
            }
        };
        return c;
    }

    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder() {
        Comparator<Term> c = new Comparator<Term>() {
            @Override
            public int compare(Term o1, Term o2) {
                long w1 = o1.weight;
                long w2 = o2.weight;

                if (w2-w1<0)
                    return -1;
                else if (w1-w2<0)
                    return 1;
                else
                    return 0;

            }
        };
        return c;
    }

    // Compares the two terms in case-insensitive lexicographic order,
    // but using only the first k characters of each word.
    public static Comparator<Term> byPrefixOrder(int k) {      
        
        Comparator<Term> compare = new Comparator<Term>() {
            @Override
            public int compare(Term o1, Term o2) {
                String pref1 = o1.getPrefix(k);
                String pref2 = o2.getPrefix(k);
                return pref1.compareToIgnoreCase(pref2);
            }
        };
        return compare;
    } 
          

    // Returns a string representation of this term in the following format:
    // the weight, followed by whitespace, followed by the word.
    public String toString() {
        return String.format("%12d    %s", this.getWeight(), this.getWord());
    }

}