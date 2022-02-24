package ThreadDemo;

import cc.openhome.ThreadDemo.Util.Debug;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class FileDownloaderApp {
    public static void main(String[] args) {
        Thread downloaderThread = null;
        for (String url : args) {
            //create file downloader thread
            downloaderThread = new Thread(new FileDownloader(url));
            downloaderThread.start();
        }
    }

}

//File downloader

class FileDownloader implements Runnable {
    private final String fileURL;

    public FileDownloader(String fileURL) {
        this.fileURL = fileURL;
    }

    public void run() {
        Debug.info("Downloading from " + fileURL);
        String fileBaseName = fileURL.substring(fileURL.lastIndexOf('/') + 1);
        try {
            URL url = new URL(fileURL);
            String localFileName =  System.getProperty("java.io.tempdir")
                    + "/edwin-"
                    + fileBaseName;
            Debug.info("Saving to: " + localFileName);
            downloadFile(url, new FileOutputStream(localFileName), 1024);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Debug.info("Done downloading from " + fileURL);
    }

    private void  downloadFile(URL url, OutputStream outputStream, int bufSize)
        throws MalformedURLException, IOException {
        final HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("GET");
        ReadableByteChannel inChannel = null;
        WritableByteChannel outChannel = null;
        try {
            int responseCode = httpConn.getResponseCode();
            if(2 != responseCode / 100) {
                throw new IOException("Error: HTTP " + responseCode);
            }

            if(0 == httpConn.getContentLength()) {
                Debug.info("Nothing to be downloaded " + fileURL);
                return;
            }
            inChannel = Channels.newChannel(new BufferedInputStream(httpConn.getInputStream()));
            outChannel = Channels.newChannel(new BufferedOutputStream(outputStream));
            ByteBuffer buf = ByteBuffer.allocate(bufSize);
            while (-1 != inChannel.read(buf)) {
                buf.flip();
                outChannel.write(buf);
                buf.clear();
            }
        } finally {
            cc.openhome.ThreadDemo.Util.Tools.silentClose(inChannel, outChannel);
            httpConn.disconnect();
        }
    }// downloadFile ends
}//FileDownloader ends