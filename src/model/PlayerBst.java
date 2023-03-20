package model;



public class PlayerBst {
    private Player root;
    private BinarySearchTreeScore bstScore;

    public PlayerBst(){
        this.root = null;
        bstScore = new BinarySearchTreeScore();

    }

    public void insert(String id, int turn){
        insert(root, id, turn);
    }

    private void insert(Player pointer, String id, int turn){
        Player node = new Player(id, turn);
        if(root == null){
            root = node;
        }else if(pointer.getNextP() == null){
            pointer.setNextP(node);
        }else{
            insert(pointer.getNextP(), id, turn);
        }
    }

    public String turn(int n){
        return turn(n,root);
    }
    
    public String turn(int n, Player player){
        if(player != null && player.getTurn() == n){
            return "Player " + player.getId() + " it's your turn \n";
        }else{
            return turn(n, player.getNextP());
        }
    }

    public int endGame(int nRow, int nColumn){
        return endGame(root,nRow, nColumn,1);
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

        Player playerTurn = findP(root, turn);
        return throwDice(n, max, playerTurn);
    }

    private int throwDice(int n, int max, Player player) {

        int newPosition = player.getSquare() + n;
        if (newPosition == max) {
            return -1;
        } else if (newPosition > max) {
            return -2;
        } else {
            return newPosition;
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
        Player playerTurn = findP(root, turn);
        playerTurn.setSquare(n);
        return "Player has moved";
    }

    public String inOrderToString(){
        return "[" + inOrderToString() + "]";
    }

    public String printPlayer(int position) {
        String msg = "";
        return printPlayer(position, root, msg, 1);
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

    public double calScore(Double seconds, int turn){
        Player playerscore = findP(root, turn);
        return calScore(seconds, playerscore, 0);
    }

    private double calScore(Double seconds, Player player, double score){
        score = (600 - seconds) / 6;


        return score;
    }

    public void podium(){
        bstScore.inOrderString();
    }

    
}
