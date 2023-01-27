/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2022_06_1;

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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br;
        br = new BufferedReader(new FileReader(new File("./data/input.txt")));
        
        String line;
        String stream = "";
        while ((line = br.readLine())!=null) {
            stream += line;
        }
        
        
        
        for (int i = 0; i < stream.length()-14; i++) {
            String buff;
            buff = stream.substring(i, i+14);
            System.out.print(buff + " > ");
            if (isRepeated(buff)) {
                System.out.println(i+14);
                break;
            }
        }
        
    }
    
    private static Boolean isRepeated(String str) {
        int reps = 0;
        for (char ch : str.toCharArray()) {
            reps = 0;
            for (char ch2 : str.toCharArray()) {
                System.out.println(ch + " > " + ch2);
                if (ch == ch2) {
                    reps ++;
                }
                
                if (reps == 2) {
                    return false;
                }
            }
        }
        return true;

    }

}
