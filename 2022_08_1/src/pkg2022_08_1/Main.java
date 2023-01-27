/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2022_08_1;

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
        
        ArrayList<ArrayList<Tree>> trees = new ArrayList<>();
        String line;
        
        int y = 0;
        while ((line = br.readLine())!=null) {
            ArrayList<Tree> row = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                row.add(new Tree(i,y, Integer.valueOf(String.valueOf(line.charAt(i))), trees));
            }
            trees.add(row);
            y ++;
            
        }
        
        int notVisible = 0;
        for ( ArrayList<Tree> tRow : trees) {
            for (Tree t : tRow) {
                if (t.isVisible()) {
                    notVisible ++;
                }
                System.out.println(t);
            }
        }
        System.out.println(notVisible);
        
    }

}
