/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2022_01_1;

import classess.Elf;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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
 
        ArrayList<Elf> elfs = new ArrayList<>();
        
        String st;
        int sum = 0;
        int elfNum = 1;
        while ((st = br.readLine()) != null) {
            System.out.println(st);
            if (st.isBlank()) {
                elfs.add(new Elf(elfNum, sum));
                elfNum ++;
                sum = 0;
            } else {
                sum += Integer.parseInt(st);
            }
        }
        
//        System.out.println(elfs.stream().reduce((a,elf)->{
//           return elf.getCalNum() > a.getCalNum() ? elf : a;
//        }));

        elfs.sort((a,b)->Integer.compare(b.getCalNum(), a.getCalNum()));
        
        System.out.println(elfs.get(0).getCalNum() + elfs.get(1).getCalNum() + elfs.get(2).getCalNum());
    }
    
}
