package com.adventofcode.y2022.day02;

import com.adventofcode.y2022.IOUtils;

import java.util.List;
import java.util.Map;


public class Part1 {


    private final static int CPU = 0;
    private final static int PLAYER = 1;
    private final static int DRAW = 2;

    public static void main(String[] args) {

        Map<String, Integer> values = Map.of(
                "A", 0,
                "B", 1,
                "C", 2,
                "X", 0,
                "Y", 1,
                "Z", 2);


        List<String> data = IOUtils.readData("day02input");

        List<Integer[]> numbers = data.stream()
                .map(i -> i.split(" "))
                .map(i -> new Integer[]{values.get(i[0]), values.get(i[1])}).toList();

        /*int result = numbers.stream()
                .mapToInt(i->getWinningBet(i[1],i[0]))
                .sum();

        System.out.println(result);*/

        System.out.println(getWinningBet(2,1));


    }

    private static int getWinningBet(int cpuBet, int playerBet) {
        int winner = CPU;
        int resultat = Math.abs(cpuBet - playerBet) % 2;
        if (resultat == 0) {
            if (cpuBet == playerBet) {
                winner = DRAW;
            } else if (cpuBet >= playerBet) {
                winner = PLAYER;
            }
        } else if (cpuBet <= playerBet) {
            winner = PLAYER;
        }
        int add = switch(winner){
            case 0 -> 0;
            case 1 -> 6;
            case 2 -> 3;
            default -> -1;
        };
        System.out.println("the winner is: "+winner);
        return playerBet+1+add;
    }
}
