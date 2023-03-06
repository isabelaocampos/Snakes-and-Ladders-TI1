package model;

public class CircularListPlayers {
    private NodeCircularList head;
    private NodeCircularList tail;
    private int size;
    private int passedTurn;

    public CircularListPlayers(){
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public NodeCircularList getHead(){
        return head;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addNode(NodeCircularList node){
        if(head == null){
            head = node;
            head.setNext(head);
            head.setPrevious(head);
            size = 1;
        }else{
            NodeCircularList tail = head.getPrevious();
            node.setNext(head);
            head.setPrevious(node);
            tail.setNext(node);
            node.setPrevious(tail);
            size++;
        }
    }

    public void print(){
        if(head == null){
            System.out.println("Lista vacia");
        }else{
            print(head);
        }
    }

    private void print(NodeCircularList current){
        if(current == head.getPrevious()){
            System.out.println(current.getName());
            return;
        }
        System.out.println(current.getName());
        print(current.getNext());
    }

    public void delete(int string){
        if(head == null){
            System.out.println("Lista vacia");
        }else if(head == head.getNext()){
            head = null;
        }
        else{
            delete(head, string);
        }
    }

    private void delete(NodeCircularList current, int goal){
        if(current.getName() == goal){
            if(current == head){
                head.getPrevious().setNext(head.getNext());
                head.getNext().setPrevious(head.getPrevious());
                head = head.getNext();
            }else{
                NodeCircularList prev = current.getPrevious();
                NodeCircularList next = current.getNext();
                prev.setNext(next);
                next.setPrevious(prev);
            }
            return;
        }
        if(current.getNext() == head){
            return;
        }
        delete(current.getNext(), goal);

    }
    public String printList(){
		return printList(this.head, "[ "); 
	}

    public void printHead(){
        if(head.getNext() == null){
            System.out.println("No hay turnos");
        }
        else{
            System.out.print("Turno #: " + getHead().toString());
            return;
        }

    }

	private String printList(NodeCircularList current, String msj){
		if(this.head == null){
			return "Empty list";		
		}
		if(current == this.tail){
			msj += tail.getName() + " ]";
			return msj; 
		}

		msj += current.getName() + " "; 
		return printList(current.getNext(), msj); 
	}

    public void nextTurn(NodeCircularList current ){
        if(current.getNext() == null){
            System.out.println("No hay mas turnos");
            return;
        }
        if(passedTurn == 3){
            delete(current, passedTurn);
            passedTurn = 0;

        }else{
            //current = this.head;
            current = current.getNext();
            System.out.println("El siguiente turno es: " + current);
            passedTurn++;
            
            return;

        }

    }

    





}
