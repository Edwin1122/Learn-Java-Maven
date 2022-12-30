package IOdemo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

public class SerializationUtility {

    public static void main(String[] args) throws IOException {
        AppleProduct macBook = new AppleProduct();
        macBook.headphonePort = "headphonePort2020";
        macBook.thunderboltPort = "thunderboltPort2020";

        String serializedObj = serializeObjectToString(macBook);

        System.out.println("Serialized AppleProduct object to string:");
        System.out.println(serializedObj);
    }

    //Object -> ObjectOutputStream -> ByteArrayOutputStream -> byte[] -> String
    public static String serializeObjectToString(Serializable o) throws IOException {
        //创建字节数组流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        //再根据字节流对象创建对象流
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        //把对象写进对象输出流oos里
        oos.writeObject(o);
        oos.close();

        // 字节数组最终转化为String
        return Base64.getEncoder().encodeToString(
                //字节数组流最终存为字节数组
                baos.toByteArray()
        );
    }
}