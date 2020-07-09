/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacode;

import javax.swing.SwingUtilities;

/**
 *
 * @author Julia
 */
public class MainClass {
        public MainClass() {
        DateDemo demo = new DateDemo();
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainClass();
            }
        });
    }
    
}
