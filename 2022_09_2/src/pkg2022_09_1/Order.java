/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2022_09_1;

/**
 *
 * @author macbook-edu
 */
public class Order {

    private Dir direcction;
    private int steps;

    public Order(String d, int steps) {

        switch (d) {
            case "U":
                direcction = Dir.UP;
                break;
            case "D":
                direcction = Dir.DOWN;
                break;
            case "R":
                direcction = Dir.RIGHT;
                break;
            default : 
                direcction = Dir.LEFT;

        }

        this.steps = steps;
    }

    public Dir getDirecction() {
        return direcction;
    }

    public void setDirecction(Dir direcction) {
        this.direcction = direcction;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "Order{" + "direcction=" + direcction + ", steps=" + steps + '}';
    }

}
