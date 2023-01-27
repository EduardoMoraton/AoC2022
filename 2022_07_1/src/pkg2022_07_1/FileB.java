/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2022_07_1;

/**
 *
 * @author macbook-edu
 */
public class FileB {
    private int size;
    private String name;
    private String extension;

    public FileB(String str) {
        System.out.println(str.split(" ")[1]);
        size = Integer.parseInt(str.split(" ")[0]);
        name = str.split(" ")[1];

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "_ " + name + " (file, size: " + size +" )";
    }
    
    
}
