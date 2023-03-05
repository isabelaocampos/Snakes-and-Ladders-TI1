package model;

public class Player {
    
    private String id;
    private String positionOnGrid;
    private Player player1;
    private Player player2;
    private Player player3;

    public Player(String id){
        this.id = id;
    }

    public void setPlayer1(String id){
        this.player1 = player1;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPositionOnGrid(){
        return positionOnGrid;
    }

    public void setPositionOnGrid(String positionOnGrid){
        this.positionOnGrid = positionOnGrid;
    }
}