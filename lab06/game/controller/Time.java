package game.controller;

public class Time {
    private static long startTime = System.nanoTime();

    public static double getStartTime(){
        return startTime * 1E-9;
    }
    
    public static double getTime(){
        return (System.nanoTime() - startTime) * 1E-9;
    }
}
