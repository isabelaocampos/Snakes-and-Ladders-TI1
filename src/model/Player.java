package model;

public class Player {
    
    private String id;
    private Player nextP;
    private int turn;

    public Player(String id, int turn){
        this.id = id;
        this.turn = turn;

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

	

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
    
}