package src.model;
/**
 * This class represents the cell/tile of the sudokufield
 * the sudokufield has 9*9 Cells 
 * 
 * @author  Khaled Badran <gym4programming@gmail.com>
 * @version 19 May 2020  
*/
class Cell extends Position{
    /** 
     *  these fields are "private" because other classes should not access them directly,
     *  rather with setter and getter. 
    */ 
    private int value; /**value of the cell*/
    private int[] markArr = new int[5]; /**array for marking values for every single cell */

    /**
     * Cunstroctor that sets the position of the cell and
     * initializes it as an empty cell with an empty array of marked values.
     * "public" beause Cunstroctors should always be public 
     * @author  Khaled Badran <gym4programming@gmail.com>
     * @param x x axis of the cell
     * @param y y axis of the cell
     */
    public Cell(int x, int y) {
        super(x, y); //assigning the position
        this.value = -1; //initiates the value of the Cell with -1 (empty).
        for(int i = 0; i < markArr.length; i++)
            this.markArr[i] = -1; //initiates the values of the Marking array with -1 (empty).
    }

    /**
     * sets the value of the cell with given value
     * "public" so that we can access the private fields without calling them directly. 
     * @author  Khaled Badran <gym4programming@gmail.com>
     * @param value to be assigned to cell 
     */
    public void setValue(int value) {
        this.value = value;
    }
    /**
     * gets the value of a cell
     * "public" so that we can access the private fields without calling them directly. 
     * @author  Khaled Badran <gym4programming@gmail.com>
     * @return value of the cell
     */
    public int getValue() {
        return value;
    }
    /**
     * mark/store given value to the array of marked values.
     * "protected" because it should only be accessible to the inheriting classes
     * @author  Khaled Badran <gym4programming@gmail.com>
     * @param value
     * @return  weather the value is successfully marked or not.
     */
    protected boolean markValue(int value){
        for(int i = 0; i < markArr.length; i++){
            if(markArr[i] == value)  break;//avoid adding tha same value
            if (markArr[i] == -1) {
                this.markArr[i] = value;
                return true;
            }
        }   
        return false; 
    }

    /**
     * remove the given value from the array of marked values 
     * "protected" because it should only be accessible to the inheriting classes
     * @author  Khaled Badran <gym4programming@gmail.com>
     * @param value
     * @return  weather the value is successfully removed or not
     */
    protected boolean unmarkValue(int value){
        for(int i = 0; i < markArr.length; i++){
            if(markArr[i] == value) {
                markArr[i] = -1; 
                this.fixIndices();
                return true;
            }    
        }
        return false;
    }

    /**
     * fixes the indices of the array of marked values 
     * by removing the -1 value from first places and puts it in the back
     * "private" cause it would only be used in this class.
     * @author  Khaled Badran <gym4programming@gmail.com>
     */
    private void fixIndices(){ //it fixes the indices of the marking arr by removing the -1 value from first places and puts it in the back
        for(int i = 0; i < markArr.length-1; i++){
            int next = i+1;
            if (markArr[i] == -1 && markArr[next] != -1){ //swap 
                markArr[i] = markArr[next];
                markArr[next] = -1;
            }
        }
    }

    /**
     * stores the array of marked values in a string so we can print it later.
     * "protected" because it should only be accessible to the inheriting classes
     * @author  Khaled Badran <gym4programming@gmail.com>
     * @return  the formatted string 
     */
    protected String printMarkArr(){
        String s = "[";
        
        if (markArr[0] == -1) { //if the first element of the marking array is empty that means the whole array is empty as well.
            s += "]";
            return s;
        }

        for(int i = 0; i < markArr.length; i++)
            if (markArr[i] != -1) s += String.valueOf(markArr[i]) + ", "; 
        s += "\b\b]"; //to remove the space and the comma before the closing brackets 
            
        return s;
    }

}
