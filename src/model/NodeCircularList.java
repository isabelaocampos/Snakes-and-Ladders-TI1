package model;

public class NodeCircularList {

    private int name;
    private NodeCircularList next;
    private NodeCircularList previous;

    public NodeCircularList(int name) {
        this.name = name;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public NodeCircularList getNext() {
        return next;
    }

    public void setNext(NodeCircularList next) {
        this.next = next;
    }

    public NodeCircularList getPrevious() {
        return previous;
    }

    public void setPrevious(NodeCircularList previous) {
        this.previous = previous;
    }

    @Override
	public String toString(){
		return "" +  name; 
	}
}
    
