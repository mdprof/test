import java.util.HashSet;
import java.util.Iterator;

public class Main {

    public static void main(String[] params) {

        HashSet<String> mySet = new HashSet<>();
        mySet.add("qqq");
        mySet.add("www");
        mySet.add("eee");
        mySet.add("rrr");

        Iterator iterator = mySet.iterator();

        System.out.println(mySet);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (String str: mySet) {
            System.out.println(str);
            //mySet.remove(str);

        }
    }


}