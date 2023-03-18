package model;
import java.time.Duration;
import java.time.Instant;



public class Controller {

    private Grid grid;
    private PlayerBst pBst;
    private int turn;
    private Instant start;
    private Instant end;
    private Duration duration;
    private Double seg;


    public Controller(){
        pBst = new PlayerBst();
        turn = 1;
    }

    public Instant getStart() {
        return start;
    }

    public Instant getEnd() {
        return end;
    }

    public Duration getDuration() {
        return duration;
    }


    public void addPlayer( String symbol, int turn) {

        pBst.insert(symbol, turn, symbol);
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


    public String throwDice(){
        String msg = "";
        int num = grid.randomNumber(6);
        int position_P = pBst. throwDice(num, grid.getNcolumn() * grid.getNrow(), turn);
        System.out.println("The player new position will be " + position_P);
        if (position_P == -1) {

            end = Instant.now();
            duration = Duration.between(start, end);
            seg = duration.toNanos() / 1_000_000_000.0;
            // finish game
        } else if (position_P == -2) {
            msg = "te pasaste de la ultima casilla, vuelve a intentarlo en tu proximo tiro";
            turn = newTurn(turn);

        } else {
            System.out.println("su dado cayo en el numero " + num + "\n");
            int position = position_Analysis(position_P);
            msg = pBst.setPosition(position, turn);
            turn = newTurn(turn);

            return msg;
        }

        return msg;
    }

    public int newTurn(int turn) {
        if (turn == 3) {

            return turn = 1;
        } else {
            return ++turn;
        }

    }

    public int position_Analysis(int position_new) {

        return grid.position_Analysis(position_new);

    }
    
    

    
    public Player playerPosition(int val){
        Player player = null;
        return player;
    }
}
