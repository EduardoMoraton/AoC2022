/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2022_11_1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author macbook-edu
 */
public class Monkey {

    private int id;
    private Queue<BigInteger> items;
    private String operationString;
    private int testDiv;
    private int MTrue;
    private int MFalse;
    private ArrayList<Monkey> mnks;
    private int iteratedItems = 0;

    public Monkey(int id, String operationString, int testDiv, int MTrue, int MFalse) {
        this.id = id;
        this.operationString = operationString;
        this.testDiv = testDiv;
        this.MTrue = MTrue;
        this.MFalse = MFalse;

    }

    public Monkey() {
        items = new LinkedList<>();
    }

    public void add(BigInteger i) {
        this.items.add(i);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Queue<BigInteger> getItems() {
        return items;
    }

    public void setItems(Queue<BigInteger> items) {
        this.items = items;
    }

    public String getOperationString() {
        return operationString;
    }

    public void setOperationString(String operationString) {
        this.operationString = operationString;
    }

    public int getTestDiv() {
        return testDiv;
    }

    public void setTestDiv(int testDiv) {
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

    public int getIteratedItems() {
        return iteratedItems;
    }

    public void setIteratedItems(int iteratedItems) {
        this.iteratedItems = iteratedItems;
    }
    
    

    // --------------------
    public void turn() {
        BigInteger curI;
        if (items.isEmpty())
            return;
        while (items.peek() != null) {
            //System.out.println(this);
            iteratedItems ++;
            curI = items.poll();
            //System.out.println("cur: " + curI);
            curI = this.operate(curI);
            //System.out.println("afer op: " + curI);
            //curI = (Double)Math.floor(div3 / 3);
            //System.out.println("afer div3: " + curI);
            curI = curI.mod(BigInteger.valueOf(2 * 7 * 13 * 3 * 19 * 5 * 17 * 11));
            if (curI.mod(BigInteger.valueOf(testDiv)).equals(BigInteger.valueOf(0))) {
                //System.out.println("thrown to " + MTrue);
                mnks.get(this.MTrue).add(curI); 
            } else {
                //System.out.println("thrown to " + MFalse);
                mnks.get(this.MFalse).add(curI);
            }
            //System.out.println("------");
        }
            

            

        
    }

    public BigInteger operate(BigInteger i) {
        String fOp = this.operationString.split(" ")[5];
        String sOp = this.operationString.split(" ")[7];

        BigInteger fopI;
        BigInteger sopI;

        if (fOp.equals("old")) {
            fopI = i;
        } else {
            fopI = new BigInteger(fOp);
        }
        if (sOp.equals("old")) {
            sopI = i;
        } else {
            sopI = new BigInteger(sOp);
        }

        if (this.operationString.split(" ")[6].equals("+")) {
            return sopI.add(fopI);
        } else {
            return sopI.multiply(fopI);
        }
    }

    @Override
    public String toString() {
        return "Monkey{" + "id=" + id + ", items=" + items + ", operationString=" + operationString + ", testDiv=" + testDiv + ", MTrue=" + MTrue + ", MFalse=" + MFalse + '}';
    }

}
