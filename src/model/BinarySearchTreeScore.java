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



    public String inOrderString() {
		return "[" + inOrderString(head) + "]";
	}

	private String inOrderString(ScoreNode current) {
		if (current == null) {
			return "";
		}

		return inOrderString(current.getRight()) + ",  " + "jugador: " + current.getName() + " puntaje: "
				+ current.getScore() + " , " + inOrderString(current.getLeft());
	}

    





}
