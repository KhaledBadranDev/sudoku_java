package src.util;

import java.io.*;

/**
 * This class is to clear the screen.   
 * 
 * @author  Khaled Badran <gym4programming@gmail.com>
 * @version 19 May 2020  
*/
public class Util {
    
    /**
     * to clear the screen.   
     * 
     * @author  Khaled Badran <gym4programming@gmail.com>
    */
    public static void cls() {//to clear the screen 
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            // handle exception
            System.out.println(e);
        }
    }

}