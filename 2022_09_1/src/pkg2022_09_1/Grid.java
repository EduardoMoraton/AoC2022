/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2022_09_1;

import java.util.ArrayList;

/**
 *
 * @author macbook-edu
 */
public class Grid {

    Head h;
    Head lastH;
    Tail t;
    ArrayList<ArrayList<Object>> grid;
    String wasTail = "WT";

    public Grid() {
        h = new Head(100, 100);
        lastH = new Head(100,100);
        t = new Tail(100, 100);
        grid = new ArrayList<>();

    }

    public void create(int x, int y) {

        for (int i = 0; i < x+200; i++) {
            grid.add(new ArrayList<Object>());
        }

        for (ArrayList<Object> row : grid) {
            for (int i = 0; i < y+200; i++) {
                row.add(".");
            }
        }

        grid.get(h.y).set(h.x, h);

    }

    public void show() {
        for (int i = grid.size() - 1; i >= 0; i--) {
            for (Object o : grid.get(i)) {
                System.out.print(" " + o.toString() + " ");
            }
            System.out.println("");
        }
    }

    public Object get(int x, int y, Object o) {
        return grid.get(y).get(x);
    }

    public void moveHead(Dir d) {
        lastH.x = h.x;
        lastH.y = h.y;
        
        
        
        this.h.move(d);
       

        moveTail(d);

    }

    public void moveTail(Dir d) {
        System.out.println("TMOVE");
        
            for (int i = h.y - 1; i <= h.y + 1; i++) {
                for (int j = h.x - 1; j <= h.x + 1; j++) {
                    try {
                        
                        if (grid.get(i).get(j).equals(t))
                            return;
                    } catch (Exception e){
                        
                    }
                    
                }
                System.out.println("");

            }
        
        System.out.println("MOVING T");
        grid.get(t.y).set(t.x, "#");
        t.y = lastH.y;
        t.x = lastH.x;
        grid.get(lastH.y).set(lastH.x, t);
    }
    
    public int countGrid() {
        int sum = 0;
        for (ArrayList<Object> row: grid) {
            for (Object o: row) {
                if (o.equals("#") || o.equals(t)) {
                    sum ++;
                }
            }
        }
        
        return sum;
    }

}
