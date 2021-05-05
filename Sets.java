import java.util.*;

public class Sets {
    public static void main (String[] args){


        //Set demonstration using HashSet

        Set<String> hash_set = new HashSet<>();

        hash_set.add("Jag");
        hash_set.add("Heter");
        hash_set.add("Zakaria");
        hash_set.add("Hersi");
        System.out.println(hash_set);

        Set<Integer> setA = new HashSet<>();
        setA.addAll(Arrays.asList(new Integer[]{1,3,2,4,8,9,0}));
        Set<Integer> setB = new HashSet<>();
        setB.addAll(Arrays.asList(new Integer[]{1,3,7,5,4,0,7,5}));

        //To find union by the two
        Set<Integer> union = new HashSet<>();
        union.addAll(setB);
        System.out.println("Union of the two set = " + union );
    }
}
