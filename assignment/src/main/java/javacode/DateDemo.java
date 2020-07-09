/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Julia
 */
public class DateDemo extends JFrame implements ActionListener {
    int[] newDate1 = new int[]{};
    int yearNum1 = 0;
    int monthNum1 = 1;
    int dayNum1 = 1;
    
    int[] newDate2 = new int[]{};
    int yearNum2 = 0;
    int monthNum2 = 1;
    int dayNum2 = 1;
    
    JFrame frame = new JFrame();
    JPanel totalP = new JPanel();
    JPanel date = new JPanel();
    JPanel result = new JPanel();
    JButton confirm = new JButton("OK");
    JTextArea resultText = new JTextArea("result");
    
    JTextArea year1 = new JTextArea("year 1");
    JTextArea month1 = new JTextArea("month 1");
    JTextArea day1 = new JTextArea("day 1");
    JTextArea yearText1 = new JTextArea("2020");
    private JComboBox dropListMonth1 = new JComboBox();
    private JComboBox dropListDay1 = new JComboBox();
    
    JTextArea year2 = new JTextArea("year 2");
    JTextArea month2 = new JTextArea("month 2");
    JTextArea day2 = new JTextArea("day 2");
    JTextArea yearText2 = new JTextArea("2020");
    private JComboBox dropListMonth2 = new JComboBox();
    private JComboBox dropListDay2 = new JComboBox();
    public DateDemo() {

        year1.setEditable(false);
        month1.setEditable(false);
        day1.setEditable(false);
        year2.setEditable(false);
        month2.setEditable(false);
        day2.setEditable(false);
        
        totalP.setLayout(new BorderLayout());
        date.setLayout(new GridLayout(0, 3));
        date.setBorder(new EmptyBorder(5, 5, 5, 5));
        result.setLayout(new GridLayout(0, 1));
        result.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        result.add(resultText);
        yearText1.setBackground(Color.lightGray);
        yearText2.setBackground(Color.lightGray);
        
        for(int i=1; i<=12; i++){
            dropListMonth1.addItem(i);
            dropListMonth2.addItem(i);
        }
        for(int i=1; i<=31; i++){
            dropListDay1.addItem(i);
            dropListDay2.addItem(i);
        }
        
        dropListMonth1.addActionListener(e -> {
                String getYear1 = yearText1.getText().trim();
                try{
                    yearNum1 = Integer.parseInt(getYear1);
                    monthNum1 = Integer.parseInt(((JComboBox) e.getSource()).getSelectedItem().toString());
                    
                    if(isLeapYear(yearNum1) && monthNum1 == 2){
                        dropListDay1.removeAllItems();
                        for(int i=1; i<=29; i++){
                            dropListDay1.addItem(i);
                        }
                    }
                    else if(!isLeapYear(yearNum1) && monthNum1 == 2){
                        dropListDay1.removeAllItems();
                        for(int i=1; i<=28; i++){
                            dropListDay1.addItem(i);
                        }
                    }
                    else if(monthNum1==1 || monthNum1==3 || monthNum1==5 || 
                            monthNum1==7 || monthNum1==8 || monthNum1==10 || monthNum1==12){
                        dropListDay1.removeAllItems();
                        for(int i=1; i<=31; i++){
                            dropListDay1.addItem(i);
                        }
                    }
                    else{
                        dropListDay1.removeAllItems();
                        for(int i=1; i<=30; i++){
                            dropListDay1.addItem(i);
                        }
                    } 
                }catch(NumberFormatException ex){
                    resultText.setText("Wrong number in year 1.");
                }
                
            
        });

        dropListDay1.addActionListener(ea -> {
                String getYear1 = yearText1.getText().trim();
                try{
                    yearNum1 = Integer.parseInt(getYear1);
                    resultText.setText(((JComboBox) ea.getSource()).getSelectedItem()+"");
                    dayNum1 = Integer.parseInt(resultText.getText());
                    resultText.setText("");
                }catch(NumberFormatException ex){
                    resultText.setText("Wrong number with year 1.");
                }
                
            
        });
        dropListMonth2.addActionListener(ec -> {
                String getYear2 = yearText2.getText().trim();
                try{
                    yearNum2 = Integer.parseInt(getYear2);
                    monthNum2 = Integer.parseInt(((JComboBox) ec.getSource()).getSelectedItem().toString());
                    
                    if(isLeapYear(yearNum2) && monthNum2 == 2){
                        dropListDay2.removeAllItems();
                        for(int i=1; i<=29; i++){
                            dropListDay2.addItem(i);
                        }
                    }
                    else if(!isLeapYear(yearNum2) && monthNum2 == 2){
                        dropListDay2.removeAllItems();
                        for(int i=1; i<=28; i++){
                            dropListDay2.addItem(i);
                        }
                    }
                    else if(monthNum2==1 || monthNum2==3 || monthNum2==5 || 
                            monthNum2==7 || monthNum2==8 || monthNum2==10 || monthNum2==12){
                        dropListDay2.removeAllItems();
                        for(int i=1; i<=31; i++){
                            dropListDay2.addItem(i);
                        }
                    }
                    else{
                        dropListDay2.removeAllItems();
                        for(int i=1; i<=30; i++){
                            dropListDay2.addItem(i);
                        }
                    } 
                }catch(NumberFormatException ex){
                    resultText.setText("Wrong number in year 2.");
                }
                
            
        });

        dropListDay2.addActionListener(eb -> {
                String getYear2 = yearText2.getText().trim();
                try{
                    yearNum2 = Integer.parseInt(getYear2);
                    resultText.setText(((JComboBox) eb.getSource()).getSelectedItem()+"");
                    dayNum2 = Integer.parseInt(resultText.getText());
                    resultText.setText("");
                }catch(NumberFormatException ex){
                    resultText.setText("Wrong number with year 2.");
                }
                
            
        });
        
        confirm.addActionListener(cl -> {
            try{
                int getYear1 = Integer.parseInt(yearText1.getText().trim());
                int[] dateString1 = {getYear1, monthNum1, dayNum1};
                int getYear2 = Integer.parseInt(yearText2.getText().trim());
                int[] dateString2 = {getYear2, monthNum2, dayNum2};

                if(!checkDate(dateString1)) resultText.setText("Wrong number in date 1.");
                else if(!checkDate(dateString2)) resultText.setText("Wrong number in date 2.");
                else{
                    ShowResult result = new ShowResult();
                    
                    resultText.setText("result ... " + result.result(dateString1, dateString2));
                }
                
            }catch(NumberFormatException ex){
                resultText.setText("Wrong number with year.");
            }
        });

                
        date.add(year1);
        date.add(month1);
        date.add(day1);
        date.add(yearText1);
        date.add(dropListMonth1);
        date.add(dropListDay1);

        date.add(year2);
        date.add(month2);
        date.add(day2);
        date.add(yearText2);
        date.add(dropListMonth2);
        date.add(dropListDay2);


        totalP.add(date, BorderLayout.NORTH);
        totalP.add(confirm, BorderLayout.CENTER);
        totalP.add(result, BorderLayout.SOUTH);
        totalP.setPreferredSize(new Dimension(400, 180));
        frame.add(totalP);
        frame.pack();
        frame.setLocation(600, 50);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public boolean isLeapYear(int year){
        if(year%4 == 0 && year%100 != 0){
            return true;
        }
        else if(year%100 == 0 && year%400 == 0){
            return true;
        }
        else{
            return false;
        }               
    }
    
    public boolean checkDate(int[] date1){
        int checkYear = date1[0];
        int checkMonth = date1[1];
        int checkDay = date1[2];
        if(isLeapYear(checkYear) && checkMonth == 2){
            if(checkDay>=1 && checkDay<=29) return true;
        }
        else if(!isLeapYear(checkYear) && checkMonth == 2){
            if(checkDay>=1 && checkDay<=28) return true;            
        }
        else if(checkMonth==1 || checkMonth==3 || checkMonth==5 || 
                checkMonth==7 || checkMonth==8 || checkMonth==10 || checkMonth==12){
            if(checkDay>=1 && checkDay<=31) return true;  
        }
        else{
            if(checkDay>=1 && checkDay<=30) return true;  
        }
        return false;
    }
}
