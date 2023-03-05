package model;

public class Player {
    
    private String id;
    private String positionOnGrid;

    public Player(String id){
        this.id = id;
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