package model;

public class Player {
    
    private String id;
    private Player nextP;
    private int turn;
    private int node;
    private String symbol;

    public Player(String id, int turn, String symbol){
        this.id = id;
        this.turn = turn;
        this.symbol = symbol;
        this.node = 1;

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

    public int getNode(){
        return node;
    }
    public void setCase(int Case){
        this.node = node;
    }

	

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
    
}