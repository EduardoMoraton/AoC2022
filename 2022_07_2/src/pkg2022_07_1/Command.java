/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2022_07_1;

import java.util.ArrayList;

/**
 *
 * @author macbook-edu
 */
public class Command {
    String commandStr;
    ArrayList<Dir> dirs;
    
    public enum Type {
        CD, LS
    }
    
    private Type type;
    
    public Command(String commandStr, ArrayList<Dir> dirs) {
        this.dirs = dirs;
        this.commandStr = commandStr;
        if (commandStr.split(" ")[1].equals("cd")) {
            type = Type.CD;
        } else
            type = Type.LS;
        
    }
    
    
    public Dir execute() {
        Dir res = null;
        
        if (type == Type.CD) {
            for (Dir d: dirs) {
                if (d.getName().equals(commandStr.split(" ")[2])) {
                    res = d;
                }
            }
        }
        
        return res;
    }
}
