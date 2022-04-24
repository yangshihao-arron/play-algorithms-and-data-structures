package a1_linear_search;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        String[][] name1 = {{"G", "a", "o"}, {"H", "u", "a", "n"}, {"j", "i", "e"}};
        String[][] name2 = {{"G", "a", "o"}, {"H", "u", "a", "n"}, {"j", "i", "e"}};

        System.out.println(Arrays.equals(name1, name2));    // false
        System.out.println(Arrays.deepEquals(name1, name2));// true
      /*  String[] name1 = {"G","a","o","H","u","a","n","j","i","e"};
        String[] name2 = {"G","a","o","H","u","a","n","j","i","e"};
        System.out.println(Arrays.equals(name1, name2));      // true
        System.out.println(Arrays.deepEquals(name1, name2));  // true*/
        String[] a=new String[]{"123","456","789"};
        String[] b=new String[]{"123","456","789"};

        boolean result=Arrays.equals(a,b);
        System.out.println(result);//true
        System.out.println(a.equals(b));   //false

    }

}
