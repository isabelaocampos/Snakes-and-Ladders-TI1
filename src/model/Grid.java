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

   private Node node;

   private Node tail;
   

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

    public int randomNumber(int n){
        Random random = new Random();
        return random.nextInt(n)+ 1;
    }
    public String getLetter(int numero){
        int codeAs= 'A' + numero -1;
        return Character.toString((char) codeAs);
    }

    public Node getNode(Node pointer, int pos){
        if(pointer == null){
            return null;

        }else if(pointer.getValue() == pos){
            return pointer;

        }else{
            return getNode(pointer.getNext(), pos);
        }
    }

    public void addSnakes(int create){
        int attempts = 0;
        int maxAttemps = 100;
        while (create <= snakes){
            if(attempts > maxAttemps){
                return;
            }
            int pos = randomNumber(nRow*nColumn);
            int pos2 = randomNumber(nRow * nColumn );

            if(pos == pos2 || pos == 1 || pos2 == 1 || pos == nRow * nColumn || pos2 == nRow * nColumn){
                continue;
            }
            String letter = getLetter(create);
            Node node = getNode(start, pos);
            Node node2 = getNode(start, pos2);
            if(node.allTributesNull() == 0  && node2.allTributesNull() == 0){
                node.createTheSnake(letter);
                node2.createTheSnake(letter);
                create++;
                attempts = 0;
            }else{
                attempts++;
            }
        }
    }



    
}
