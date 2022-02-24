package Other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordCount {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Please input words:");
        Set words = tokenSet(console.nextLine());
        System.out.printf("There are d% non-repeated words: s%n%", words.size(), words);
    }

    static Set tokenSet(String line) {
        String [] tokens = line.split(",");
        return new HashSet(Arrays.asList(tokens));
    }
}
