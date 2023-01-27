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
public class Cluster {

    private ArrayList<String> rutStrings = new ArrayList<>();
    private ArrayList<Character> commonItems = new ArrayList<>();
    private Integer prioritySum = 0;

    public Cluster(String str1, String str2, String str3) {
        rutStrings.add(str1);
        rutStrings.add(str2);
        rutStrings.add(str3);
        findCommonItems();
        findPrioritySum();

    }

    private void findCommonItems() {
        for (int i = 0; i < rutStrings.get(0).toCharArray().length; i++) {
            char ch1 = rutStrings.get(0).toCharArray()[i];
            for (int j = 0; j < rutStrings.get(1).toCharArray().length; j++) {
                char ch2 = rutStrings.get(1).toCharArray()[j];
                for (int k = 0; k < rutStrings.get(2).toCharArray().length; k++) {
                    char ch3 = rutStrings.get(2).toCharArray()[k];

                    if (ch1 == ch2) {
                        if (ch2 == ch3) {
                            if (!commonItems.contains(ch3)) {
                                commonItems.add(ch3);
                            }
                        }
                    }
                }
            }
        }

    }

    private void findPrioritySum() {
        for (char c : commonItems) {
            int currPrior = 0;
            int asciiIndex = (int) c;
            if (asciiIndex > 97) {
                currPrior = asciiIndex - 97 + 1;
            } else {
                currPrior = asciiIndex - 65 + 27;
            }

            System.out.println(currPrior);

            prioritySum += currPrior;
        }
    }

    public ArrayList<String> getRutStrings() {
        return rutStrings;
    }

    public void setRutStrings(ArrayList<String> rutStrings) {
        this.rutStrings = rutStrings;
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
    
    
    

    @Override
    public String toString() {
        return "Cluster{" + "rutStrings=" + rutStrings + ", commonItems=" + commonItems + ", prioritySum=" + prioritySum + '}';
    }

}
