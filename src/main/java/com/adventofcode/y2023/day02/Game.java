package com.adventofcode.y2023.day02;

import java.util.ArrayList;
import java.util.List;

public class Game {


    public record Round(int red, int blue, int green) { }

    private final int id;
    private final List<Round> rounds;

    private Game(int id, List<Round> rounds) {
        this.id = id;
        this.rounds = rounds;
    }

    public int getId() {
        return id;
    }

    public boolean isPossible(int red, int blue, int green) {
        for (Round round : rounds) {
            if (round.green() > green || round.blue() > blue || round.red() > red) {
                return false;
            }
        }
        return true;
    }

    public int minimumCubesPower() {
        int red = rounds.stream().mapToInt(round -> round.red).max().orElse(0);
        int blue = rounds.stream().mapToInt(round -> round.blue).max().orElse(0);
        int green = rounds.stream().mapToInt(round -> round.green).max().orElse(0);
        return red * blue * green;
    }



    public static Game parseGame(String gameData) {
        int gameId = Integer.parseInt(gameData.split(":")[0].split(" ")[1]);
        List<Round> gameRounds = new ArrayList<>();

        String[] rounds = gameData.split(":")[1].split(";");

        for (String round : rounds) {
            int red = 0;
            int blue = 0;
            int green = 0;
            String[] colors = round.split(",");
            for (String color : colors) {
                color = color.trim();
                if (color.contains("blue")) {
                    blue = Integer.parseInt(color.split(" ")[0]);
                }
                if (color.contains("red")) {
                    red = Integer.parseInt(color.split(" ")[0]);
                }
                if (color.contains("green")) {
                    green = Integer.parseInt(color.split(" ")[0]);
                }
            }
            Round gameRound = new Round(red, blue, green);
            gameRounds.add(gameRound);

        }

        return new Game(gameId, gameRounds);
    }
}