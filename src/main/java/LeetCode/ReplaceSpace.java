package LeetCode;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReplaceSpace {

    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }

        return JSONObject.valueToString(input);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            String ret = new ReplaceSpaceSolution().replaceSpace(new StringBuffer(s));

            String out = (ret);

            System.out.print(out);
        }
    }
}

class ReplaceSpaceSolution {
    public String replaceSpace(StringBuffer str) {

        int P1 = str.length() - 1;
        for (int i = 0; i <= P1; i++)
            if (str.charAt(i) == ' ')
                str.append("  ");

        int P2 = str.length() - 1;
        while (P1 >= 0 && P2 > P1) {
            char c = str.charAt(P1--);
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }
}
