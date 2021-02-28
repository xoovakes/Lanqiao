package AlgorithmIsSoBeautiful._6_数学问题.test;

import AlgorithmIsSoBeautiful._6_数学问题._6_7_拓展欧几里得;

public class _6_7_拓展欧几里得Test {

    @org.junit.Test
    public void linearEquation() {
        try {
            _6_7_拓展欧几里得.linearEquation(2,3,1);
            System.out.println(_6_7_拓展欧几里得.x+" "+ _6_7_拓展欧几里得.y);
            _6_7_拓展欧几里得.linearEquation(2,7,1);
            System.out.println(_6_7_拓展欧几里得.x+" "+ _6_7_拓展欧几里得.y);
        } catch (Exception e) {
            System.out.println("无解");
        }
    }
}