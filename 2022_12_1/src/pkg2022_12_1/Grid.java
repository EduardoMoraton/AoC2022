/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2022_12_1;

import java.util.ArrayList;

/**
 *
 * @author macbook-edu
 */
public class Grid {

    private ArrayList<ArrayList<Cell>> grid = new ArrayList<>();
    private int siz; 
    public Grid(int siz) {
        this.siz = siz;
        for (int i = 0; i < siz; i++) {
            grid.add(new ArrayList<Cell>());
        }
    }
    
    
    
    public Grid clone() throws CloneNotSupportedException{
        Grid g = new Grid(siz);
        
        for (ArrayList<Cell> gd: grid) {
            g.grid.add(new ArrayList<Cell>());
        }
        for (int i = 0; i < siz; i++) {
            for (Cell c: grid.get(i)) {
                g.grid.get(i).add((Cell)c.clone());
            }
        }
        
        
        return g;
    }

    public void add(int y, Cell c) {
        grid.get(y).add(c);
    }
    
    

    public Cell get(int x, int y) {
        Cell c;
        try {
            c = grid.get(y).get(x);
        } catch (Exception e) {
            return null;
        }
        
        return c;
        
    }
    
    
    public void show() {
        for (ArrayList<Cell> arr: grid) {
            for (Cell c: arr) {
                System.out.print(c);
            }
            System.out.println("");
        }
    }

}
