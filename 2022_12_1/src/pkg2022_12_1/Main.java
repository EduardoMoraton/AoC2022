/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2022_12_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author macbook-edu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, CloneNotSupportedException {
        BufferedReader br;
        br = new BufferedReader(new FileReader(new File("./data/test.txt")));

        String line;
        
        Grid Mgrid = new Grid(5);

        Cell start = null;
        Cell end = null;

        int y = 0;
        while ((line = br.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                int val = (int) line.charAt(i);
                Cell c = new Cell(val, i, y);
                if (line.charAt(i) == 'S') {
                    c.setIsIn(true);
                    start = c;
                }
                if (line.charAt(i) == 'E') {
                    c.setEnd(true);
                    end = c;
                }

                Mgrid.add(y, c);
            }
            y++;
        }
        
        
        
        
        

        start.setSize((int) 'a');
        end.setSize((int) 'z');
        
        
        
        
        
        Stack<Cell> back = new Stack<>();
        Grid grid = Mgrid.clone();
        Cell curr = start;
        grid.show();
        System.out.println(curr.getInfo());
        
        int totalSteps = 0;
        int steps = 0;
        totalSteps = calculate(grid, curr, steps);
        
        System.out.println(totalSteps);
        
        
        
        
        

    }

    private static int calculate(Grid grid, Cell curr, int steps) throws CloneNotSupportedException {
        
        
        while (!curr.isEnd()) {
            
            
            System.out.println(steps);
            
            int cx = curr.getX();
            int cy = curr.getY();

            Cell L = grid.get(cx - 1, cy); // 0
            Cell U = grid.get(cx, cy - 1); // 1 
            Cell R = grid.get(cx + 1, cy); // 2 
            Cell D = grid.get(cx, cy + 1); // 3
            steps++;
            
            
            
            
            if (curr.canGo(L) && !curr.getVisited()[0]) {
                Grid gridL = grid.clone();
                Cell currL = (Cell)curr.clone();
                Cell cL = gridL.get(cx - 1, cy);
                int LSteps = steps;
                
                currL.setVisited(0);
                cL.setVisited(2);
                
                cL.setIsIn(true);
                currL.setIsIn(false);
                currL = cL;
                calculate(gridL, currL, LSteps);
                
                
            }
            if (curr.canGo(U) && !curr.getVisited()[1]) {
                Grid gridL = grid.clone();
                Cell currL = (Cell)curr.clone();
                Cell cU = gridL.get(cx, cy - 1); // 1 
                int LSteps = steps;
                
                currL.setVisited(1);
                cU.setVisited(3);
                
                cU.setIsIn(true);
                currL.setIsIn(false);
                currL = cU;
                calculate(gridL, currL, LSteps);
                
            }
            if (curr.canGo(R) && !curr.getVisited()[2]) {
                Grid gridL = grid.clone();
                Cell currL = (Cell)curr.clone();
                Cell cR = gridL.get(cx + 1, cy); // 2 
                int LSteps = steps;
                
                
                currL.setVisited(2);
                cR.setVisited(0);
                
                cR.setIsIn(true);
                currL.setIsIn(false);
                currL = cR;
                calculate(gridL, currL, LSteps);
            }
            if (curr.canGo(D) && !curr.getVisited()[3]) {
                Grid gridL = grid.clone();
                Cell currL = (Cell)curr.clone();
                Cell cD = gridL.get(cx, cy + 1); // 3
                int LSteps = steps;
                
                
                
                
                currL.setVisited(3);
                cD.setVisited(1);
                
                cD.setIsIn(true);
                currL.setIsIn(false);
                currL = cD;
                calculate(gridL, currL, LSteps);
            }
            
            
        }
        
        System.out.println(steps);
        return steps;
    }

}
