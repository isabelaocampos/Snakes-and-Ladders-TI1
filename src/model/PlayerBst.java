package model;

public class PlayerBst {
    private Player player;

    public PlayerBst(){
        this.player = null;

    }

    public void insert(String id, int turn){
        insert(player, id, turn);
    }

    private void insert(Player pointer, String id, int turn){
        Player node = new Player(id, turn);
        if(player == null){
            player = node;
        }if(pointer.getNextP() == null){
            pointer.setNextP(node);
        }else{
            insert(pointer.getNextP(), id, turn);
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
        }else if(player.)
    }
}
