package com.quagmiresystems.euler;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Euler015LatticeGridDepthFirstSearchDynamic {

    private static int size = 20;
    private static Map<String, BigInteger> history = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(count(0, 0));
    }

    private static BigInteger count(int x, int y) {
        BigInteger h = history.get(x + "-" + y);
        if (h != null) {
            return h;
        }
        BigInteger c = BigInteger.ZERO;
        if (x != size) {
            c = c.add(count(x + 1, y));
        }
        if (y != size) {
            c = c.add(count(x, y + 1));
        }
        if (x == size && y == size) {
            c = c.add(BigInteger.ONE);
        }
        history.put(x + "-" + y, c);
        return c;
    }

}
