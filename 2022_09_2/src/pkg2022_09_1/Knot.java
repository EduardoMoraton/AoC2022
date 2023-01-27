/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2022_09_1;

import java.util.ArrayList;

/**
 *
 * @author macbook-edu
 */
public class Knot {

    private Knot head;
    private Knot tail;
    private Pos prevPos;
    private Pos pos;
    private String name;
    private ArrayList<Pos> log;
    public int moves = 0;

    public Knot(Knot head, Knot tail, Pos pos, ArrayList<Pos> log) {
        this.head = head;
        this.tail = tail;
        this.pos = pos;

        this.log = log;
    }

    public Knot getHead() {
        return head;
    }

    public void setHead(Knot head) {
        this.head = head;
    }

    public Knot getTail() {
        return tail;
    }

    public void setTail(Knot tail) {
        this.tail = tail;
    }

    public Pos getPos() {
        return pos;
    }

    public void setPos(Pos pos) {
        this.pos = pos;
        this.prevPos = new Pos(this.pos.x, this.pos.y);
    }

    public ArrayList<Pos> getLog() {
        return log;
    }

    public void setLog(ArrayList<Pos> log) {
        this.log = log;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void move(Dir d) {
        prevPos.x = pos.x;
        prevPos.y = pos.y;

        if (head == null) {
            System.out.println("ishead");
            pos.move(d);
            tail.move(d);
            return;
        }
        moveMe();

        if (tail == null) {
            log.add(new Pos(pos.x, pos.y));
            moves ++;
        } else {
            tail.move(d);
        }

    }

    private void moveMe() {
        if (this.pos.x - 2 == this.head.pos.x) {
            if (this.pos.y - 2 == this.head.pos.y) {
                this.pos.moveLeft();
                this.pos.moveDown();
                return;
            }
            if (this.pos.y - 1 == this.head.pos.y) {
                this.pos.moveLeft();
                this.pos.moveDown();
                return;
            }
            if (this.pos.y == this.head.pos.y) {
                this.pos.moveLeft();
                return;
            }
            if (this.pos.y + 1 == this.head.pos.y) {
                this.pos.moveUp();
                this.pos.moveLeft();
                return;
            }
            if (this.pos.y + 2 == this.head.pos.y) {
                this.pos.moveUp();
                this.pos.moveLeft();
                return;
            }
        }
        if (this.pos.x - 1 == this.head.pos.x) {
            if (this.pos.y - 2 == this.head.pos.y) {
                this.pos.moveLeft();
                this.pos.moveDown();
                return;
            }
            if (this.pos.y + 2 == this.head.pos.y) {
                this.pos.moveLeft();
                this.pos.moveUp();
                return;
            }
        }
        if (this.pos.x == this.head.pos.x) {
            if (this.pos.y - 2 == this.head.pos.y) {
                this.pos.moveDown();
                return;
            }
            if (this.pos.y + 2 == this.head.pos.y) {
                this.pos.moveUp();
                return;
            }
        }
        if (this.pos.x + 1 == this.head.pos.x) {
            if (this.pos.y - 2 == this.head.pos.y) {
                this.pos.moveRight();
                this.pos.moveDown();
                return;
            }
            if (this.pos.y + 2 == this.head.pos.y) {
                this.pos.moveRight();
                this.pos.moveUp();
                return;
            }
        }
        if (this.pos.x + 2 == this.head.pos.x) {
            if (this.pos.y - 2 == this.head.pos.y) {
                this.pos.moveRight();
                this.pos.moveDown();
                return;
            }
            if (this.pos.y - 1 == this.head.pos.y) {
                this.pos.moveRight();
                this.pos.moveDown();
                return;
            }
            if (this.pos.y == this.head.pos.y) {
                this.pos.moveRight();
                return;
                
            }
            if (this.pos.y + 1 == this.head.pos.y) {
                this.pos.moveUp();
                this.pos.moveRight();
                return;
            }
            if (this.pos.y + 2 == this.head.pos.y) {
                this.pos.moveUp();
                this.pos.moveRight();
                return;
                
            }

        }
    }

    @Override
    public String toString() {
        if (head == null) {
            return "Knot{" + "head=" + "null" + ", tail=" + tail.name + ", pos=" + pos + ", name=" + name;
        }
        if (tail == null) {
            return "Knot{" + "head=" + head.name + ", tail=" + "null" + ", pos=" + pos + ", name=" + name;
        }
        if (tail.name == null && head.name == null) {
            return "Knot{" + "head=" + "null" + ", tail=" + "null" + ", pos=" + pos + ", name=" + name;
        }
        return "Knot{" + "head=" + head.name + ", tail=" + tail.name + ", pos=" + pos + ", name=" + name;
    }

}
