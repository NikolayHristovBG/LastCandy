package com.blankfactor.lastcandy;

import java.util.Random;

import static java.lang.Math.abs;

/*
    There are a total of 13 candies in a bag.
    The game is played between the Player and the Computer.
    Each of them can take 1-3 candies per round.
    Whoever takes the last candy is the winner.
    The Player starts first.
 */
public class Main {
    public static void main(String[] args) {

        playGame();
    }

    public static void playGame() {

        // Game
        for (int i=1; i<=1000; i++) {
            System.out.println("Game " + i + " start" );
            System.out.println();

            Random random = new Random();
            int candyTaken = 0;
            int candyLeft = 13;
            int round = 0;
            boolean playerWon = false;
            boolean computerWon = false;

            // Round
            newRound:
            for (int j=0; j<7; j++) {
                round = j + 1;
                System.out.println("Round " + round + " start" );
                System.out.println();
                //Player
                for (int k=0; k<2; k++) {

                    if (k == 0) {
                        System.out.println("Player's turn");
                    } else {
                        System.out.println("Computer's turn");
                    }

                    if (k == 0 && (candyLeft > 4)) {
                        candyTaken = candyLeft % 4;
                    } else if (candyLeft>=1 && candyLeft<=3) {
                        candyTaken = candyLeft;
                        if (k == 0) {
                            playerWon = true;
                        } else {
                            computerWon = true;
                        }
                    } else {
                        candyTaken = random.nextInt(3) + 1;
                    }
                    candyLeft -= candyTaken;
                    System.out.println("Candy taken: " + candyTaken);
                    System.out.println("Candy left: " + candyLeft);
                    System.out.println();

                    if (playerWon) {
                        System.out.println("Player won!");
                        break newRound;
                    } else if (computerWon) {
                        System.out.println("Computer won!");
                        break newRound;
                    }
                }
                System.out.println();
            }

            System.out.println();
            System.out.println("***********************************************************");
            System.out.println();
        }


    }
}
