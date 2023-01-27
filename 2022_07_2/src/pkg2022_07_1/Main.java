/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2022_07_1;

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

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br;
        br = new BufferedReader(new FileReader(new File("./data/input.txt")));

        ArrayList<Dir> dirs = new ArrayList<>();

        Dir root = new Dir("/", null);
        //dirs.add(root);
        Dir currDir = root;
        Command curCommand = null;

        String line;
        while ((line = br.readLine()) != null) {
            if (isCommand(line)) {
                if (line.split(" ")[1].equals("cd")) {
                    System.out.println("CD_____");
                    currDir = currDir.change(line.split(" ")[2]);

                }

            } else {
                if (line.split(" ")[0].equals("dir")) {
                    Dir tmpDir = new Dir(line.split(" ")[1], currDir);
                    dirs.add(tmpDir);
                    currDir.addDir(tmpDir);
                } else {
                    currDir.addFile(new FileB(line));
                }

            }
        }
        root.show("  ");
        System.out.println(root.getDirs().get(0).getDirs().toString());

        int HAVE = 70000000;
        int NEED = 30000000;
        int WE_NEED = NEED - (HAVE - root.getSize());

        System.out.println(WE_NEED);
        int deletedSize = 0;
        for (Dir d : dirs) {
            if (d.getSize() >= WE_NEED) {
                if (deletedSize == 0) {
                    deletedSize = d.getSize();
                } else {
                    if (deletedSize > d.getSize()) {
                        deletedSize = d.getSize();
                    }
                }

            }
        }

        System.out.println("RES: " + deletedSize);

    }

    private static boolean isCommand(String str) {
        return str.charAt(0) == '$';
    }

}
