/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2022_05_1;

/**
 *
 * @author macbook-edu
 */
public class Container {
    private String content;

    public Container(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    

    @Override
    public String toString() {
        return " [" + content + "] ";
    }
    
    
}
