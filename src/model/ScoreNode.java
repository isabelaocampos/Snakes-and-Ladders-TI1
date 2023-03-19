package model;

public class ScoreNode {

    private String name;
    private double score;
    private ScoreNode left;
    private ScoreNode right;

    public ScoreNode(String name, Double score) {
        this.name = name;
        this.score = score;
    }

    public void setScore(Double score) {
		this.score = score;
	}

	public double getScore() {
		return score;
	}

	public ScoreNode getRight() {
		return right;
	}

	public void setRight(ScoreNode right) {
		this.right = right;
	}

	public ScoreNode getLeft() {
		return left;
	}

	public void setLeft(ScoreNode left) {
		this.left = left;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
    
