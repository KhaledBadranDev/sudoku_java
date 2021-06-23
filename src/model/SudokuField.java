package src.model;

/**
 * This class represents the sudokufield 
 * the sudokufield has 9*9 Cells 
 * 
 * public because it should be called in the Play class, which is in different package. 
 * @author  Khaled Badran <gym4programming@gmail.com>
 * @version 19 May 2020  
*/
public class SudokuField{
    /** 
     *  2d array that has all the values of the Sudoku field 
     *  "private" because other classes should not access it directly, rather with setter and getter. 
    */ 
    private Cell[][] field = new Cell[9][9]; // the playing field 
    
    /**
     * Cunstroctor that accepts 2d array
     * it initializes the sudokufield with the values of the 2d array
     * 
     * "public" beause Cunstroctors should always be public 
     * @author  Khaled Badran <gym4programming@gmail.com>
     * @param f 2d array that has the initiate values of the sudokufield.
    */
    public SudokuField(byte[][] f){
        //checking number of rows
        if(f.length != 9){ System.err.println("The playing field isn't valid"); System.exit(2); }
        //checking number of cols per each row
        for(int i = 0; i < 9; i++) 
            if(f[i].length != 9){ System.err.println("The playing field isn't valid"); System.exit(2); }
        //now the field is valid 
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                this.field[i][j] = new Cell(i,j); //assigning the position (x and y) to every single cell
                this.field[i][j].setValue(f[i][j]); //assigning the values 
            }
        }        
    }

    /**
     * sets a cell at a specific index/position with the given value
     * "public" so that we can access the private fields in the different classes
     * @author  Khaled Badran <gym4programming@gmail.com>
     * @param x x axis of the cell
     * @param y y axis of the cell
     * @param value value of the cell
     * @return weather the cell got the new value or not 
     */
    public boolean setCellVal(int x, int y, int value){
        if(isValid(x, y, value)){
            this.field[x][y].setValue(value);
            return true;
        }
        
        System.out.println("Invalid entry.");    
        return false;
    }

    /**
     * gets the value of a cell at a specific index/position
     * "public" so that we can access the private fields in the different classes
     * @author  Khaled Badran <gym4programming@gmail.com>
     * @param x x axis of the cell
     * @param y y axis of the cell
     * @return the value of the cell
     */
    public int getCellVal(int x, int y){
        return this.field[x][y].getValue();
    }

    /**
     * checks weather the position and the value are valid to be assigned or not 
     * "private" cause it would only be used in this class.
     * @author  Khaled Badran <gym4programming@gmail.com>
     * @param x  x axis of the cell
     * @param y  y axis of the cell
     * @param value value of the cell
     * @return weather the position and the value are valid  
     */
    private boolean isValid(int x, int y, int value){
        if (value < 1 || value > 9) return false;
        for(int i = 0; i < 9; i++){ //if the value already exists in same row or column
            if(field[x][i].getValue() == value || field[i][y].getValue() == value) return false;
        }
        if(!isValidInSquare(x, y, value)) return false; //if the value already exists in its 3x3 square
        return true;
    }

    /**
     * checks weather  the value already exists in its 3x3 square or not.
     * "private" cause it would only be used in this class.
     * @author  Khaled Badran <gym4programming@gmail.com>
     * @param x  x axis of the cell
     * @param y  y axis of the cell
     * @param value value of the cell
     * @return weather the value already exists in its 3x3 square or not.
     */
    private boolean isValidInSquare(int x, int y, int value){ //to check weather the value already exists in its 3x3 square or not.
        int rows = -1; //the index of rows from which the loop will start.
        int cols = -1; //the index of cols from which the loop will start.
        
        if (x < 3) rows = 0; //rows will get its value depending on the value of x 
        else if(x < 6) rows = 3;
        else if(x < 9) rows = 6;

        if (y < 3) cols = 0; //cols will get its value depending on the value of y
        else if(y < 6) cols = 3;
        else if(y < 9) cols = 6;
        //now we know in which square we should compare and check the values.
        int limitCols = cols+3; //where the loop of cols should stop
        int holdCols = cols;    //to reassign the value of cols in each row. 
        for(int limitRows = rows+3; rows < limitRows; rows++){
            for(cols = holdCols; cols < limitCols; cols++){
                if (field[rows][cols].getValue() == value) return false;
            }    
        }        
        
        return true;
    }

    /**
     * mark values for a specific cell
     * so that we can later choose from the array of the marked values the accurate one. 
     * "public" because it should be called in the Play class, which is in different package. 
     * @author  Khaled Badran <gym4programming@gmail.com>
     * @param x  x axis of the cell
     * @param y  y axis of the cell
     * @param value value of the cells
     * @return weather the value is successfully marked or not.
     */
    public boolean mark(int x, int y, int value){
        if(this.field[x][y].markValue(value)){
            System.out.printf("Marked Value %d for (%d: %d)\n", value, x, y);
            return true;
        } 
         
        System.out.printf("Value %d was already marked for (%d: %d)\n", value, x, y);
        return false;
    }

    /**
     * remove the given value from the array of marked values of a specific cell
     * "public" because it should be called in the Play class, which is in different package. 
     * @author  Khaled Badran <gym4programming@gmail.com>
     * @param x  x axis of the cell
     * @param y  y axis of the cell
     * @param value value of the cells
     * @return weather the value is successfully removed or not
     */
    public boolean unmark(int x, int y, int value){
        if(this.field[x][y].unmarkValue(value)){
            System.out.printf("Unmarked Value %d for (%d: %d)\n", value, x, y);
            return true;
        }    

        System.out.printf("Value %d doesn't exist for (%d: %d)\n", value, x, y);
        return false;
    }

    /**
     * prints the array of marked values for a specific cell
     * "public" because it should be called in the Play class, which is in different package. 
     * @author  Khaled Badran <gym4programming@gmail.com>
     * @param x  x axis of the cell
     * @param y  y axis of the cell
     */
    public void viewMarks(int x, int y){
        System.out.println(field[x][y].printMarkArr()); 
    }

    /**
     * stores the playing field in a String so that we can print it later.
     * "public" because it is already implemented like that in the Object.java class 
     * @author  Khaled Badran <gym4programming@gmail.com>
     * @return the formated string
     */
    @Override
    public String toString(){
        String s = "   **SUDOKU GAME**\n";

        s += " |0 1 2|3 4 5|6 7 8|";
        s += "\n-+-----+-----+-----+\n";
        
        for(int i = 0; i < 9; i++){
            s += String.valueOf(i) + "|";

            for(int j = 0, count = 1; j < 9; j++,count++){
                if (this.field[i][j].getValue() == -1) s += " ";
                else s +=  String.valueOf(this.field[i][j].getValue());
                if (count == 3){
                    s += "|";
                    count = 0;
                }else s += " ";
            }
            s += "\n";
            
            if(i+1 == 3 || i+1 == 6 || i+1 == 9) s += "-+-----+-----+-----+\n"; 
            else s += " |     |     |     |\n";
        }
        return s;
    }
}
