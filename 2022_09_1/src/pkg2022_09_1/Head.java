/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2022_09_1;

/**
 *
 * @author macbook-edu
 */
public class Head {
    int x;
    int y;

    public Head(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void moveLeft() {
        x --;
    }
    
    public void moveRight() {
        x ++;
    }
    
    public void moveUp() {
        y ++;
    }
    
    public void moveDown() {
        y --;
    }
    
    public void move(Dir d) {
        switch (d) {
            case UP -> moveUp();
            case DOWN -> moveDown();
            case RIGHT -> moveRight();
            default -> moveLeft();
        }
    }

    @Override
    public String toString() {
        return "H";
    }
    
    
}
