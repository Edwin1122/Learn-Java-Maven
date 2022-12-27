package IOdemo;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Base64;

public class DeserializationUtility {

    public static void main(String[] args) throws ClassNotFoundException, IOException {

        String serializedObj = "rO0ABXNyABNJT2RlbW8uQXBwbGVQcm9kdWN0AAAAAAAS1ocCAAJMAA1oZWFkcGhvbmVQb3J0dAASTGphdmEvbGFuZy9TdHJpbmc7TAAPdGh1bmRlcmJvbHRQb3J0cQB+AAF4cHQAEWhlYWRwaG9uZVBvcnQyMDIwdAATdGh1bmRlcmJvbHRQb3J0MjAyMA==";
        System.out.println("Deserializing AppleProduct...");

        AppleProduct deserializedObj = (AppleProduct) deSerializeObjectFromString(serializedObj);

        System.out.println("Headphone port of AppleProduct:" + deserializedObj.getHeadphonePort());
        System.out.println("Thunderbolt port of AppleProduct:" + deserializedObj.getThunderboltPort());
    }

    public static Object deSerializeObjectFromString(String s)
            throws IOException, ClassNotFoundException {

        //先把数据存到字节数组里
        byte[] data = Base64.getDecoder().decode(s);

        //再用字节数组流读取到对象流ObjectInputStream
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));

        //对象流里读取对象
        Object o = ois.readObject();
        //关闭对象流
        ois.close();

        return o;
    }
}