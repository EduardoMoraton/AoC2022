/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2022_03_1;

import java.util.ArrayList;

/**
 *
 * @author macbook-edu
 */
public class Rucksack {

    private String fullList;
    private String firstHalf;
    private String secondHalf;
    private ArrayList<Character> commonItems = new ArrayList<>();
    private Integer prioritySum = 0;

    public Rucksack(String fullList) {
        this.fullList = fullList;
        fillLists();
        findCommonItems();
        if (commonItems != null) {
            findPrioritySum();
        } else {
            prioritySum = 0;
        }
    }

    private void fillLists() {
        firstHalf = fullList.substring(0, fullList.length() / 2);
        secondHalf = fullList.substring(fullList.length() / 2, fullList.length());
    }

    @Override
    public String toString() {
        return "Rucksack{" + "fullList=" + fullList + ", firstHalf=" + firstHalf + ", secondHalf=" + secondHalf + ", commonItems=" + commonItems + ", prioritySum=" + prioritySum + '}';
    }

    private void findCommonItems() {
        for (Character c : secondHalf.toCharArray()) {
            if (!commonItems.contains(c)) {
                if (firstHalf.contains(String.valueOf(c))) {
                    int index = firstHalf.indexOf(c);
                    commonItems.add(firstHalf.charAt(index));
                }
            }

        }

    }

    private void findPrioritySum() {
        for (char c : commonItems) {
            int currPrior = 0;
            int asciiIndex = (int)c;
            if (asciiIndex>97) {
               currPrior = asciiIndex-97+1;
            } else {
                currPrior = asciiIndex-65+27;
            }
            
            System.out.println(currPrior);
            
            prioritySum += currPrior;
        }
    }

    public String getFullList() {
        return fullList;
    }

    public void setFullList(String fullList) {
        this.fullList = fullList;
    }

    public String getFirstHalf() {
        return firstHalf;
    }

    public void setFirstHalf(String firstHalf) {
        this.firstHalf = firstHalf;
    }

    public String getSecondHalf() {
        return secondHalf;
    }

    public void setSecondHalf(String secondHalf) {
        this.secondHalf = secondHalf;
    }

    public ArrayList<Character> getCommonItems() {
        return commonItems;
    }

    public void setCommonItems(ArrayList<Character> commonItems) {
        this.commonItems = commonItems;
    }

    public Integer getPrioritySum() {
        return prioritySum;
    }

    public void setPrioritySum(Integer prioritySum) {
        this.prioritySum = prioritySum;
    }
    
    

}
