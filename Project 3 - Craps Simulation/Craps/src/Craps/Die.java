package Craps;

/**
 * Class:        Die
 * File:	 Die.java
 * Description:	 A class to calculate random numbers of 1 through 6 to be used
 *               in the main class for when simulating a random dice rolls.
 * @author       Ryu Muthui
 * Created       02/26/2013, Last updated 03/06/2013.
 */

public class Die 
{
    final int MAX = 6,
              MIN = 1;
    int       dieValue = 0;
    
  /**
  * Default constructor -- creates a new instance of Die class variables.
  */
    public Die()   
    //Default constructor and its value.
    {
        this.dieValue = 0;             
    }
        /**
         * A method to obtain a random number between 1 and 6 and store it in
         * the "dieValue" integer variable to be called in the Main GUI.
         * @return dieValue
         */
        public int getDieValue()
        {
        dieValue = (int) (Math.random() * MAX)+ MIN;
        return dieValue;
        }  
}
    
        
  