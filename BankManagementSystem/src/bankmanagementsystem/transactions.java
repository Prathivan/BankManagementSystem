package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class transactions extends JFrame implements ActionListener{
    
    JButton deposite,fastcash,pinchange,cashwithdrawl,ministatement,balanceenquirey,exit;
    String pinnumber;
    transactions(String pinnumber) {
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,900,900);
        add(img);
        
          JLabel text=new JLabel("PLEASE SELECT YOUR TRANSACTION");
        text.setBounds(190,300,400,15);
        text.setForeground(Color.white);
        text.setFont(new Font("TimesNewRoman",Font.BOLD,15));
        img.add(text);
          deposite=new JButton("DEPOSITE");
        deposite.setBounds(156,420,160,30);
        deposite.addActionListener(this);
        img.add(deposite);
          fastcash=new JButton("FASTCASH");
        fastcash.setBounds(156,450,160,30);
        fastcash.addActionListener(this);
        img.add(fastcash);
          pinchange=new JButton("PIN CHANGE");
        pinchange.setBounds(156,480,160,30);
        pinchange.addActionListener(this);
        img.add(pinchange);
          cashwithdrawl=new JButton("CASH WITHDRAWL");
        cashwithdrawl.setBounds(358,420,160,30);
        cashwithdrawl.addActionListener(this);
        img.add(cashwithdrawl); 
        ministatement=new JButton("MINI STATEMENT");
        ministatement.addActionListener(this);
        img.add(ministatement);
          balanceenquirey=new JButton("BALANCE ENQUIREY");
        balanceenquirey.setBounds(358,450,160,30);
        balanceenquirey.addActionListener(this);
        img.add(balanceenquirey);
          exit=new JButton("EXIT");
        exit.setBounds(358,480,160,30);
        exit.addActionListener(this);
        img.add(exit);
        
        setSize(900,900);
        setLocation(300,10);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){
            System.exit(0);
        }else if(ae.getSource()==deposite){
            setVisible(false);
            new deposite(pinnumber).setVisible(true);
        }else if(ae.getSource()==cashwithdrawl){
            setVisible(false);
            new withdraw(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new fastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new pinchange(pinnumber).setVisible(true);
        }else if(ae.getSource()==balanceenquirey){
            setVisible(false);
            new balanceEnquiry(pinnumber).setVisible(true);
        }   
   
    }
    
    public static void main(String args[]) {
        new transactions("");
    }
}
