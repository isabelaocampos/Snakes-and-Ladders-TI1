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


    public int throwDice(int n, int max, int turn) {

        Player player_turn = findP(player, turn);
        return throwDice(n, max, player_turn);
    }

    private int throwDice(int n, int max, Player player) {

        int new_position = player.getSquare() + n;
        if (new_position == max) {
            return -1;
        } else if (new_position > max) {
            return -2;
        } else {
            return new_position;
        }
    
    }

    public Player findP(Player player, int n) {
        if (player != null && player.getTurn() == n) {
            return player;
        } else {
            return findP(player.getNextP(), n);
        }
    }

    public String setPosition(int n, int turn) {
        Player player_turn = findP(player, turn);
        player_turn.setSquare(n);
        return "Player has moved";
    }
    
}
