/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2022_02_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author macbook-edu
 */
public class Main {

    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br;
        br = new BufferedReader(new FileReader(new File("./data/input.txt")));

        String line;
        int score = 0;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            Hand enemy = getHand(line.charAt(0));
            Hand me = getHand(line.charAt(2));
            int currScore = 0;
            
            
            switch (me) {
                case ROCK ->
                    currScore += 1; // ROCK
                case PAPER ->
                    currScore += 2; // PAPER
                default ->
                    currScore += 3; // Z SCISSORS
            }
            
            if (me == enemy) {
                currScore += 3;
            } else {
                if (me == Hand.ROCK && (enemy == Hand.PAPER)) {
                    System.out.println("lost");
                } else if (me == Hand.SCISORS && enemy == Hand.ROCK) {
                    System.out.println("lost");
                } else if (me == Hand.PAPER && enemy == Hand.SCISORS){
                    System.out.println("lost");
                } else {
                    currScore += 6;
                }
            }

            // draw
            System.out.println(currScore);
            score += currScore;

        }

        System.out.println(score);
    }
    
    private static Hand getHand(char c) {
        Hand res = Hand.SCISORS;
        switch (c) {
                case 'X' ->
                    res = Hand.ROCK; // ROCK
                case 'Y' ->
                    res = Hand.PAPER; // PAPER
                case 'A' ->
                    res = Hand.ROCK;
                case 'B' ->
                    res = Hand.PAPER;
                default ->
                    res = Hand.SCISORS;
                    
            }
        
        return res;
        
    }

}
