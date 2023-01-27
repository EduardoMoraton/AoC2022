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
    
    private int checkLeft() {
        boolean wasVisible = true;
        int score = 0;

        for (int x = this.xPos-1; x >= 0; x--) {
            Tree compTree = trees.get(this.yPos).get(x);
            if (wasVisible) {
                score ++;
            }
            if (this.size <= compTree.getSize()) {
                wasVisible = false;
            }
        }
        
        return score;
        
    }
    
    private int checkRight() {
        boolean wasVisible = true;
        int score = 0;
        
        for (int x = this.xPos+1; x < trees.get(this.yPos).size(); x++) {
            Tree compTree = trees.get(this.yPos).get(x);
            
            if (wasVisible) {
                score ++;
            }
            
            if (this.size <= compTree.getSize()) {
                wasVisible = false;
            }
        }
        
        return score;
        
    }
    
    private int checkTop() {
        boolean wasVisible = true;
        int score = 0;
        
        for (int y = this.yPos-1; y >= 0; y--) {
            if (wasVisible) {
                score ++;
            }
            if (this.size <= trees.get(y).get(this.xPos).getSize()) {
                wasVisible = false;
            }
        }
        
        return score;
        
    }
    
    private int checkBottom() {
        boolean wasVisible = true;
        int score = 0;
        
        for (int y = this.yPos+1; y < trees.size(); y++) {
            if (wasVisible) {
                score ++;
            }
            if (this.size <= trees.get(y).get(this.xPos).getSize()) {
                wasVisible = false;
            }
        }
        
        return score;
        
    }
    
    public int score() {
        return checkLeft()  * checkTop() * checkRight() * checkBottom();
    }

    @Override
    public String toString() {
        return "[x: " + xPos + " " + "y " + yPos + "] " + size + " : "+ checkLeft() + ", " + checkTop() + ", " + checkRight() + ", " + checkBottom() + " score: " + score();
    }
    
    
    
}
