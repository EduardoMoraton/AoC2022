/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2022_05_1;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author macbook-edu
 */
public class Boat {

    private int id;
    private ArrayList<ArrayList<Container>> stacks;
    private int stackConunt;

    public Boat(int sc) {
        this.stacks = new ArrayList<ArrayList<Container>>();
        this.stackConunt = sc;
        for (int i = 0; i < stackConunt; i++) {
            this.add(new ArrayList<Container>());
        }
    }

    public void add(ArrayList<Container> c) {
        stacks.add(c);
    }

    public ArrayList<ArrayList<Container>> getStacks() {
        return stacks;
    }

    public void setStacks(ArrayList<ArrayList<Container>> stacks) {
        this.stacks = stacks;
    }
    
    public void reverse() {
        for (ArrayList<Container> arr: stacks) {
            Collections.reverse(arr);
        }
    }

    public void move(int quantity, int id, int id_dest) {
        ArrayList<Container> moveFrom = stacks.get(id - 1);
        ArrayList<Container> moveTo = stacks.get(id_dest - 1);
        ArrayList<Container> buffer;
        
        
        
        buffer = new ArrayList<>(moveFrom.subList(moveFrom.size()-quantity, moveFrom.size()));
        
        System.out.println("buffer: " + buffer);
        System.out.println("from: " + moveFrom);
        //Collections.reverse(buffer);
        for (Container c : buffer) {
            moveTo.add(c);
            moveFrom.remove(c);
        }
        
    }

    public void show() {
        int id = 1;
        
        for (ArrayList<Container> arr : this.stacks) {
            System.out.print(id);
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i));
            }
            System.out.println("");
            id ++;
        }
    }
    
    public String getString() {
        String str ="";
        for (ArrayList<Container> arr : this.stacks) {
            str += arr.get(arr.size()-1).getContent();
        }
        
        return str;
    }

}
