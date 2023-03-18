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
    
}
