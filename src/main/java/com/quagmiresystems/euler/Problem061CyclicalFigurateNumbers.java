package com.quagmiresystems.euler;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;

public class Problem061CyclicalFigurateNumbers {

    public static void main(String[] args) {

        List<Integer> triangles = allFourDigit(Problem061CyclicalFigurateNumbers::triangle);
        List<Integer> squares = allFourDigit(Problem061CyclicalFigurateNumbers::square);
        List<Integer> pentagonals = allFourDigit(Problem061CyclicalFigurateNumbers::pentagonal);
        List<Integer> hexagonals = allFourDigit(Problem061CyclicalFigurateNumbers::hexagonal);
        List<Integer> heptagonals = allFourDigit(Problem061CyclicalFigurateNumbers::heptagonal);
        List<Integer> octagonals = allFourDigit(Problem061CyclicalFigurateNumbers::octagonal);
//
//        Set<Integer> triangleSuffixes = suffixes(triangles);
//        Set<Integer> squareSuffixes = suffixes(squares);
//        Set<Integer> pentagonalSuffixes = suffixes(pentagonals);
//        Set<Integer> hexagonalSuffixes = suffixes(hexagonals);
//        Set<Integer> heptagonalSuffixes = suffixes(heptagonals);
//        Set<Integer> octagonalSuffixes = suffixes(octagonals);

//        List<Integer> filteredTriangles = filterForPrefixes(triangles, octagonalSuffixes);
//        List<Integer> filteredSquares = filterForPrefixes(squares, triangleSuffixes);
//        List<Integer> filteredPentagonals = filterForPrefixes(pentagonals, squareSuffixes);
//        List<Integer> filteredHexagonals = filterForPrefixes(hexagonals, pentagonalSuffixes);
//        List<Integer> filteredHeptagonals = filterForPrefixes(heptagonals, hexagonalSuffixes);
//        List<Integer> filteredOctagonals = filterForPrefixes(octagonals, heptagonalSuffixes);


//        Set<Integer> trianglePrefixes = prefixes(triangles);
//        Set<Integer> squarePrefixes = prefixes(squares);
//        Set<Integer> pentagonalPrefixes = prefixes(pentagonals);
//        Set<Integer> hexagonalPrefixes = prefixes(hexagonals);
//        Set<Integer> heptagonalPrefixes = prefixes(heptagonals);
//        Set<Integer> octagonalPrefixes = prefixes(octagonals);

//        List<Integer> filteredSquares = filterForSuffixes(squares, trianglePrefixes);
//        List<Integer> filteredPentagonals = filterForSuffixes(pentagonals, squarePrefixes);
//        List<Integer> filteredHexagonals = filterForSuffixes(hexagonals, pentagonalPrefixes);
//        List<Integer> filteredHeptagonals = filterForSuffixes(heptagonals, hexagonalPrefixes);
//        List<Integer> filteredOctagonals = filterForSuffixes(octagonals, heptagonalPrefixes);
//        List<Integer> filteredTriangles = filterForSuffixes(triangles, octagonalPrefixes);
//
//        List<Integer> filteredSquares = filterForSuffixes(squares, trianglePrefixes);
//        Set<Integer> filteredSquarePrefixes = prefixes(filteredSquares);
//        List<Integer> filteredPentagonals = filterForSuffixes(pentagonals, filteredSquarePrefixes);
//        Set<Integer> filteredPentagonalPrefixes = prefixes(filteredPentagonals);
//        List<Integer> filteredHexagonals = filterForSuffixes(hexagonals, filteredPentagonalPrefixes);
//        Set<Integer> filteredHexagonalPrefixes = prefixes(filteredHexagonals);
//        List<Integer> filteredHeptagonals = filterForSuffixes(heptagonals, filteredHexagonalPrefixes);
//        Set<Integer> filteredHeptagonalPrefixes = prefixes(filteredHeptagonals);
//        List<Integer> filteredOctagonals = filterForSuffixes(octagonals, filteredHeptagonalPrefixes);
//        Set<Integer> filteredOctagonalPrefixes = prefixes(filteredOctagonals);
//        List<Integer> filteredTriangles = filterForSuffixes(triangles, octagonalPrefixes);
//
//        System.out.println("triangles: " + triangles);
//        System.out.println("squares: " + squares);
//        System.out.println("pentagonals: " + pentagonals);
//        System.out.println("hexagaonals: " + hexagonals);
//        System.out.println("heptagonals: " + heptagonals);
//        System.out.println("octagonals: " + octagonals);
//
//
//        System.out.println("trianglePrefixes: " + trianglePrefixes);
//        System.out.println("squarePrefixes: " + squarePrefixes);
//        System.out.println("pentagonalPrefixes: " + pentagonalPrefixes);
//        System.out.println("hexagonalPrefixes: " + hexagonalPrefixes);
//        System.out.println("heptagonalPrefixes: " + heptagonalPrefixes);
//        System.out.println("octagonalPrefixes: " + octagonalPrefixes);
//
//
//        System.out.println("triangleSuffixes: " + triangleSuffixes);
//        System.out.println("squareSuffixes: " + squareSuffixes);
//        System.out.println("pentagonalSuffixes: " + pentagonalSuffixes);
//        System.out.println("hexagonalSuffixes: " + hexagonalSuffixes);
//        System.out.println("heptagonalSuffixes: " + heptagonalSuffixes);
//        System.out.println("octagonalSuffixes: " + octagonalSuffixes);
//
//
//        System.out.println("filteredTriangles: " + filteredTriangles);
//        System.out.println("filteredSquares: " + filteredSquares);
//        System.out.println("filteredPentagonals: " + filteredPentagonals);
//        System.out.println("filteredHexagonals: " + filteredHexagonals);
//        System.out.println("filteredHeptagonals: " + filteredHeptagonals);
//        System.out.println("filteredOctagonals: " + filteredOctagonals);

        List<List<List<Integer>>> listOfLists = new ArrayList<>();
        List<List<Integer>> aList = asList(triangles, squares, pentagonals, hexagonals, heptagonals, octagonals);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (j != i) {
                    for (int k = 0; k < 6; k++) {
                        if(k != i && k != j) {
                            for (int l = 0; l < 6; l++) {
                                if(l != i && l != j && l != k) {
                                    for (int m = 0; m < 6; m++) {
                                        if( m != i && m != j && m != k && m != l) {
                                            for (int n = 0; n < 6; n++) {
                                                if(n != i && n != j && n != k && n != l && n != m) {
                                                    System.out.print(".");
                                                    listOfLists.add(asList(aList.get(i), aList.get(j), aList.get(k), aList.get(l), aList.get(m), aList.get(n)));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("#####");
        for (List<List<Integer>> list : listOfLists) {
            for (Integer triangle : list.get(0)) {
                int trianglePrefix = prefix(triangle);
                List<Integer> matchingSquares = haveSuffix(list.get(1), trianglePrefix);
                for (Integer square : matchingSquares) {
                    int squarePrefix = prefix(square);
                    List<Integer> matchingPentagonals = haveSuffix(list.get(2), squarePrefix);
                    for (Integer pentagonal : matchingPentagonals) {
                        int pentagonalPrefix = prefix(pentagonal);
                        List<Integer> matchingHexagonals = haveSuffix(list.get(3), pentagonalPrefix);
                        for (Integer hexagonal : matchingHexagonals) {
                            int hexagonalPrefix = prefix(hexagonal);
                            List<Integer> matchingHeptagonals = haveSuffix(list.get(4), hexagonalPrefix);
                            for (Integer heptagonal : matchingHeptagonals) {
                                int heptagonalPrefix = prefix(heptagonal);
                                List<Integer> matchingOctagonals = haveSuffix(list.get(5), heptagonalPrefix);
                                for (Integer octagonal : matchingOctagonals) {
                                    if (prefix(octagonal) == suffix(triangle)) {
                                        System.out.println("match: " + asList(triangle, square, pentagonal, hexagonal, heptagonal, octagonal));
                                    } else {
                                        //System.out.println("close: " + asList(triangle, square, pentagonal, hexagonal, heptagonal, octagonal));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static List<Integer> haveSuffix(List<Integer> ints, int suffix) {
        return ints.stream()
                .filter(i -> suffix(i) == suffix)
                .collect(toList());
    }

    private static Set<Integer> prefixes(List<Integer> ints) {
        return ints.stream()
                .map(Problem061CyclicalFigurateNumbers::prefix)
                .collect(toCollection(TreeSet::new));
    }

    private static Set<Integer> suffixes(List<Integer> ints) {
        return ints.stream()
                .filter(i -> suffix(i) >= 10)
                .map(Problem061CyclicalFigurateNumbers::suffix)
                .collect(toCollection(TreeSet::new));
    }

    private static List<Integer> filterForPrefixes(List<Integer> ints, Set<Integer> prefixes) {
        return ints.stream()
                .filter(i -> prefixes.contains(prefix(i)))
                .collect(toList());
    }

    private static List<Integer> filterForSuffixes(List<Integer> ints, Set<Integer> suffixes) {
        return ints.stream()
                .filter(i -> suffixes.contains(suffix(i)))
                .collect(toList());
    }

    private static List<Integer> allFourDigit(Function<Integer, Integer> function) {
        List<Integer> ints = new ArrayList<>();
        for (int i = 1; ; i++) {
            int result = function.apply(i);
            if (result >= 1_000 && result <= 9_999) {
                ints.add(result);
            }
            if (result >= 10_000) {
                break;
            }
        }
        return ints;
    }

    private static int triangle(int n) {
        return n * (n + 1) / 2;
    }

    private static int square(int n) {
        return n * n;
    }

    private static int pentagonal(int n) {
        return n * (3 * n - 1) / 2;
    }

    private static int hexagonal(int n) {
        return n * (2 * n - 1);
    }

    private static int heptagonal(int n) {
        return n * (5 * n - 3) / 2;
    }

    private static int octagonal(int n) {
        return n * (3 * n - 2);
    }

    private static int prefix(int n) {
        return n / 100;
    }

    private static int suffix(int n) {
        return n % 100;
    }
}
