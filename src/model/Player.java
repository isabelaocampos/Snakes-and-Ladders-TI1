package model;

public class Player {
    
    private String id;
    private Player nextP;
    private int turn;
    private int square;

    public Player(String id, int turn, String symbol){
        this.id = id;
        this.turn = turn;
        this.square = 1;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Player getNextP() {
		return nextP;
	}

	public void setNextP(Player nextP) {
		this.nextP = nextP;
	}

	public int getSquare(){
        return square;
    }

    public void setSquare(int square){
        this.square = square;
    }

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
    
}