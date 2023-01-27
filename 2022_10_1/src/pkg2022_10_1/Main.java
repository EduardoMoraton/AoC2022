/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2022_10_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author macbook-edu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br;
        br = new BufferedReader(new FileReader(new File("./data/input.txt")));

        int cycle = 1;
        int signal = 1;

        String line;
        String com;
        Integer val;

        ArrayList<Integer> fourties = new ArrayList<>();

        int flag = 20;

        while ((line = br.readLine()) != null) {

            if (line.equals("noop")) {
                cycle++;
                System.out.println(cycle);
                if (cycle == flag) {
                    System.out.println("flag " + flag + " signal " + signal);
                    fourties.add(signal*flag);
                    flag += 40;
                }
            } else {
                val = Integer.valueOf(line.split(" ")[1]);
                cycle++;
                System.out.println(cycle);
                if (cycle == flag) {
                    System.out.println("flag " + flag + " signal " + signal);
                    fourties.add(signal*flag);
                    flag += 40;
                }
                cycle++;
                signal += val;
                if (cycle == flag) {
                    System.out.println("flag " + flag + " signal " + signal);
                    fourties.add(signal*flag);
                    flag += 40;
                }
                

            }
        }

        System.out.println(signal);
        System.out.println(fourties.toString());
        
        
        int sum = 0;
        for (Integer i: fourties) {
            sum += i;
        }
        
        System.out.println(sum);

    }

}
