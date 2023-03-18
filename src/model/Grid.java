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
    public void addLadders(int create){
        if(create <= snakes){
            int pos  = randomNumber(nRow *nColumn);
            int pos2 = randomNumber(nRow * nColumn);
            if(pos == pos2 || pos ==1 || pos2 == 1 || pos == nRow *nColumn || pos2 == nRow*nColumn){
                addSnakes(create);
            }else{
                Node node = getNode(goal, pos);
                Node node2 = getNode(node, pos2);
                if(node.allTributesNull() == 0 && node2.allTributesNull() == 0){
                    node.createTheLadder(create);
                    node2.createTheLadder(create);
                    addSnakes(++create);
                }else{
                    addSnakes(create);
                }
            }
        }
    }

    private int findLadder(int num, Node pointer,Node value ){
        if(pointer.getLadder() != null && pointer.getNumberStair() == num && pointer !=value){
            return pointer.getValue();
        }else{
            return findLadder(num, pointer.getNext(), value);
        }
    }

    private int findSnake(String symbol, Node pointer, Node value){
        if(pointer.getSnake() != null && pointer.getSymbolOfSnake().equalsIgnoreCase(symbol) && pointer != value){
            return pointer.getValue();
        } else{
            return findSnake(symbol, pointer.getNext(), value);
        }
    }

    public String gridSL(int n){
        String list = "";

        return gridSL(node, list, n);
    }

    public String gridSL(Node pointer, String list, int n){
        if(pointer == null){
            return null;
        }
        if (pointer.getValue() == n){
            if(pointer.getSnake() != null){
                return list += pointer.getSymbolOfSnake();
            }else if(pointer.getLadder() != null){
                return list += pointer.getNumberStair();
            }else{
                return list;
            }
        }else{
            return gridSL(pointer.getNext(), list, n);
        }
    }

    public String grid(int n){
        String list ="";
        return grid(node,list, n);
    }
    

    public String grid(Node pointer, String list, int n){
        if(pointer == null){
            return null;
        }
        if(pointer.getValue() == n){
            list += "[" + pointer.getValue();
            return list;
        }else{
            return grid(pointer.getNext(), list, n);
        }
    }

    public int slPosition(int n){
        return slPosition(n, node);
    }

    private int slPosition(int n, Node pointer){
        if(pointer.getValue() != n){
            return slPosition(n,pointer.getNext());
        }else{
            if(pointer.getSnake() != null){
                String symbol = pointer.getSymbolOfSnake();
                int posSnake = findSnake(symbol, node, pointer);
                if(posSnake < n){
                    return posSnake;
                }else{
                    return n;
                }
            }else if (pointer.getLadder() != null){
                int number = pointer.getNumberStair();
                int posLadder = findLadder(number, node, pointer);
                if(posLadder > n){
                    return posLadder;
                }else{
                    return n;
                }
            }else{
                return n;
            }
        }
    }

    public int position_Analysis(int n) {
		return position_Analysis(n, start);
	}

	private int position_Analysis(int n, Node pointer) {
		if (pointer.getValue() != n) {
			return position_Analysis(n, pointer.getNext());
		} else {
			if (pointer.getSnake() != null) {
				String symbol = pointer.getSymbolOfSnake();
				int position_other_Snake = searchSnake(symbol, start, pointer);
				if (position_other_Snake < n) {
					return position_other_Snake;
				} else {
					return n;
				}
			} else if (pointer.getLadder() != null) {
				int number = pointer.getNumberStair();
				int position_other_stair = searchStair(number, start, pointer);
				if (position_other_stair > n) {
					return position_other_stair;
				} else {
					return n;
				}
			} else {
				return n;
			}
		}
	}


    private int searchSnake(String symbol, Node pointer, Node val) {
		if (pointer.getSnake() != null && pointer.getSymbolOfSnake().equalsIgnoreCase(symbol) && pointer != val) {
			return pointer.getValue();
		} else {
			return searchSnake(symbol, pointer.getNext(), val);
		}
	}

	private int searchStair(int number, Node pointer, Node val) {
		if (pointer.getStair() != null && pointer.getNumberStair() == number && pointer != val) {
			return pointer.getValue();
		} else {
			return searchStair(number, pointer.getNext(), val);
		}
	}





    
}
