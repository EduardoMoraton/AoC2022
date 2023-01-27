/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classess;

/**
 *
 * @author macbook-edu
 */
public class Elf {
    private int elfNum;
    private int calNum;

    public Elf(int elfNum, int calNum) {
        this.elfNum = elfNum;
        this.calNum = calNum;
    }

    public int getElfNum() {
        return elfNum;
    }

    public void setElfNum(int elfNum) {
        this.elfNum = elfNum;
    }

    public int getCalNum() {
        return calNum;
    }

    public void setCalNum(int calNum) {
        this.calNum = calNum;
    }
    
    

    @Override
    public String toString() {
        return "Elf{" + "elfNum=" + elfNum + ", calNum=" + calNum + '}';
    }
    
    
}
