package IOdemo;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferDemo {
    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("pom.xml","r");
            FileChannel channel = raf.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(48);
            int byteReaded = channel.read(buffer);
            while(byteReaded != -1) {
                buffer.flip();
                while(buffer.hasRemaining()) {
                    System.out.print((char)buffer.get());
                }
                buffer.clear();
                byteReaded = channel.read(buffer);
            }
            raf.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
