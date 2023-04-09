package Guava;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuavaCacheServiceTest {

    @Test
    void setCache() throws InterruptedException {
        GuavaCacheService guavaCacheService = new GuavaCacheService();
        guavaCacheService.setCache();
    }
}