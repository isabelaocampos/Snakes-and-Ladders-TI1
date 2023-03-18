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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore (){
        return score;
    }

    public void setScore(Double score){
        this.score = score;
    }

    public ScoreNode getNext() {
        return right;
    }

    public void setNext(ScoreNode right) {
        this.right = right;
    }

    public ScoreNode getPrevious() {
        return left;
    }

    public void setPrevious(ScoreNode left) {
        this.left = left;
    }

    @Override
	public String toString(){
		return "" +  name; 
	}
}
    
