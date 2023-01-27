/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2022_09_1;

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

        String line;
        ArrayList<Order> orders = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            orders.add(new Order(line.split(" ")[0], Integer.valueOf(line.split(" ")[1])));
        }

        Head hTest = new Head(0, 0);
        int maxX = 0;
        int maxY = 0;
        for (Order o : orders) {
            for (int i = 0; i < o.getSteps(); i++) {
                hTest.move(o.getDirecction());
            }

            if (hTest.x > maxX) {
                maxX = hTest.x;
            }
            if (hTest.y > maxY) {
                maxY = hTest.y;
            }
        }

        System.out.println(maxX + " " + maxY);

        Grid grid = new Grid();

        grid.create(maxX + 2, maxY + 2);
        grid.show();

        for (Order o : orders) {
            for (int i = 0; i < o.getSteps(); i++) {
                System.out.println(o);
                grid.moveHead(o.getDirecction());
                
                System.out.println("---");

            }
            
            System.out.println("-------------");

        }
        
        System.out.println(grid.countGrid());
    }

}
