/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2022_04_1;

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

        ArrayList<Pair> pairs = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            Section s1 = new Section(line.split(",")[0]);
            Section s2 = new Section(line.split(",")[1]);
            pairs.add(new Pair(s1, s2));
        }

        int num = 0;

        for (Pair p : pairs) {
            System.out.println(p);
            if (p.getOverlapsIt()) {
                num ++;
            }

        }

        System.out.println(num);
    }

}
