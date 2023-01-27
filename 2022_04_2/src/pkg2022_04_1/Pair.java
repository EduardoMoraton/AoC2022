/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2022_04_1;

/**
 *
 * @author macbook-edu
 */
public class Pair {
    private Section s1;
    private Section s2;
    private Boolean containsItSelf;
    private Boolean overlapsIt;

    public Pair(Section s1, Section s2) {
        this.s1 = s1;
        this.s2 = s2;
        containsItSelf = containsIt();
        overlapsIt = overlaps();
    }
    
    public Boolean contains(Pair p) {
        return p.getS1().contains(s2) && p.getS2().contains(s1);
    }
    
    public Boolean containsIt() {
        return s1.contains(s2) || s2.contains(s1);
    }

    public Section getS1() {
        return s1;
    }

    public void setS1(Section s1) {
        this.s1 = s1;
    }

    public Section getS2() {
        return s2;
    }

    public void setS2(Section s2) {
        this.s2 = s2;
    }

    public Boolean getContainsItSelf() {
        return containsItSelf;
    }

    public void setContainsItSelf(Boolean containsItSelf) {
        this.containsItSelf = containsItSelf;
    }

    public Boolean getOverlapsIt() {
        return overlapsIt;
    }

    public void setOverlapsIt(Boolean overlapsIt) {
        this.overlapsIt = overlapsIt;
    }
    
    
    

    @Override
    public String toString() {
        return "" + s1 + " || " + s2 + overlapsIt;
    }

    private Boolean overlaps() {
       return s1.overlap(s2);
    }
    
    
    
}
