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

    public int getNcolumn(){
        return nColumn;
    }


    public int getSize() {
        return size;
    }

    public Node getStart(){
        return start;
    }

    public void setStart(Node start){
        this.start = start;
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
        }else if(pointer.getNext() == null){
            return null;
        }else{
            return getNode(pointer.getNext(), pos);
        }
    }
    

    public void addSnakes(int create){
        if(create <= snakes){
            int pos1 = randomNumber(nColumn * nRow);
            int pos2 = randomNumber(nColumn * nRow);
    
            if(pos1 == pos2 || pos1 == 1 || pos2 == 1 || pos1 == nRow * nColumn || pos2 == nColumn * nRow){
                addSnakes(create);
            }else{
                String letter = getLetter(create);
                Node node1 = getNode(node, pos1);
                Node node2 = getNode(node, pos2);
    
                // Verificar si `getNode` devuelve un nodo válido
                if (node1 == null || node2 == null) {
                    System.out.println("getNode returned a null node");
                    addSnakes(create);
                    return;
                }
    
                System.out.println("Node1: " + node1 + ", Node2: " + node2);
    
                if(node1.allTributesNull() == 0 && node2.allTributesNull() == 0){
                    node1.createTheSnake(letter);
                    node2.createTheSnake(letter);
    
                    addSnakes(create + 1);
                }else{
                    addSnakes(create);
                }
            }
        }
    }
    
    
    
    
    public void addLadders(int create){
        if(create <= ladder){
            int pos  = randomNumber(nRow *nColumn);
            int pos2 = randomNumber(nRow * nColumn);
            if(pos == pos2 || pos ==1 || pos2 == 1 || pos == nRow *nColumn || pos2 == nRow*nColumn){
                addLadders(create);
            }else{
                Node node = getNode(start, pos);
                Node node2 = getNode(start, pos2);
                if(node.allTributesNull() == 0 && node2.allTributesNull() == 0){
                    node.createTheLadder(create);
                    node2.createTheLadder(create);
                    create++; // Incrementa el contador de escaleras agregadas
                    addLadders(create);
                }else{
                    addLadders(create);
                }
            }
        } else {
            // Se han agregado todas las escaleras necesarias, salir del ciclo recursivo
            return;
        }
    }

    private int findLadder(int num, Node pointer,Node value ){
        if(pointer.getLadder() != null && pointer.getLadderNumber() == num && pointer !=value){
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

        return gridSL(start, list, n);
    }

    public String gridSL(Node pointer, String list, int n){
        if(pointer == null){
            return null;
        }
        if (pointer.getValue() == n){
            if(pointer.getSnake() != null){
                return list += pointer.getSymbolOfSnake();
            }else if(pointer.getLadder() != null){
                return list += pointer.getLadderNumber();
            }else{
                return list;
            }
        }else{
            return gridSL(pointer.getNext(), list, n);
        }
    }

    public String grid(int n){
        String list ="";
        return grid(start,list, n);
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

    public int slPosition(int new_position){
        return slPosition(new_position, node);
    }

    private int slPosition(int new_position, Node pointer){
        if (pointer == null) {
            return new_position;
        }
        if (pointer.getValue() != new_position){
            return slPosition(new_position, pointer.getNext());
        }else{
            if(pointer.getSnake() != null){
                if (pointer.getSnake().getSymbol() == null) {
                    return new_position;
                }
                String symbol = pointer.getSymbolOfSnake();
                System.out.println(symbol);
                int posSnake = findSnake(symbol, node, pointer);
                if(posSnake < new_position){
                    return posSnake;
                }else{
                    return new_position;
                }
            }else if (pointer.getLadder() != null){
                int number = pointer.getLadderNumber();
                int posLadder = findLadder(number, node, pointer);
                if(posLadder > new_position){
                    return posLadder;
                }else{
                    return new_position;
                }
            }else{
                return new_position;
            }
        }
    }








    
}
