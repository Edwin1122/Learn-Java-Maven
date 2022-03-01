package ThreadDemo.ThreadPractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreloaderTest {

    @Test
    void get() throws InterruptedException, DataLoadException {
        Preloader preloader = new Preloader();
        preloader.start();
        System.out.println(preloader.get());
    }
}