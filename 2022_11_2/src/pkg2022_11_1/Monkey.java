/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2022_11_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author macbook-edu
 */
public class Monkey {

    private int id;
    private Queue<Double> items;
    private String operationString;
    private Double testDiv;
    private int MTrue;
    private int MFalse;
    private ArrayList<Monkey> mnks;
    private Double iteratedItems = 0d;

    public Monkey(int id, String operationString, Double testDiv, int MTrue, int MFalse) {
        this.id = id;
        this.operationString = operationString;
        this.testDiv = testDiv;
        this.MTrue = MTrue;
        this.MFalse = MFalse;

    }

    public Monkey() {
        items = new LinkedList<>();
    }

    public void add(Double i) {
        this.items.add(i);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Queue<Double> getItems() {
        return items;
    }

    public void setItems(Queue<Double> items) {
        this.items = items;
    }

    public String getOperationString() {
        return operationString;
    }

    public void setOperationString(String operationString) {
        this.operationString = operationString;
    }

    public Double getTestDiv() {
        return testDiv;
    }

    public void setTestDiv(Double testDiv) {
        this.testDiv = testDiv;
    }

    public int getMTrue() {
        return MTrue;
    }

    public void setMTrue(int MTrue) {
        this.MTrue = MTrue;
    }

    public int getMFalse() {
        return MFalse;
    }

    public void setMFalse(int MFalse) {
        this.MFalse = MFalse;
    }

    public ArrayList<Monkey> getMnks() {
        return mnks;
    }

    public void setMnks(ArrayList<Monkey> mnks) {
        this.mnks = mnks;
    }

    public Double getIteratedItems() {
        return iteratedItems;
    }

    public void setIteratedItems(Double iteratedItems) {
        this.iteratedItems = iteratedItems;
    }
    
    

    // --------------------
    public void turn() {
        Double curI;
        if (items.isEmpty())
            return;
        while (items.peek() != null) {
            System.out.println(this);
            iteratedItems ++;
            curI = items.poll();
            System.out.println("cur: " + curI);
            curI = this.operate(curI);
            System.out.println("afer op: " + curI);
            double div3 = curI;
            //curI = (Double)Math.floor(div3 / 3);
            System.out.println("afer div3: " + curI);
            System.out.println(curI + " is divisible to " + testDiv + "  " + (curI % this.testDiv == 0));
            if (curI % this.testDiv == 0) {
                System.out.println("thrown to " + MTrue);
                mnks.get(this.MTrue).add(curI); 
            } else {
                System.out.println("thrown to " + MFalse);
                mnks.get((int)this.MFalse).add(curI);
            }
        }
            

            

        
    }

    public Double operate(Double i) {
        String fOp = this.operationString.split(" ")[5];
        String sOp = this.operationString.split(" ")[7];

        Double fopI;
        Double sopI;

        if (fOp.equals("old")) {
            fopI = i;
        } else {
            fopI = Double.valueOf(fOp);
        }
        if (sOp.equals("old")) {
            sopI = i;
        } else {
            sopI = Double.valueOf(sOp);
        }

        if (this.operationString.split(" ")[6].equals("+")) {
            return sopI + fopI;
        } else {
            return sopI * fopI;
        }
    }

    @Override
    public String toString() {
        return "Monkey{" + "id=" + id + ", items=" + items + ", operationString=" + operationString + ", testDiv=" + testDiv + ", MTrue=" + MTrue + ", MFalse=" + MFalse + '}';
    }

}
