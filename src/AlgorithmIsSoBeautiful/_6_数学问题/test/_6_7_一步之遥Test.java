package AlgorithmIsSoBeautiful._6_数学问题.test;

import AlgorithmIsSoBeautiful._6_数学问题._6_7_一步之遥;

import static org.junit.Assert.*;

public class _6_7_一步之遥Test {

    @org.junit.Test
    public void linearEquation() {
        try {
            _6_7_一步之遥.linearEquation(2,3,1);
            System.out.println(_6_7_一步之遥.x+" "+_6_7_一步之遥.y);
            _6_7_一步之遥.linearEquation(2,7,1);
            System.out.println(_6_7_一步之遥.x+" "+_6_7_一步之遥.y);
        } catch (Exception e) {
            System.out.println("无解");
        }
    }
}