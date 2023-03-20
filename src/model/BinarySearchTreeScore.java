package model;

public class BinarySearchTreeScore {
    private ScoreNode head;
    

    public BinarySearchTreeScore(){
        this.head = null;
    }

    public ScoreNode getHead(){
        return head;
    }

    public void addScoreNode(ScoreNode sNode){
        if(head == null){
            head = sNode;
            
        }else{
            insert(sNode, head);   
        }
    }

    private void insert(ScoreNode sNode, ScoreNode current) {
		// Izquierda
		if (sNode.getScore() < current.getScore()) {
			if (current.getLeft() == null) {
				current.setLeft(sNode);
			} else {
				insert(sNode, current.getLeft());
			}
		}
		// Derecha
		else if (sNode.getScore() > current.getScore()) {
			if (current.getRight() == null) {
				current.setRight(sNode);
			} else {
				insert(sNode, current.getRight());
			}
		} else {
			// los nodos son iguales
		}
	}



    public String inOrderString(){
		return "[" + inOrderString(head) + "]"; 
	}

	private String inOrderString(ScoreNode current){
		if(current == null){
			return ""; 
		}

		return inOrderString(current.getLeft()) + " " + current.getScore() + " " + inOrderString(current.getRight()); 
	}


	public void printPodium(){
		printPodium(head); ; 
	}

    private void printPodium(ScoreNode node) {
		// Primero, encontrar el jugador con la puntuación más alta
		ScoreNode maxNode = node;
		int count = 0;
    	while (maxNode != null && count < 3) {
        System.out.println(maxNode.getPlayer() + ": " + maxNode.getScore());
        remove(maxNode.getScore());
        maxNode = findMax(head);
        count++;
	    }
	
	
		// Imprimir el jugador en primer lugar
		System.out.println("1st Place: " + maxNode.getName() + " - " + maxNode.getScore());
	
		// Luego, encontrar el jugador con la segunda puntuación más alta
		ScoreNode secondMaxNode = null;
		if (maxNode.getLeft() != null) {
			secondMaxNode = maxNode.getLeft();
			while (secondMaxNode.getRight() != null) {
				secondMaxNode = secondMaxNode.getRight();
			}
		}
	
		// Imprimir el jugador en segundo lugar
		if (secondMaxNode != null) {
			System.out.println("2nd Place: " + secondMaxNode.getName() + " - " + secondMaxNode.getScore());
	
			// Finalmente, imprimir el jugador en tercer lugar
			if (secondMaxNode.getLeft() != null) {
				ScoreNode thirdMaxNode = secondMaxNode.getLeft();
				System.out.println("3rd Place: " + thirdMaxNode.getName() + " - " + thirdMaxNode.getScore());
			}
		}
	}

	private ScoreNode findMax(ScoreNode node) {
		if (node == null) {
			return null;
		} else if (node.getRight() == null) {
			return node;
		} else {
			return findMax(node.getRight());
		}





}
