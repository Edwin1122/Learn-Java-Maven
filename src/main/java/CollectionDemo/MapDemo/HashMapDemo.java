package CollectionDemo.MapDemo;

import java.util.Map;
import java.util.Scanner;

import static java.lang.System.out;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, String> messages = new java.util.HashMap<>();
        messages.put("Justin", "Hello! Justin");
        messages.put("Monica", "message to Monica");

        Scanner console = new Scanner(System.in);
        out.print("Got whose message: ");
        String message = messages.get(console.nextLine());//get()传入key
        out.println(message);
        out.println(messages.hashCode());//返回 类似 187914895的 hashCode
    }
}
