package model;

public class Ladder {

    private int id;
    private String bottom;
    private String top;
    private int number;
    
    public Ladder(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }
    public int getNumber(){
        return number;
    }
    public void setNumber (int number){
        this.number = number;
    }

}
