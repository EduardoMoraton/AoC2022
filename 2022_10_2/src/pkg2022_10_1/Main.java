/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2022_10_1;

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

        int cycle = 0;
        int signal = 1;

        String line;
        String com;
        Integer val;

        ArrayList<String> crt = new ArrayList<>();
        int crtI = -1;
        int flag = 40;
        String crtLine = "";

        String SpriteLine = "";

        while ((line = br.readLine()) != null) {

            if (line.equals("noop")) {

                
                crtI++;

                SpriteLine = createSpriteLine(signal);

                if (crtI == 40) {
                    crtI = 0;
                }
                if (cycle == flag) {
                    flag += 40;
                    crtI = 0;
                    crt.add(crtLine);
                    crtLine = "";

                }

                crtLine += createCtrLine(SpriteLine, crtI, flag);
                System.out.println(crtLine);
                cycle++;

            } else {
                val = Integer.valueOf(line.split(" ")[1]);

                
                crtI++;
                SpriteLine = createSpriteLine(signal);

                if (crtI == 40) {
                    crtI = 0;
                }
                if (cycle == flag) {
                    flag += 40;
                    crtI = 0;
                    crt.add(crtLine);
                    crtLine = "";
                }

                crtLine += createCtrLine(SpriteLine, crtI, flag);
                System.out.println(crtLine);
                cycle++;
                
                crtI++;
                SpriteLine = createSpriteLine(signal);
                signal += val;

                if (crtI == 40) {
                    crtI = 0;
                }
                if (cycle == flag) {
                    flag += 40;
                    crtI = 0;
                    crt.add(crtLine);
                    crtLine = "";
                }
                crtLine += createCtrLine(SpriteLine, crtI, flag);
                System.out.println(crtLine);
                cycle++;

            }
        }
        System.out.println("");
        System.out.println("");
        for (String c : crt) {
            System.out.println(c);
        }
        System.out.println(crtLine);

    }

    private static String createSpriteLine(int signal) {
        String l = "";

        for (int i = 0; i < 40; i++) {
            if (signal - 1 == i || signal == i || signal + 1 == i) {
                l += "#";
            } else {
                l += ".";
            }

        }
        System.out.println(l + " X: " + signal);

        return l;
    }

    private static String createCtrLine(String SpriteLine, int crtI, int flag) {
        System.out.println(crtI);
        if (SpriteLine.charAt(crtI) == '#') {
            return "#";
        } else {
            return " E";
        }

    }

}
