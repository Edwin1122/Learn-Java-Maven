package ThreadDemo.BigDownloader;

import ThreadDemo.Util.Debug;

public class CaseRunner4_BigDownLoader {

    public static void main(String[] args) throws Exception {
        if (0 == args.length) {
            args = new String[] { "https://github.com/rangaeeeee/books-os/raw/master/Modern%20Operating%20Systems%20-%204th%20Edition.pdf", "2", "3" };
        }
        main0(args);
    }

    public static void main0(String[] args) throws Exception {
        final int argc = args.length;
        BigFileDownloader downloader = new BigFileDownloader(args[0]);

        // 下载线程数
        int workerThreadsCount = argc >= 2 ? Integer.valueOf(args[1]) : 2;
        long reportInterval = argc >= 3 ? Integer.valueOf(args[2]) : 2;

        Debug.info("downloading %s%nConfig:worker threads:%s,reportInterval:%s s.", args[0], workerThreadsCount, reportInterval);

        downloader.download(workerThreadsCount, reportInterval * 1000);
    }
}
