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
public class Cell {

    private boolean isIn;
    private boolean end;
    private Boolean[] visited = new Boolean[]{false, false, false, false};
    private int size;
    private int x;
    private int y;
    private String move;

    public Cell(int size, int x, int y) {

        this.size = size;
        this.x = x;
        this.y = y;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Cell c = new Cell(size, x, y);
        c.setIsIn(isIn);
        c.setEnd(end);
        c.visited = visited;
        c.move = move;
        return c;
                
    }
    
    

    public boolean isIsIn() {
        return isIn;
    }

    public void setIsIn(boolean isIn) {
        this.isIn = isIn;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public Boolean[] getVisited() {
        return visited;
    }

    public void setVisited(int i) {
        visited[i] = true;
    }

    public boolean visitedAll() {
        boolean bo = true;

        for (boolean b : visited) {
            if (b == false) {
                return false;
            }
        }

        return bo;
    }

    public boolean visitedAny() {
        boolean bo = false;
        for (boolean b : visited) {
            if (b == true) {
                return true;
            }
        }
        
        return bo;
    }

    public boolean canGo(Cell c) {
        if (c == null) {
            return false;
        }
        if (c.visitedAll()) {
            return false;
        }
        if (c.size - 1 == this.size) {
            return true;
        }
        return c.size == this.size;

    }

    public String getInfo() {
        char c = (char) size;
        String chS = String.valueOf(c);
        return "" + chS + " || x :" + x + " y: " + y;
    }

    @Override
    public String toString() {
        if (isIn) {
            return "S";
        }
        if (end) {
            return "E";
        }
        if (visitedAny()) {
            return ".";
        }
        if (visitedAll()) {
            return "#";
        }
        
        char c = (char) size;
        return String.valueOf(c);

    }

}
