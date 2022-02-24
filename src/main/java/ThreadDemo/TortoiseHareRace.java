package ThreadDemo;

import static java.lang.System.out;
public class TortoiseHareRace {

    public static void main(String [] args) {
        boolean [] flags = {true, false};
        int totalStep  = 10;
        int tortoiseStep = 0;
        int hareStep = 0;
        out.println("The game starts...");
        while (tortoiseStep < totalStep && hareStep < totalStep) {
            tortoiseStep++; //乌龟走一步
            out.printf("Tortorse runs %d step %n",tortoiseStep);
            boolean isHareSleep = flags[((int)(Math.random() * 10)) % 2];
            if(isHareSleep) {
                out.println("Rabbit slept zzzz");
            } else {
                hareStep += 2;
                out.printf("Rabbit runs %d step %n", hareStep);
            }
        }

    }
}
