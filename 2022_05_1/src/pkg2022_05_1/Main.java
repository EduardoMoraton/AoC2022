/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2022_05_1;

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
        br = new BufferedReader(new FileReader(new File("./data/input_boat.txt")));

        String line;
        int line_w;

        Boat boat = new Boat(3);
        while ((line = br.readLine()) != null) {
            line_w = line.length();
            int id = 0;
            for (int j = 1; j < line_w; j += 4) {
                String ch = String.valueOf(line.charAt(j));
                System.out.println(ch);
                if (!ch.equals(" ")) {
                    boat.getStacks().get(id).add(new Container(ch));
                }
                id++;
            }

        }


        boat.reverse();
        boat.show();
   
        BufferedReader br2;
        br = new BufferedReader(new FileReader(new File("./data/input.txt")));
        
        while ((line = br.readLine()) != null) {
            
            int quantity = Integer.valueOf(line.split(" ")[1]);
            int from = Integer.valueOf(line.split(" ")[3]);
            int to = Integer.valueOf(line.split(" ")[5]);
            System.out.println("from: " + from + " quantity: " + quantity + " to: " + to);
            boat.move(quantity, from, to);
            boat.show();
            
        }
        
        System.out.println(boat.getString());
    }

}
