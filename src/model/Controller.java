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
    private Double seconds;


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


    public void addPlayer( String id, int turn) {
        pBst.insert(id, turn);
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
            seconds = duration.toNanos() / 1_000_000_000.0;
        } else if (position_P == -2) {
            msg = "You landed a higher number than expected, try again in your next turn";
            turn = newTurn(turn);

        } else {
            System.out.println("Your dice landed in the number" + num + "\n");
            int position = slPosition(position_P);
            msg = pBst.setPosition(position, turn);
            turn = newTurn(turn);

            return msg;
        }

        return msg;
    }

    public String printGrid() {
        String msg = "";

        int total = grid.getNcolumn() * grid.getNrow();

        if (grid.getNcolumn() % 2 == 0) {
            msg = print(total, total - grid.getNrow() + 1, 0, msg, grid.getNcolumn() - 1, true);
        } else {
            msg = print(total - grid.getNrow() + 1, total, 1, msg, grid.getNcolumn(), true);
        }

        return msg;
    }

    private String print(int int1, int int2, int counter, String msg, int row, boolean type) {

        if (counter <= row) {
            if (counter % 2 == 0) {
                msg = printHiToLo(int1, int2, msg, type) + "\n";
                int x = int2 - grid.getNrow();
                int y = int1 - grid.getNrow();
                return print(x, y, ++counter, msg, row, type);
            } else {
                msg = printLoToHi(int1, int2, msg, type) + "\n";
                int x = int2 - grid.getNrow();
                int y = int1 - grid.getNrow();
                return print(x, y, ++counter, msg, row, type);
            }
        }
        return msg;

    }

    private String printLoToHi(int int1, int int2, String msg, boolean type) {
        // menor a mayor
        if (type) {
            if (int1 <= int2) {
                msg += "[" + int1;
                msg += pBst.printPlayer(int1) + "]";
                return printLoToHi(++int1, int2, msg, type);
            } else {
                return msg;
            }
        } else {
            if (int1 <= int2) {
                msg += "[";
                msg += grid.gridSL(int1) + "]";
                return printLoToHi(++int1, int2, msg, type);
            } else {
                return msg;
            }
        }

    }

    private String printHiToLo(int int1, int int2, String msg, boolean type) {
        if (type) {
            if (int1 >= int2) {
                msg += "[" + int1;
                msg += pBst.printPlayer(int1) + "]";
                return printHiToLo(--int1, int2, msg, type);
            } else {
                return msg;
            }
        } else {
            if (int1 >= int2) {
                msg += "[";
                msg += grid.gridSL(int1) + "]";
                return printHiToLo(--int1, int2, msg, type);
            } else {
                return msg;
            }
        }

    }

    public int newTurn(int turn) {
        if (turn == 3) {

            return turn = 1;
        } else {
            return ++turn;
        }

    }

    public void calculateScore(){
        pBst.calScore(seconds,turn);
    }

    public int slPosition(int position_new) {

        return grid.slPosition(position_new);

    }
    
    public String playerTurn(){
        String msg = pBst.turn(turn);
        return msg;
    }
    

    
    public Player playerPosition(int val){
        Player player = null;
        return player;
    }
}
