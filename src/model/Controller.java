package model;

public class Controller {

    private Grid grid;



    public void addPlayers(){
        
    }

    public Player addPlayer1(String id){

        Player player1 = new Player("#");
        return player1;
    }

    public Player addPlayer2(String id){
        Player player2 = new Player("!");
        return player2;
    }

    public Player addPlayer3(String id){
        Player player3 = new Player("*");
        return player3;
    }


    public String createGame(int nRow, int nColumn, int snakes, int ladders){
        String msg = " ";

        if(snakes * ladders > nColumn * nRow){
            msg = "There cannot be more snakes and ladders than boxes in the game, try again";
        }if(snakes > 15 ||ladders > 15){
            msg = "We have a limit of ladders and stairs, please try again. Input a number lower than 15 in both cases";      
        }else{
            grid = new Grid(nRow,nColumn,snakes,ladders);
            msg = "Grid created";
            grid.createGrid();
        }

        return msg;
    }
    

    
    public Player playerPosition(int val){

        
        Player player = null;


        return player;
    }
}
