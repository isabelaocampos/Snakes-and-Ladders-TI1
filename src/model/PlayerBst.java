package model;

public class PlayerBst {
    private Player player;

    public PlayerBst(){
        this.player = null;

    }

    public void insert(String id, int turn, String symbol){
        insert(player, id, turn, symbol);
    }

    private void insert(Player pointer, String id, int turn, String symbol){
        Player node = new Player(id, turn, symbol);
        if(player == null){
            player = node;
        }if(pointer.getNextP() == null){
            pointer.setNextP(node);
        }else{
            insert(pointer.getNextP(), id, turn, symbol);
        }
    }

    public String turn(int n){
        return turn(n,player);
    }
    
    public String turn(int n, Player player){
        if(player != null && player.getTurn() == n){
            return "Player -" + player.getId() + "- it is your turn \n";
        }else{
            return turn(n, player.getNextP());
        }
    }

    public int endGame(int nRow, int nColumn){
        return endGame(player,nRow, nColumn,1);
    }

    private int endGame(Player player, int nRow, int nColumn,int counter ){
        if(counter > 3){
            return 0;
        }else if(player.getNode() == (nRow*nColumn) && counter <= 3){
            return -1;
        }else{
            return endGame(player.getNextP(), nRow, nColumn, ++counter);
        }
    }
    
}
