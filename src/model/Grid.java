package model;
import java.util.Random;

public class Grid {

    private Node start;
    private Node goal;
    private int size;
    private int nRow;
    private int nColumn;
    private int snakes;
    private int ladder;

   

    public Grid(int nRow, int nColumn, int snakes, int ladder) {
		this.nRow = nRow;
		this.nColumn = nColumn;
		this.snakes = snakes;
		this.ladder = ladder;
		start = null;
	}

    public int getNrow(){
        return nRow;
    }

    public void setNrow(){
        this.nRow = nRow;
    }

    public int getNcolumn(){
        return nColumn;
    }

    public void setNcolumn(){
        this.nColumn = nColumn;
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
    
    public int getSnakes() {
		return snakes;
	}

	public void setSnakes(int snakes) {
		this.snakes = snakes;
	}

	public int getLadders() {
		return ladder;
	}

	public void setLadders(int ladder) {
		this.ladder = ladder;
	}

    public void setSize(int size) {
        this.size = size;
    }

    public void createGrid(){
        int size = nColumn * nRow;
        createGrid(null, size);
    }

    private Node createGrid(Node pointer, int size){
        if(size == 1){
            start = new Node(1);
            return start;
        }else{
            pointer= createGrid(pointer, size-1);
            Node newNode = new Node(size);
            pointer.setNext(newNode);
            return newNode;
        }

    }
    
}
