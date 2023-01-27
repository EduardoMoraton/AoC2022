/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2022_13_1;

import java.util.ArrayList;

/**
 *
 * @author macbook-edu
 */
public class Packet {
    private ArrayList<Object> f = new ArrayList<>();
    private ArrayList<Object> s = new ArrayList<>();

    public Packet() {
    }

    public ArrayList<Object> getF() {
        return f;
    }

    public void setF(ArrayList<Object> f) {
        this.f = f;
    }

    public ArrayList<Object> getS() {
        return s;
    }

    public void setS(ArrayList<Object> s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "Packet{" + "f=" + f + ", s=" + s + '}';
    }
    
    
}
