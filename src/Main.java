
package src;

import src.start.Play;

/**
 * The is the Main class
 * 
 * This class contains the main method, where we can list the tasks   
 * of the whole program 
 * @author  Khaled Badran <gym4programming@gmail.com>
 * @version 19 May 2020  
*/
public class Main{
    /**
     * The is the Main method.
     * 
     * In this method we can list the tasks of the program   
     *
     * @author  Khaled Badran <gym4programming@gmail.com>
     * @version 19 May 2020  
     * @param args an array of Strings 
    */
    public static void main(String[] args){
        byte[][] sudoku1 = {
            {-1,  6, -1, -1, -1, -1,  4,  2,  5},
            { 5,  7, -1, -1, -1, -1, -1,  8,  1},
            {-1, -1, -1,  4,  3, -1,  9, -1, -1},
            {-1,  5, -1,  9,  2, -1, -1,  7,  4},
            {-1, -1, -1,  3,  8,  4, -1, -1, -1},
            { 8,  4, -1,  5,  6,  7, -1,  9, -1},
            {-1, -1,  2, -1,  1, -1, -1, -1, -1},
            {-1,  3,  9, -1, -1,  6,  7, -1,  8},
            {-1, -1, -1, -1, -1,  9,  6, -1, -1}
        };

        Play game = new Play(sudoku1);
        game.start();
        
    }

}
