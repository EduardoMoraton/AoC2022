/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2022_04_1;

import java.util.ArrayList;

/**
 *
 * @author macbook-edu
 */
public class Section {
    private String rootString;
    private Integer StartId;
    private Integer EndId;
    private ArrayList<Integer> fullIdSections = new ArrayList<>();
    
    public Section(String rootString) {
        this.rootString = rootString;
        StartId = Integer.valueOf(rootString.split("-")[0]);
        EndId = Integer.valueOf(rootString.split("-")[1]);
        for (int i = StartId; i <= EndId; i++) {
            fullIdSections.add(i);
        }
    }
    
    
    public Boolean contains(Section s) {
       return StartId <= s.getStartId() && EndId >= s.getEndId();
    }
    
    public Boolean overlap(Section s) {
       Boolean res = false;
       for (Integer n: fullIdSections) {
           for (Integer n2: s.getFullIdSections()) {
               if (n == n2)
                   res = true;
           }
       }
       return res;
    }

    public String getRootString() {
        return rootString;
    }

    public void setRootString(String rootString) {
        this.rootString = rootString;
    }

    public Integer getStartId() {
        return StartId;
    }

    public void setStartId(Integer StartId) {
        this.StartId = StartId;
    }

    public Integer getEndId() {
        return EndId;
    }

    public void setEndId(Integer EndId) {
        this.EndId = EndId;
    }

    public ArrayList<Integer> getFullIdSections() {
        return fullIdSections;
    }

    public void setFullIdSections(ArrayList<Integer> fullIdSections) {
        this.fullIdSections = fullIdSections;
    }

    @Override
    public String toString() {
        return fullIdSections.toString();
    }
    
    
    
    
}
