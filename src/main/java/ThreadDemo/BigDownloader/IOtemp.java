package ThreadDemo.BigDownloader;

public class IOtemp {
    protected String fullFileName = System.getProperty("java.io.tmpdir");


    public static void main(String[] args) {
        IOtemp obj = new IOtemp();
        System.out.println("patch: " + obj.fullFileName);

    }
}
