package IOdemo;

import java.io.*;

public class RandomAccessFileDemo {
    public static void main(String[] args) {
        File file = new File("./test.txt");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("./test.txt","rw");
            raf.write(1000);
            raf.seek(0);
            System.out.println(raf.read());
            raf.seek(0);
            System.out.println(raf.readInt());
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (EOFException e) {
            System.out.println("reaches end before read enough bytes");
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }finally {
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
