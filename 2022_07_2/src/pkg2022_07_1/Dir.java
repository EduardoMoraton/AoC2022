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
public class Dir {
    private Dir parent;
    private ArrayList<Dir> dirs;
    private ArrayList<FileB> files;
    private String name;
    
    public Dir(String name, Dir parent) {
        this.name = name;
        this.parent = parent;
        dirs = new ArrayList<>();
        files = new ArrayList<>();
    }
    
    public void addDir(Dir d) {
        dirs.add(d);
    }
    
    public void addFile(FileB f) {
        files.add(f);
        
    }

    public ArrayList<Dir> getDirs() {
        return dirs;
    }

    public void setDirs(ArrayList<Dir> dirs) {
        this.dirs = dirs;
    }

    public ArrayList<FileB> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<FileB> files) {
        this.files = files;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dir getParent() {
        return parent;
    }

    public void setParent(Dir parent) {
        this.parent = parent;
    }
    
    
    
    
    public void show(String indent) {
        System.out.println(indent + this);
        for (FileB f: files) {
            System.out.println(indent +"|" +f);
        }
        for (Dir d: dirs) {
            d.show(indent + "  ");
        }

        

    }
    
    public Dir change(String name) {
        Dir res = parent;
        for (Dir d : dirs) {
            if (d.getName().equals(name)) {
                res = d;
            }
        }
        
        return res;
    }
    
    public int getSize() {
        int size = 0;
        for (Dir d: dirs) {
            size += d.getSize();
        }
        for (FileB f: files) {
            size += f.getSize();
        }
        
        return size;
    }

    @Override
    public String toString() {
        return "- " + name + " (dir)" + "size: " + this.getSize();
    }
    
    
    
    
}
