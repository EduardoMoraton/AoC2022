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
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
            for (int i = 0; i < Integer.valueOf(line.split(" ")[1]); i++) {
                orders.add(new Order(line.split(" ")[0], 1));
            }

        }

        ArrayList<Knot> rope = new ArrayList<>();
        ArrayList<Pos> log = new ArrayList<>();

        rope = createRope(10, log);

        for (Knot k : rope) {
            System.out.println(k);
        }

        int ci = 0;
        while (ci < orders.size()) {
            System.out.println(orders.get(ci));
            rope.get(0).move(orders.get(ci).getDirecction());
            
            ci++;

        }
        
        show(rope, log);

        for (Knot k : rope) {
            System.out.println(k);
        }

        ArrayList<String> singlePos = new ArrayList<>();

        for (Pos p : log) {
            singlePos.add(p.x + "  " + p.y);
        }
        
        System.out.println(getDuplicates(singlePos).size()-log.size());

    }

    private static ArrayList<Knot> createRope(int i, ArrayList<Pos> log) {
        ArrayList<Knot> rope = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            rope.add(new Knot(null, null, null, log));
        }

        for (int j = 0; j < rope.size(); j++) {
            Knot currKnot = rope.get(j);
            if (j - 1 != -1) {
                currKnot.setHead(rope.get(j - 1));
            }
            if (j + 1 != rope.size()) {
                currKnot.setTail(rope.get(j + 1));
            }
            if (j == 0) {
                currKnot.setName("H");
            } else {
                currKnot.setName(String.valueOf(j));
            }
            currKnot.setPos(new Pos(300, 300));

        }

        return rope;
    }

    private static void show(ArrayList<Knot> rope, ArrayList<Pos> log) {
        int maxX = 600;
        int maxY = 600;
        int tailP = 0;
        for (int i = maxY; i >= 0; i--) {
            for (int j = 0; j < maxX; j++) {
                boolean printed = false;

                for (Knot k : rope) {
                    if (k.getPos().x == j && k.getPos().y == i && !printed) {
                        System.out.print(" " + k.getName() + " ");
                        printed = true;
                    }

                }
                
                if (!printed) {
                    for (Pos l : log) {
                        if (l.x == j && l.y == i && !printed) {
                            System.out.print(" # ");
                            tailP ++;
                            printed = true;
                        }
                    }
                }
                

                if (!printed) {
                    System.out.print(" . ");
                }

            }
            System.out.println("");
        }
        System.out.println(tailP+1);
    }

    public static Set<String> getDuplicates(List<String> list) {
        return list.stream().filter(i -> Collections.frequency(list, i) > 1).collect(Collectors.toSet());
    }

}
