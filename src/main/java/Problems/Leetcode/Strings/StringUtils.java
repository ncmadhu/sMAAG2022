package Problems.Leetcode.Strings;

import java.util.HashSet;

public class StringUtils {
    public static void gridPrint(char[][] chrLst) {
        System.out.println();
        for (char[] chrArr : chrLst) {
            System.out.print("[");
            int j = 0;
            for (char chr : chrArr) {
                System.out.print("'" + String.valueOf(chr) + "'");
                if (++j != chrArr.length)
                    System.out.print(", ");
            }
            System.out.println("]");
        }
    }

    // Custom function to print string array
    public static void arrPrint(HashSet<String> lst) {
        String res = "";
        int ind = 0;
        for (String str : lst) {
            res += "\"" + str + "\"";
            if (++ind != lst.size())
                res += ", ";
        }
        System.out.println("{" + res + "}");
    }
}
