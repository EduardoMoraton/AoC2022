/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2022_08_1;

import java.util.ArrayList;

/**
 *
 * @author macbook-edu
 */
public class Tree {
    private int xPos;
    private int yPos;
    private int size;
    private ArrayList<ArrayList<Tree>> trees;

    public Tree(int xPos, int yPos, int size, ArrayList<ArrayList<Tree>> trees) {
        this.trees = trees;
        this.xPos = xPos;
        this.yPos = yPos;
        this.size = size;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    private Boolean checkLeft() {
        Boolean visible = true;

        for (int x = this.xPos-1; x >= 0; x--) {
            Tree compTree = trees.get(this.yPos).get(x);
           
            if (this.size <= compTree.getSize()) {
                visible = false;
            }
        }
        
        return visible;
        
    }
    
    private Boolean checkRight() {
        Boolean visible = true;
        
        for (int x = this.xPos+1; x < trees.get(this.yPos).size(); x++) {
            Tree compTree = trees.get(this.yPos).get(x);
            if (this.size <= compTree.getSize()) {
                visible = false;
            }
        }
        
        return visible;
        
    }
    
    private Boolean checkTop() {
        Boolean visible = true;
        
        for (int y = this.yPos-1; y >= 0; y--) {
            if (this.size <= trees.get(y).get(this.xPos).getSize()) {
                visible = false;
            }
        }
        
        return visible;
        
    }
    
    private Boolean checkBottom() {
        Boolean visible = true;
        
        for (int y = this.yPos+1; y < trees.size(); y++) {
            if (this.size <= trees.get(y).get(this.xPos).getSize()) {
                visible = false;
            }
        }
        
        return visible;
        
    }
    
    public Boolean isVisible() {
        return checkLeft() || checkRight() || checkTop() || checkBottom();
    }

    @Override
    public String toString() {
        return "[x: " + xPos + " " + "y " + yPos + "] " + size + " : "+ checkLeft() + ", " + checkTop() + ", " + checkRight() + ", " + checkBottom();
    }
    
    
    
}
