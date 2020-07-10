/*
 * calculate days between two dates without import util.date util.calender time.localdate
 * MainClass to call Java swing view DateDemoView
 * The result shown on the view is calculated by CalcResult class
 */
package javacode;

import javax.swing.SwingUtilities;

/**
 *
 * @author Julia
 */
public class MainClass {
        public MainClass() {
        DateDemoView demo = new DateDemoView();
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainClass();
            }
        });
    }
    
}
