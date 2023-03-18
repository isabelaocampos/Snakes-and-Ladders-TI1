package ui;

import model.*;

import java.util.Scanner;



public class Main{
    private Scanner reader;
    private Controller controller;
    
    
    public Main(){
        this.reader = new Scanner(System.in);
        controller = new Controller();
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
				"1. Play \n" +
                "2. Exit");

		option = reader.nextInt(); 

		return option; 
	}

    public int getOptionShowMenu2(){
        int option2 = 0; 
		System.out.println("<<<<< Time to play >>>>>");
		System.out.println(
				"1. Throw dice \n" +
                "2. See snakes and ladders");
		option2 = reader.nextInt(); 

	    return option2;
    }

    public void executeOption2(int option2){
        switch(option2){
            case 1: 
            System.out.println("\n You are about to throw a dice");

            break;
            case 0: 
            System.out.println("This are the snakes and ladders in the game");

            break;

            default:
            System.out.println("Invalid Option");
            break;
        }
    }

    public void executeOption(int option){
        

        switch(option){
            case 1: 
            System.out.println("You are about to play snakes and ladders");
            createBoard();
            createPlayer(1);
            System.out.println("Time to play!");
            //printboard();

            int option2 = 0;
            while(option2 != 0){
                option2 = getOptionShowMenu2();
                executeOption2(option2); 


            }
            case 0:
            System.out.println("Exit program.");
        
            break;
            default:

            break;


        }
    }

    public void createBoard(){
        int columns, rows, snakes, ladders = 0;

        
        System.out.println("Write the amount of columns the grid is going to have: ");
        columns = reader.nextInt();
        System.out.println("Write the amount of rows the grid is going to have: ");
        rows = reader.nextInt();
        System.out.println("Write the amount of snakes that are going to be on the grid: ");
        snakes = reader.nextInt();
        System.out.println("Write the amount of ladders that are going to be on the grid: ");
        ladders = reader.nextInt();
        controller.createGame(rows, columns, snakes, ladders);
    }

    public void createPlayer(int counter){
        System.out.println("Let's register the players");

        if(counter == 1){
            System.out.println("Player 1, your id will be *");
            controller.addPlayer("*", counter);
            counter++;
        }if(counter == 2){
            System.out.println("Player 2, your id will be !");
            controller.addPlayer("!", counter);
            counter++;
        }if(counter == 3){
            System.out.println("Player 3, your id will be #");
            controller.addPlayer("#", counter);
            counter++;
        }else if(counter == 4){
            System.out.println("All players registered");
        }else{
            System.out.println("Invalid option");
        }

    }

    ////////////////


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