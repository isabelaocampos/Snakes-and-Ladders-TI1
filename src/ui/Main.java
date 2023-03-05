package ui;

import model.*;

import java.util.Scanner;



public class Main{
    private Scanner reader;
    private Controller controller;
    
    
    public Main(){
        this.reader = new Scanner(System.in);
    }

    public Scanner getReader(){
        return reader;
    }

    public static void main(String[] args){
        Main main = new Main();

        int option = 0; 

				do{
					option = main.getOptionShowMenu(); 
					main.executeOption(option);

				}while(option != 0);

				main.getReader().close();
	}
	
	public int getOptionShowMenu(){
		int option = 0; 
		System.out.println("<<<<< Welcome to Snakes and Ladders >>>>>");
		System.out.println(
				"1. Play");
		option = reader.nextInt(); 

		return option; 
	}

    public void executeOption(int option){
    

        switch(option){
            case 1: 
            System.out.println("You are about to play snakes and ladders");
             

            

            break;
            case 2:
            
            
            
            break;
            case 3:
            
            break;
            case 4: 

            break;

            case 5: 
            
            break;

            case 6:
            break;
            
            case 7:
            break;
            
            case 8: 
            

            break;

            case 9:

            break;

            case 0:

            break;

            default:

            break;


        }
    }

    ////////////////

    /**
	 * validateIntergerInput: This method validates that the input is an interger
	 * @return option: Is the input by the user or the number -1 to represent that is not an interger 
	 */
    public int validateIntegerInput(){
		int option = 0; 

		if(reader.hasNextInt()){
			option = reader.nextInt(); 
		}
		else{ 
			reader.nextLine(); 
			option = -1; 
		}

		return option; 
	}

	
}