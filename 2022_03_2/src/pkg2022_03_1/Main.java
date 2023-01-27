/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2022_03_1;

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
        ArrayList<Rucksack> rucks = new ArrayList<>();
        
        while ((line = br.readLine())!=null) {
            rucks.add(new Rucksack(line));
        }
        
        int priorSums = 0;
       
        for (int i = 0; i < rucks.size(); i+=3) {
            ArrayList<Rucksack> cluster = new ArrayList<>();
            String str1 = rucks.get(i).getFullList();
            String str2 = rucks.get(i+1).getFullList();
            String str3 = rucks.get(i+2).getFullList();

            
            Cluster c = new Cluster(str1, str2, str3);
            
            
            priorSums+= c.getPrioritySum();
        }
        
        System.out.println(priorSums);
    }
    
}
