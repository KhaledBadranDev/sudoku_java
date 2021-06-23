
package src.model;
/**
 * This class represents the position of a cell in the sudokufield
 * the position consists of the x axis and y axis
 * 
 * default because it should only be called only in the same package. 
 * @author  Khaled Badran <gym4programming@gmail.com>
 * @version 19 May 2020  
*/
class Position{
    /** 
     *  these fields are "private" because other classes should not access them directly,
     *  rather with setter and getter. 
    */ 
    private int x; /** x axis of the cell*/
    private int y; /** y axis of the cell*/

    /**
     * Cunstroctor that sets the given values to the x and y axis.
     * 
     * "public" beause Cunstroctors should always be public 
     * @author  Khaled Badran <gym4programming@gmail.com>
     * @param x  x axis of the cell
     * @param y  y axis of the cell
    */
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * gets the value of the x axis 
     * "protected" because it should only be accessible to the inheriting classes
     * @author  Khaled Badran <gym4programming@gmail.com>
     * @return value of the x axis
     */
    protected int getX() {
        return this.x;
    }

    /**
     * gets the value of the y axis 
     * 
     * "protected" because it should only be accessible to the inheriting classes
     * @author  Khaled Badran <gym4programming@gmail.com>
     * @return value of the y axis
     */
    protected int getY() {
        return this.y;
    }

}