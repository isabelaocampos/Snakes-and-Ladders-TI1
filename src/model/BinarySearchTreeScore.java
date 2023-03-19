package model;

public class BinarySearchTreeScore {
    private ScoreNode head;
    

    public BinarySearchTreeScore(){
        this.head = null;
    }

    public ScoreNode getHead(){
        return head;
    }

    public void addScoreNode(ScoreNode playerNode){
        if(head == null){
            head = playerNode;
            
        }else{
            insert(playerNode, head);   
        }
    }

    private void insert(ScoreNode playerNode, ScoreNode current) {
		if (playerNode.getScore() < current.getScore()) {
			if (current.getLeft() == null) {
				current.setLeft(playerNode);
			} else {
				insert(playerNode, current.getLeft());
			}
		}
		else if (playerNode.getScore() > current.getScore()) {
			if (current.getRight() == null) {
				current.setRight(playerNode);
			} else {
				insert(playerNode, current.getRight());
			}
		} else {
			
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
