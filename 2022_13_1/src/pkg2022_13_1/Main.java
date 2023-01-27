/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2022_13_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        br = new BufferedReader(new FileReader(new File("./data/test.txt")));

        ArrayList<Packet> packets = new ArrayList<>();
        String line = "";

        while (line != null) {
            Packet pk = new Packet();
            line = br.readLine();
            System.out.println(line);
            pk.setF((ArrayList<Object>) parseLine(line));
            System.out.println(pk.getF());

            line = br.readLine();
            pk.setS((ArrayList<Object>) parseLine(line));
            line = br.readLine();
            packets.add(pk);
        }

        for (Packet pk : packets) {
            System.out.println(pk);
        }

    }

    private static List<Object> parseLine(String input) {

        // Recursive method to parse the input string
        // Create a new list to hold the elements
        List<Object> result = new ArrayList<>();

        // Split the input string at every "[" and "," characters
        // to get the individual elements
        String[] elements = input.split("[\\[,]");

        // Iterate over the elements
        for (String element : elements) {
            // If the element is empty, continue to the next one
            if (element.isEmpty()) {
                continue;
            }

            // If the element starts with a "[", it's a nested list
            // Call the parse method recursively to parse it
            if (element.startsWith("[")) {
                result.add(parseLine(element));
            } else {
                // Otherwise, it's an integer. Parse it and add it to the result list
                result.add(Integer.parseInt(element));
            }
        }

        return result;
    }
}
