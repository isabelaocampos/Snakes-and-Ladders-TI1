package model;

public class Node {

	private int value;
	private Node next; 
	private Node previous; 
	private Snake snake;
	private Ladder ladder;

	public Node(int value) {
		this.value = value;
		this.snake = null;
		this.ladder = null;
	}
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	@Override
	public String toString(){
		return "My value is: " + value; 
	}

	public void createTheSnake(String symbol){
		this.snake = new Snake(symbol);
	}

	public void createTheLadder(int value){
		this.ladder= new Ladder(value); 
	}

	public int allTributesNull(){
		if(snake != null && ladder!= null){
			return 0;
		}
		return 1;
	}

	public Snake getSnake(){
		return snake;
	}

	public void setSnake(Snake snake){
		this.snake = snake;
	}

	public Ladder getLadder(){
		return ladder;
	}


	public String getSymbolOfSnake(){
		return snake.getSymbol();
	}

	public int getNumberStair(){
		return ladder.getNumber();
	}

}