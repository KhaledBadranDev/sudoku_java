package src.start;

import java.util.Scanner;
import src.util.*;
/**
 * This class simulates the sudoku game 
 * This class extends the sudokufield class   
 * 
 * @author  Khaled Badran <gym4programming@gmail.com>
 * @version 19 May 2020  
*/
public class Play extends src.model.SudokuField{
    /** 
     *  these all fields are "private" because other classes should not access them directly,
     *  rather with setter and getter. 
    */ 
    /** row is the x axis of the cell*/
    /** column is the y axis of the cell*/
    /** value is the value of the cell*/
    private int row, column, value;
    private String command; /** A String to store the commands of the user*/ 
    private String oldLayout; /** A String to store the layout of the old sudokufield. */
    private Scanner scan = new Scanner(System.in); /**to scan value from the user */
    
    /**
     * Cunstroctor that accepts 2d array
     * it calls the Cunstroctor of the SudokuField
     * to initialize the sudokufield with the values of the 2d array
     * 
     * "public" beause Cunstroctors should always be public 
     * @author  Khaled Badran <gym4programming@gmail.com>
     * @param f 2d array that has the initiate values of the sudokufield.
    */
    public Play(byte[][] f){
        super(f);
    }
    /**
     * "private" cause it would only be used in this class.
     * to scan the commands from the user
     * @author  Khaled Badran <gym4programming@gmail.com>
    */
    private void getData(){
        this.command = scan.next();
        this.row = scan.nextInt();
        this.column = scan.nextInt();
        this.value = scan.nextInt();  
    }    

    /**
     * to check weather the sudokufield is completely full or still has an empty cell.
     * "private" cause it would only be used in this class.
     * @author  Khaled Badran <gym4programming@gmail.com>
     * @return weather the field is empty or not
    */
    private boolean isfieldfull(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(this.getCellVal(i, j) == -1) return false; //if only one cell is still empty then field still not full 
            }
        }
        return true;
    }

    /**
     * to print the sudokufield and the instructions to the user 
     * to show the user which commands are accepted  
     * "private" cause it would only be used in this class.
     * @author  Khaled Badran <gym4programming@gmail.com>
    */
    private void printWithInstructions(){
        Util.cls(); //to clear the  screan 
        System.out.println("\nenter your command in one of the following forms:");
        System.out.println( 
                            "enter <row> <column> <value> /or\n"+
                            "mark <row> <column> <value> /or\n"+
                            "unmark <row> <column> <value> /or\n"+
                            "viewmarks <row> <column> 0 /or\n"+
                            "exit 0 0 0"
        );
        System.out.println(this); //to print the field
    }

    /**
     * executes the game 
     * stops the game if the sudokufield is full or if the player wants to exit the game.
     * @author  Khaled Badran <gym4programming@gmail.com>
    */
    public void start(){
        printWithInstructions();

        boolean execute = true;
        this.oldLayout = this.toString();
        
        while(!isfieldfull() && execute){
            this.getData();
            switch(command){
                case "enter": this.setCellVal(row, column, value);  break;
                case "mark": this.mark(row, column, value);         break;
                case "unmark":  this.unmark(row, column, value);    break;
                case "viewmarks": this.viewMarks(row, column);      break;
                case "exit" : execute = false;                      break;
                default : System.out.println("your command isn't valid");   
            }

            if(!this.oldLayout.equals(this.toString())) { //to check weather there is a new value entered or not. If yes, the field should be printed again including this new value
                printWithInstructions();
                this.oldLayout = this.toString();
            }

        }
        //if the sudokufield is completely full that means the playes has won. 
        if(isfieldfull()) System.out.println("YOU WIN!! :) YAHOO :)");
        
    }

    
}