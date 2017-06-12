package app.project.demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
 
public class Robot2 {
     
    public static void main(String[] args) {
         
        try {
             
            Robot robot = new Robot();
            // Creates the delay of 5 sec so that you can open notepad before
            // Robot start writting
            robot.delay(5000);
            robot.keyPress(KeyEvent.VK_H);
            robot.keyPress(KeyEvent.VK_I);
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyPress(KeyEvent.VK_P);
            robot.keyPress(KeyEvent.VK_R);
            robot.keyPress(KeyEvent.VK_E);
            robot.keyPress(KeyEvent.VK_M);
             
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}