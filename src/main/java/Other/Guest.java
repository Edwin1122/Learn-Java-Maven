package Other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Guest {
    public static void main(String[] args) {
        List names = new ArrayList<>();
        collectNameTo(names);
        out.println("Visitors List: ");
        printUpperCase(names);
    }

    static void collectNameTo(List names) {
        Scanner console = new Scanner(System.in);
        while (true) {
            out.print("Visitors Name: ");
            String name = console.nextLine();
            if(name.equals("quit")) {
                break;
            }
            names.add(name);
        }
    }

    static void printUpperCase(List names) {
        for (int i = 0; i < names.size(); i++) {
            String name = (String) names.get(i);
            out.println(name.toUpperCase());
        }
    }
}

