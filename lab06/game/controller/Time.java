package game.controller;

public class Time {
    private static long startTime = System.nanoTime();

    public static double getTime(){
        return (System.nanoTime() - startTime) * 1E-9;
    }
}
