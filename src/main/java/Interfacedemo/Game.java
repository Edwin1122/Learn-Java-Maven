package Interfacedemo;

import static java.lang.System.out;

public class Game {
    public static void main(String[] args) {
        play(Action.UP);
        play(Action.RIGHT);
    }
    public static void play(int action) {
        switch (action) {
            case Action.STOP:
                out.println("stop play image");
                break;
            case Action.UP:
                out.println("play turn up image");
                break;
            case Action.RIGHT:
                out.println("play turn right image");
        }
    }
}
