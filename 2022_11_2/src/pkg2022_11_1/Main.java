/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2022_11_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

        String line = "";
        ArrayList<Monkey> monkeys = new ArrayList<>();

        int id = -1;
        while (line != null) {
            id++;
            Monkey m = new Monkey();
            line = br.readLine(); // id
            m.setId(id);

            line = br.readLine();
            if (line == null) {
                break;
            }
            String it = line.split(":")[1].strip();
            String[] arr = it.split(", ");
            for (String s : arr) {
                m.add(Double.valueOf(s));
            }

            line = br.readLine();

            m.setOperationString(line);

            line = br.readLine();

            m.setTestDiv(Double.valueOf(line.split(" ")[5]));

            line = br.readLine();

            m.setMTrue(Integer.valueOf(line.split(" ")[9]));
            line = br.readLine();

            m.setMFalse(Integer.valueOf(line.split(" ")[9]));

            monkeys.add(m);

        }

        for (Monkey m2 : monkeys) {
            System.out.println(m2);
            m2.setMnks(monkeys);
        }
        System.out.println("-------");
        for (int i = 0; i < 20; i++) {
            System.out.println(i+1);
            for (Monkey m2: monkeys) {
                m2.turn();
            }
            for (Monkey m2: monkeys) {
                System.out.println(m2.getItems());
            }
            System.out.println("=========");
        }
        
        for (Monkey m2 : monkeys) {
            System.out.println(m2);
            
        }

        ArrayList<Double> mBussines = new ArrayList<>();
        
        for (Monkey m2 : monkeys) {
            mBussines.add(m2.getIteratedItems());
        }
        System.out.println(mBussines);
        Collections.sort(mBussines);
        Collections.reverse(mBussines);
        System.out.println(mBussines);
        System.out.println(mBussines.get(0) * mBussines.get(1));

    }

}
