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
		if (head == null) {
			return "[]";
		}
		return "[" + inOrderString(head) + "]";
	}
	
	private String inOrderString(ScoreNode current) {
		if (current == null) {
			return "";
		}
	
		String leftString = inOrderString(current.getLeft());
		String rightString = inOrderString(current.getRight());
	
		String nodeString = "";
		if (!leftString.isEmpty()) {
			nodeString += leftString + " ";
		}
		nodeString += current.getScore();
		if (!rightString.isEmpty()) {
			nodeString += " " + rightString;
		}
	
		return nodeString;
	}
	

	


}
