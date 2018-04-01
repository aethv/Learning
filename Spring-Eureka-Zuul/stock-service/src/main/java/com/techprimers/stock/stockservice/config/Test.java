package com.techprimers.stock.stockservice.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        possibleSums(new int[]{10,50,100},new int[]{1,2,1});
    }

    static int possibleSums(int[] coins, int[] quantity) {
        Set<Integer> sums = new HashSet<Integer>();
        sums.add(0);
        for (int i = 0; i < quantity.length; ++i) {
            System.out.println("i: " + i + " - " + sums.size());
            List<Integer> sumsNow = new ArrayList<Integer>(sums);
            for (Integer sum : sumsNow) {
                for (int j = 1; j <= quantity[i]; j++) {
                    System.out.println("sum: " + sum + " + " + coins[i]);
                    sums.add(sum + j * coins[i]);
                }
            }
        }
        System.out.println(sums.size());
        return sums.size() - 1;
    }


}
