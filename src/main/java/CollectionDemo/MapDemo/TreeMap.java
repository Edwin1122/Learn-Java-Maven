package CollectionDemo.MapDemo;

import java.util.Map;

public class TreeMap {
    public static void main(String[] args ) {
        Map<String, String> messages = new java.util.TreeMap<>();
        messages.put("Justin", "Hello! Justin");
        messages.put("Monica", "message to Monica");
        System.out.println(messages);
    }
}
