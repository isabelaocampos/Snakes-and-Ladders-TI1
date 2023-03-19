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
        }else if(player.getSquare() == (nRow*nColumn) && counter <= 3){
            return -1;
        }else{
            return endGame(player.getNextP(), nRow, nColumn, ++counter);
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

    public String inOrderToString(){
        return "[" + inOrderToString() + "]";
    }

    public String printPlayer(int position) {
        String msg = "";
        return printPlayer(position, player, msg, 1);
    }

    public String printPlayer(int postion, Player player, String msg, int counter) {
        if (player != null && player.getSquare() == postion && counter <= 3) {
            msg += player.getId();
            return printPlayer(postion, player.getNextP(), msg, ++counter);

        } else if (counter <= 3) {
            return printPlayer(postion, player.getNextP(), msg, ++counter);
        } else {
            return msg;
        }

    }

    private String inOrderToString(ScoreNode current){
        if(current == null){
            return "";
        }

        return inOrderToString(current.getNext()) + "," + "Player: " + current.getName() + "Score: " + current.getScore() + ", " + inOrderToString(current.getPrevious());
    }
    
}
