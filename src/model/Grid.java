package model;

public class Grid {

    private Node start;
    private Node goal;
    private int size;

    public Grid(){
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public Node getStart(){
        return start;
    }

    public Node getGoal(){
        return goal;
    }

    public void setSize(int size) {
        this.size = size;
    }

    
}
